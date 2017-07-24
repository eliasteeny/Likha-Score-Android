package com.example.eliasteeny.likhascore;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText E5,E6,E7,E8;
    String S1,S2,S3,S4,s5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void names(View view){
        Intent intent = new Intent(this, Scores.class);

        E5 = (EditText) findViewById(R.id.editText5);
        E6 = (EditText) findViewById(R.id.editText6);
        E7 = (EditText) findViewById(R.id.editText7);
        E8 = (EditText) findViewById(R.id.editText8);

        String S1 = E5.getText().toString();
        String S2 = E6.getText().toString();
        String S3 = E7.getText().toString();
        String S4 = E8.getText().toString();

        Bundle extras = new Bundle();
        extras.putString("n1",S1);
        extras.putString("n2",S2);
        extras.putString("n3",S3);
        extras.putString("n4",S4);
        extras.putInt("Position",-1);
        intent.putExtras(extras);
        startActivity(intent);
    }
    public void loadData(View view){
        String t1="";
        int x =0;
        Intent intent1 = new Intent(this,Load.class);
        Bundle extras1=new Bundle();
        DatabaseHelper myDB = new DatabaseHelper(this);
        List<DataScores> data = myDB.getData();
        for(DataScores dataScores:data){
            t1="elias";
            extras1.putString("id"+x,Integer.toString(dataScores.getid()));
            extras1.putString("Name1"+x,dataScores.getName1());
            extras1.putString("Score1"+x,Integer.toString(dataScores.getScore1()));
            extras1.putString("Name2"+x,dataScores.getName2());
            extras1.putString("Score2"+x,Integer.toString(dataScores.getScore2()));
            extras1.putString("Name3"+x,dataScores.getName3());
            extras1.putString("Score3"+x,Integer.toString(dataScores.getScore3()));
            extras1.putString("Name4"+x,dataScores.getName4());
            extras1.putString("Score4"+x,Integer.toString(dataScores.getScore4()));
            x++;
        }
        if(t1==""){
            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
            alertDialog.setTitle("Alert");
            alertDialog.setMessage("No data found");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL,"OK", new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog,int which){
                    dialog.dismiss();
                }
            });
            alertDialog.show();
            return;
        }
        else{

            extras1.putInt("counter",x);
            intent1.putExtras(extras1);
            startActivity(intent1);
        }
            }
        }
