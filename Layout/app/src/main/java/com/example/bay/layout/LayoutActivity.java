package com.example.bay.layout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Bay on 9/28/2016.
 */
public class LayoutActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent=getIntent();
        String layout=intent.getStringExtra("layout");
        if (layout.endsWith("Linier Vertical")){
            setContentView(R.layout.linier_vertical);
        }
        else if(layout.endsWith("Linier Horizontal")){
            setContentView(R.layout.linier_horizontal);
        }
        else if(layout.endsWith("Linier Vertical Equal Height")){
            setContentView(R.layout.linier_vertical_equal_height);
        }
        else if(layout.endsWith("Linier Vertical Leftover Height")){
            setContentView(R.layout.linier_vertical_leftover_height);
        }
        else if(layout.endsWith("Linier Vertical Equal Width")){
            setContentView(R.layout.linier_vertical_equal_width);
        }
        else if(layout.endsWith("Linier Vertical Leftover Width")){
            setContentView(R.layout.linier_vertical_leftover_width);
        }
        else if(layout.endsWith("Relative 1")){
            setContentView(R.layout.relative_1);
        }
        else if(layout.endsWith("Relative 2")){
            setContentView(R.layout.relative_2);
        }

    }
}
