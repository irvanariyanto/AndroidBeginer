package com.example.bay.androidlifecycle;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnAct1;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAct1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, Activity2.class);
                startActivity(intent);
                finish();
            }
        });
        Log.d("onCreate","Activity Create");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("onStart","Activity Start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("onResume","Activity Resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("onPause","Activity Pause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("onRestart","Activity Restart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("onDestroy","Activity Destroy");
    }
}
