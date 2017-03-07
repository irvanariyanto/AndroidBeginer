package com.example.bay.pagination;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bay.pagination.models.Models;
import com.example.bay.pagination.models.Result;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.TextHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import cz.msebera.android.httpclient.Header;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.provider.UserDictionary.Words.APP_ID;

public class MainActivity extends AppCompatActivity {

    //ROOT_URL dari web service
    public static final String ROOT_URL = "https://butick.in/";

    Button btn_start;
    ProgressBar progressBar;
    TextView txt_percentage;

    //definisi tampilan
    private TextView txt_id;
    private  TextView txt_nama;
    private  TextView txt_email;
    private  TextView txt_alamat;
    private  TextView txt_status;

    private List<Result> examples;
    JSONArray kontak = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_id = (TextView) findViewById(R.id.txt_id);
        txt_nama = (TextView) findViewById(R.id.txt_nama);
        txt_email = (TextView) findViewById(R.id.txt_email);
        txt_alamat = (TextView) findViewById(R.id.txt_alamat);
        txt_status = (TextView) findViewById(R.id.txt_status);

        //Memanggil method untuk mengambil data
        getData();


    }

    private void getData(){
        //ketika aplikasi sedang mengambil data kita akan melihat progress dialog muncul
        final ProgressDialog loading = ProgressDialog.show(this, "Fetching Data","Please wait..",false,false);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())//GsonConverter untuk parsing json
                .build();
        RestApi service = retrofit.create(RestApi.class);
//        Call<Models> call = service.getDataNews("newest",1);
        Call<Models> call = service.getDataResponse();
        call.enqueue(new Callback<Models>() { //Asyncronous Request
                         @Override
                         public void onResponse(Call<Models> call, Response<Models> response) {
                             try {
                                 loading.dismiss(); //progress dialog dihentikan

                                 //dapatkan hasil parsing dari method response.body()
                                 List<Result> results=response.body().getResponse().getResults();
                                 for(int i=0; i<results.size();i++){
                                     Toast.makeText(MainActivity.this, results.get(i).getOriginalTitle().toString(), Toast.LENGTH_LONG).show();
                                 }

                                 String id = response.body().getResponseNewes().toString();
//                                 String nama = response.body().getAdmin().getNama();
//                                 String email = response.body().getAdmin().getEmail();
//                                 String alamat = response.body().getAdmin().getAlamat();
//                                 String status = response.body().getAdmin().getStatus();



                                 txt_id.setText("ID : "+ id);
//                                 txt_nama.setText("Nama : "+nama);
//                                 txt_email.setText("Email : "+email);
//                                 txt_alamat.setText("Alamat : "+alamat);
//                                 txt_status.setText("Status : "+status );
                             }catch (Exception e){
                                 e.printStackTrace();
                             }
                         }

                         @Override
                         public void onFailure(Call<Models> call, Throwable t) {

                         }

                     }
        );



    }


    private class ShowDialogAsyncTask extends AsyncTask<Void, Integer, Void>{

        int progress_status;

        @Override
        protected void onPreExecute() {
            // update the UI immediately after the task is executed
            super.onPreExecute();

            Toast.makeText(MainActivity.this,
                    "Invoke onPreExecute()", Toast.LENGTH_SHORT).show();

            progress_status    =    0;
            txt_percentage.setText("downloading 0%");

        }

        @Override
        protected Void doInBackground(Void... params) {

            while(progress_status<100){

                progress_status += 2;

                publishProgress(progress_status);
                SystemClock.sleep(300);

            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

            progressBar.setProgress(values[0]);
            txt_percentage.setText("downloading " +values[0]+"%");

        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);

            Toast.makeText(MainActivity.this,
                    "Invoke onPostExecute()", Toast.LENGTH_SHORT).show();

            txt_percentage.setText("download complete");
            btn_start.setEnabled(true);
        }

    }

}
