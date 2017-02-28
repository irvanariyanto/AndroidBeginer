package com.example.bay.internalstogare;

import android.content.Context;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    Button buttonInternal;
    Button buttonEksternal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonInternal = (Button) findViewById(R.id.simpanInternal);
        buttonEksternal = (Button) findViewById(R.id.simpanEksternal);

        buttonInternal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FileOutputStream fos;
                try {
                    fos = openFileOutput("tutorialStorageInternal", Context.MODE_PRIVATE);
                    fos.write("Cetak Di Internal".getBytes());
                    fos.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        buttonEksternal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String state = Environment.getExternalStorageState();
                if(Environment.MEDIA_MOUNTED.equals(state)){
                    File dirEksternal=Environment.getExternalStorageDirectory();
                    File buatDirEksternal = new File(dirEksternal.getAbsolutePath()+"/untukEksternal");

                    if(!buatDirEksternal.exists()){
                        buatDirEksternal.mkdir();
                    }

                    File file=new File(buatDirEksternal,"Contoh.txt");
                    try {
                        FileOutputStream fos=new FileOutputStream(file);
                        fos.write("Contoh menyimpan di eksternal".getBytes());
                        fos.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }else{
                    Toast.makeText(MainActivity.this, "Media Penyimpanan luar tidak tersedia", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
