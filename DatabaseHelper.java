package com.example.eliasteeny.likhascore;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eliasteeny on 7/22/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DBName = "Players.db";
    public static final String TableName="Players_Table";
    public static final String c0="ID";
    public static final String c11="NAME1";
    public static final String c12="SCORE1";
    public static final String c21="NAME2";
    public static final String c22="SCORE2";
    public static final String c31="NAME3";
    public static final String c32="SCORE3";
    public static final String c41="NAME4";
    public static final String c42="SCORE4";
    public DatabaseHelper(Context context){
        super(context,DBName,null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        String creatTable = "CREATE TABLE "+TableName+"("+c0+" INTEGER PRIMARY KEY,"+
                c11 +" TEXT,"+c12 +" INTEGER,"+
                c21+" TEXT,"+c22+ " INTEGER,"+
                c31+ " TEXT,"+c32 +" INTEGER,"+
                c41+" TEXT,"+c42 +" INTEGER)";
        db.execSQL(creatTable);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + TableName);
        onCreate(db);
    }
    public void insertData(DataScores DS){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(c11,DS.getName1());
        values.put(c12,DS.getScore1());
        values.put(c21,DS.getName2());
        values.put(c22,DS.getScore2());
        values.put(c31,DS.getName3());
        values.put(c32,DS.getScore3());
        values.put(c41,DS.getName4());
        values.put(c42,DS.getScore4());

        db.insert(TableName,null,values);
        db.close();
    }
    public List<DataScores> getData(){
        List<DataScores> data= new ArrayList<DataScores>();
        SQLiteDatabase DB=this.getWritableDatabase();
        String selectQuery = "SELECT * FROM " + TableName;
        Cursor cursor=DB.rawQuery(selectQuery,null);
        if(cursor.moveToFirst()){
            do{
                DataScores dataScores=new DataScores();
                dataScores.setid(Integer.parseInt(cursor.getString(0)));
                dataScores.setName1(cursor.getString(1));
                dataScores.setScore1(Integer.parseInt(cursor.getString(2)));
                dataScores.setName2(cursor.getString(3));
                dataScores.setScore2(Integer.parseInt(cursor.getString(4)));
                dataScores.setName3(cursor.getString(5));
                dataScores.setScore3(Integer.parseInt(cursor.getString(6)));
                dataScores.setName4(cursor.getString(7));
                dataScores.setScore4(Integer.parseInt(cursor.getString(8)));
                data.add(dataScores);
            }while(cursor.moveToNext());
        }
        return data;
    }
    public boolean updateData(DataScores data){
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues contentvalue = new ContentValues();

        contentvalue.put(c12,data.getScore1());
        contentvalue.put(c22,data.getScore2());
        contentvalue.put(c32,data.getScore3());
        contentvalue.put(c42,data.getScore4());

        db.update(TableName,contentvalue,c0+" =?",new String[]{String.valueOf(data.getid())});
        return true;
    }
    public DataScores getOneRow(int id){
        DataScores result = new DataScores();
        Cursor cursor = null;
        SQLiteDatabase db = this.getReadableDatabase();
        try{
            cursor=db.rawQuery("SELECT * FROM "+TableName+" WHERE ID=?",new String[]{id+""});
            if(cursor.getCount() > 0) {
                cursor.moveToFirst();
                result.setid(Integer.parseInt(cursor.getString(0)));
                result.setName1(cursor.getString(1));
                result.setScore1(Integer.parseInt(cursor.getString(2)));
                result.setName2(cursor.getString(3));
                result.setScore2(Integer.parseInt(cursor.getString(4)));
                result.setName3(cursor.getString(5));
                result.setScore3(Integer.parseInt(cursor.getString(6)));
                result.setName4(cursor.getString(7));
                result.setScore4(Integer.parseInt(cursor.getString(8)));
            }
            return result;
        }
        finally {
            cursor.close();
        }
    }
}
