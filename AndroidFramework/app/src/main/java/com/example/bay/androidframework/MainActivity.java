package com.example.bay.androidframework;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button kliksaya;
    EditText user;
    EditText pass;
    int nilai=0;
    static final String USER="user";
    static final String PASS="pass";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        kliksaya=(Button) findViewById(R.id.kliksaya);
        user=(EditText)findViewById(R.id.user);
        pass=(EditText)findViewById(R.id.pass);
        if(savedInstanceState !=null){
            user.setText(savedInstanceState.getString(USER));
            pass.setText(savedInstanceState.getString(PASS));
        }
        kliksaya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, Activity2.class);
                startActivity(intent);
            }
        });
        nilai = 1;
        Log.d("Main Activity","create");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString(PASS,user.getText().toString());
        outState.putSerializable(PASS,pass.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Main Activity","resume");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Main Activity","start");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Main Activity","pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        nilai=0;
        Log.d("Main Activity","stop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Main Activity","restart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Main Activity","destroy");
    }
}
