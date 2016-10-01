package com.example.bay.intent;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by Bay on 10/1/2016.
 */
public class Activity2 extends Activity {
    TextView username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        username=(TextView)findViewById(R.id.username);
        password=(TextView)findViewById(R.id.password);

        Bundle bundle=getIntent().getExtras();
        User user= (User) bundle.getSerializable("user");
        username.setText(user.getUsername());
        password.setText(user.getPassword());
    }
}
