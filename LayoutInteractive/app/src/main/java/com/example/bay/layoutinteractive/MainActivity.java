package com.example.bay.layoutinteractive;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editPanjang,editLebar,editTinggi,editHasil;
    Button hitung;
    int panjang,lebar,tinggi,hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editPanjang=(EditText)findViewById(R.id.editPanjang);
        editLebar=(EditText)findViewById(R.id.editLebar);
        editTinggi=(EditText)findViewById(R.id.editTinggi);
        editHasil=(EditText)findViewById(R.id.editHasil);

        hitung=(Button)findViewById(R.id.buttonHitung);

        hitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!editPanjang.getText().toString().isEmpty() && !editLebar.getText().toString().isEmpty() &&
                        !editTinggi.getText().toString().isEmpty()){
                    panjang=Integer.parseInt(editPanjang.getText().toString());
                    lebar=Integer.parseInt(editLebar.getText().toString());
                    tinggi=Integer.parseInt(editTinggi.getText().toString());

                    hasil=panjang*lebar*tinggi;
                    editHasil.setText(String.valueOf(hasil));
                }else{
                    Toast.makeText(getApplicationContext(),"Isi Semua data lebih dahulu",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
