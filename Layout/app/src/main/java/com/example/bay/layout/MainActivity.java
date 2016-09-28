package com.example.bay.layout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String listArray[]={
            "ASP","C#","HTML5","Javascript","Java"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayAdapter adapter=new ArrayAdapter(this,R.layout.activity_list,listArray);
        final ListView listView=(ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                String value = (String)listView.getItemAtPosition(position);
                Toast.makeText(getBaseContext(),value,Toast.LENGTH_SHORT).show();
            }
        });


    }
}
