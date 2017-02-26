package com.example.bay.androidlifecycle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by BAY on 11/3/2016.
 */

public class Activity2 extends Activity {
    Button btnAct2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        btnAct2=(Button)findViewById(R.id.btnAct2);
        btnAct2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Activity2.this, MainActivity.class);
                startActivity(intent);
            }
        });
        Log.d("onCreate","Activity 2 Create");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("onStart","Activity 2 Start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("onResume","Activity 2 Resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("onPause","Activity 2 Pause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("onRestart","Activity 2 Restart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("onDestroy","Activity 2 Destroy");
    }
}

