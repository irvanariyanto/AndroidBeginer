package com.example.bay.inflater;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout mainlayout;
    View view1,view2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainlayout =(LinearLayout) findViewById(R.id.main);
        view1 = getLayoutInflater().inflate(R.layout.sub1,mainlayout,false);
        view2 = getLayoutInflater().inflate(R.layout.sub2,mainlayout,false);

        mainlayout.addView(view1);
        mainlayout.addView(view2);
    }
}
