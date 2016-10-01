package com.example.bay.intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editUsername,editPassword;
    String username,password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editUsername=(EditText)findViewById(R.id.editUser);
        editPassword=(EditText)findViewById(R.id.editPassword);
        login=(Button)findViewById(R.id.buttonLogin);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Activity2.class);

                Bundle bundle=new Bundle();
                username=editUsername.getText().toString();
                password=editPassword.getText().toString();

                User user=new User(username,password);
                if(username.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Username belum diisi",Toast.LENGTH_LONG).show();
                    return;
                }
                if(password.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Password belum diisi",Toast.LENGTH_LONG).show();
                    return;
                }
//                bundle.putString("username",username);
//                bundle.putString("password",password);

                bundle.putSerializable("user",user);

                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }
}
