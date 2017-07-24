package com.example.eliasteeny.likhascore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Load extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);

        ArrayAdapter<String> adapter;

        ListView listView = (ListView)findViewById(R.id.listData);
        final Intent intent = getIntent();
        Bundle extras= intent.getExtras();
        String s;
        List<String>data= new ArrayList<String>();
        int x = extras.getInt("counter");
        for(int y = 0;y<x;y++){
            s=(extras.getString("Name1"+y)+":"+
            extras.getString("Score1"+y)+" "+
            extras.getString("Name2"+y)+":"+
            extras.getString("Score2"+y)+" "+
            extras.getString("Name3"+y)+":"+
            extras.getString("Score3"+y)+" "+
            extras.getString("Name4"+y)+":"+
            extras.getString("Score4"+y));

            data.add(s);
            adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data);
            listView.setAdapter(adapter);
        }
        Log.d("hello","hey");
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent2 = new Intent(Load.this,Scores.class);
                Bundle bundle = new Bundle();
                bundle.putInt("Position",position);
                intent2.putExtras(bundle);
                startActivity(intent2);
            }
        });


    }

}
