package com.example.eliasteeny.likhascore;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.test.suitebuilder.TestMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class Scores extends AppCompatActivity {

    DatabaseHelper db = new DatabaseHelper(this);

    DataScores load;

    public static int counter=0;
    public static int loadCont=0;
    public int position;
    Integer[] scores1;
    Integer[] scores2;
    Integer[] scores3;
    Integer[] scores4;

    public static Integer[] total = new Integer[]{0,0,0,0};

    Integer[] scoresTemp1 = new Integer[12];
    Integer[] scoresTemp2 = new Integer[12];
    Integer[] scoresTemp3 = new Integer[12];
    Integer[] scoresTemp4 = new Integer[12];

    ArrayAdapter<Integer> adapter1;
    ArrayAdapter<Integer> adapter2;
    ArrayAdapter<Integer> adapter3;
    ArrayAdapter<Integer> adapter4;

    String input1;
    String input2;
    String input3;
    String input4;

    String name1;
    String name2;
    String name3;
    String name4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        position=extras.getInt("Position");
        if(position==-1) {
            name1 = extras.getString("n1");
            name2 = extras.getString("n2");
            name3 = extras.getString("n3");
            name4 = extras.getString("n4");
        loadCont=2;

        }
        else{
            load = db.getOneRow(position+1);

            name1=load.getName1();
            name2=load.getName2();
            name3=load.getName3();
            name4=load.getName4();

            scores1 = new Integer[1];
            scores2 = new Integer[1];
            scores3 = new Integer[1];
            scores4 = new Integer[1];

            scores1[0]=load.getScore1();
            scores2[0]=load.getScore2();
            scores3[0]=load.getScore3();
            scores4[0]=load.getScore4();

            scoresTemp1[0]=scores1[0];
            scoresTemp2[0]=scores2[0];
            scoresTemp3[0]=scores3[0];
            scoresTemp4[0]=scores4[0];

            total[0]=total[0]+scores1[0];
            total[1]=total[1]+scores2[0];
            total[2]=total[2]+scores3[0];
            total[3]=total[3]+scores4[0];

            ListView list11 = (ListView)findViewById(R.id.list);
            ListView list22 = (ListView)findViewById(R.id.list2);
            ListView list33 = (ListView)findViewById(R.id.list3);
            ListView list44 = (ListView)findViewById(R.id.list4);

            adapter1 = new ArrayAdapter<Integer>(getApplicationContext(),android.R.layout.simple_list_item_1,scores1);
            list11.setAdapter(adapter1);
            adapter2 = new ArrayAdapter<Integer>(getApplicationContext(),android.R.layout.simple_list_item_1,scores2);
            list22.setAdapter(adapter2);
            adapter3 = new ArrayAdapter<Integer>(getApplicationContext(),android.R.layout.simple_list_item_1,scores3);
            list33.setAdapter(adapter3);
            adapter4 = new ArrayAdapter<Integer>(getApplicationContext(),android.R.layout.simple_list_item_1,scores4);
            list44.setAdapter(adapter4);

            loadCont=1;
            counter++;
        }
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(name1);
        TextView textView2 = (TextView) findViewById(R.id.textView2);
        textView2.setText(name2);
        TextView textView3 = (TextView) findViewById(R.id.textView3);
        textView3.setText(name3);
        TextView textView4 = (TextView) findViewById(R.id.textView4);
        textView4.setText(name4);

        TextView t1 = (TextView) findViewById(R.id.textView5);
        t1.setText("0");
        TextView t2 = (TextView) findViewById(R.id.textView6);
        t2.setText("0");
        TextView t3 = (TextView) findViewById(R.id.textView7);
        t3.setText("0");
        TextView t4 = (TextView) findViewById(R.id.textView8);
        t4.setText("0");
    }
    public void scores(View view){
        ListView list1 = (ListView)findViewById(R.id.list);
        ListView list2 = (ListView)findViewById(R.id.list2);
        ListView list3 = (ListView)findViewById(R.id.list3);
        ListView list4 = (ListView)findViewById(R.id.list4);

        scores1 = new Integer[counter+1];
        scores2 = new Integer[counter+1];
        scores3 = new Integer[counter+1];
        scores4 = new Integer[counter+1];



        EditText E1 = (EditText) findViewById(R.id.editText);
        EditText E2 = (EditText) findViewById(R.id.editText2);
        EditText E3 = (EditText) findViewById(R.id.editText3);
        EditText E4 = (EditText) findViewById(R.id.editText4);


        input1=E1.getText().toString();
        input2=E2.getText().toString();
        input3=E3.getText().toString();
        input4=E4.getText().toString();
        try{
            if(input1==null||input2==null||input3==null||input4==null)
                throw new Exception("");
        } catch (Exception e) {
            AlertDialog alertDialog = new AlertDialog.Builder(Scores.this).create();
            alertDialog.setTitle("Alert");
            alertDialog.setMessage("Input all value");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL,"OK", new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog,int which){
                    dialog.dismiss();
                }
            });
            alertDialog.show();
            return;
        }

        try {
            scores1[counter] = Integer.parseInt(input1);
            scores2[counter] = Integer.parseInt(input2);
            scores3[counter] = Integer.parseInt(input3);
            scores4[counter] = Integer.parseInt(input4);
        }
        catch (NumberFormatException e){
            AlertDialog alertDialog = new AlertDialog.Builder(Scores.this).create();
            alertDialog.setTitle("Alert");
            alertDialog.setMessage("Please enter only numvbers");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL,"OK", new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog,int which){
                    dialog.dismiss();
                }
            });
            alertDialog.show();
            return;
        }
        try{
        if(scores1[counter]+scores2[counter]+scores3[counter]+scores4[counter]!=36){
            throw new Exception("");
        }
        } catch (Exception e) {
            AlertDialog alertDialog = new AlertDialog.Builder(Scores.this).create();
            alertDialog.setTitle("Alert");
            alertDialog.setMessage("Scores different from 36");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL,"OK", new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog,int which){
                    dialog.dismiss();
                }
            });
            alertDialog.show();
            return;
        }
        if(scores1[counter]==36) scores1[counter]=37;
        if(scores2[counter]==36) scores2[counter]=37;
        if(scores3[counter]==36) scores3[counter]=37;
        if(scores4[counter]==36) scores4[counter]=37;
        
        scoresTemp1[counter]=scores1[counter];
        scoresTemp2[counter]=scores2[counter];
        scoresTemp3[counter]=scores3[counter];
        scoresTemp4[counter]=scores4[counter];

        total[0]=total[0]+scores1[counter];
        total[1]=total[1]+scores2[counter];
        total[2]=total[2]+scores3[counter];
        total[3]=total[3]+scores4[counter];

        TextView t1 = (TextView)findViewById(R.id.textView5);
        t1.setText(Integer.toString(total[0]));
        TextView t2 = (TextView)findViewById(R.id.textView6);
        t2.setText(Integer.toString(total[1]));
        TextView t3 = (TextView)findViewById(R.id.textView7);
        t3.setText(Integer.toString(total[2]));
        TextView t4 = (TextView)findViewById(R.id.textView8);
        t4.setText(Integer.toString(total[3]));

        for(int i = counter-1 ; i >=0;i--){
            scores1[i]=scoresTemp1[i];
            scores2[i]=scoresTemp2[i];
            scores3[i]=scoresTemp3[i];
            scores4[i]=scoresTemp4[i];
        }

        adapter1 = new ArrayAdapter<Integer>(getApplicationContext(),android.R.layout.simple_list_item_1,scores1);
        list1.setAdapter(adapter1);
        adapter2 = new ArrayAdapter<Integer>(getApplicationContext(),android.R.layout.simple_list_item_1,scores2);
        list2.setAdapter(adapter2);
        adapter3 = new ArrayAdapter<Integer>(getApplicationContext(),android.R.layout.simple_list_item_1,scores3);
        list3.setAdapter(adapter3);
        adapter4 = new ArrayAdapter<Integer>(getApplicationContext(),android.R.layout.simple_list_item_1,scores4);
        list4.setAdapter(adapter4);

        E1.setText("");
        E2.setText("");
        E3.setText("");
        E4.setText("");
        if(total[0]>=101||total[2]>=101){
            AlertDialog alertDialog = new AlertDialog.Builder(Scores.this).create();
            alertDialog.setTitle("Alert");
            alertDialog.setMessage(name2+" and "+name4 + " won");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL,"OK", new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog,int which){
                    dialog.dismiss();
                }
            });
            alertDialog.show();
            if(loadCont==2)
                db.insertData(new DataScores(name1,total[0],name2,total[1],name3,total[2],name4,total[3]));
            if(loadCont==1){
                load.setScore1(total[0]);
                load.setScore2(total[1]);
                load.setScore3(total[2]);
                load.setScore4(total[3]);
                db.updateData(load);
            }
            return;

        }
        if(total[1]>=101||total[3]>=101){
            AlertDialog alertDialog = new AlertDialog.Builder(Scores.this).create();
            alertDialog.setTitle("Alert");
            alertDialog.setMessage(name1+" and "+name3 + " won");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL,"OK", new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog,int which){
                    dialog.dismiss();
                }
            });
            alertDialog.show();
            if(loadCont==2)
                db.insertData(new DataScores(name1,total[0],name2,total[1],name3,total[2],name4,total[3]));
            if(loadCont==1){
                load.setScore1(total[0]);
                load.setScore2(total[1]);
                load.setScore3(total[2]);
                load.setScore4(total[3]);
                db.updateData(load);
            }
            return;
        }

        counter++;
        return;

    }
    public void save(View view){
        int x=0;
        if(x==1){
            AlertDialog alertDialog = new AlertDialog.Builder(Scores.this).create();
            alertDialog.setTitle("Alert");
            alertDialog.setMessage("Game is already saved");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL,"OK", new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog,int which){
                    dialog.dismiss();
                }
            });
            alertDialog.show();
            return;
        }
        if(loadCont==2){
            db.insertData(new DataScores(name1,total[0],name2,total[1],name3,total[2],name4,total[3]));
            x=1;
        }
        else{
            load.setScore1(total[0]);
            load.setScore2(total[1]);
            load.setScore3(total[2]);
            load.setScore4(total[3]);
            db.updateData(load);
        }
        AlertDialog alertDialog = new AlertDialog.Builder(Scores.this).create();
        alertDialog.setTitle("Alert");
        alertDialog.setMessage("Game Saved");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL,"OK", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog,int which){
                dialog.dismiss();
            }
        });
        alertDialog.show();
        return;
    }

}
