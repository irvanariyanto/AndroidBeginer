package com.example.bay.androidframework;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by Bay on 9/29/2016.
 */
public class Activity2 extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("activity 2","create");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("activity 2","start");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("activity 2","pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("activity 2","stop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("activity 2","restart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("activity 2","destroy");
    }
}
