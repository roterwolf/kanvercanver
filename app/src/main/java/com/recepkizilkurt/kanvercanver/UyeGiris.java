package com.recepkizilkurt.kanvercanver;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;

/**
 * Created by recep.kizilkurt on 14.06.2017.
 */

public class UyeGiris extends Activity {
    EditText etUyeGirisKullaniciAdi, etUyeGirisSifre;
    Button btnUyeGiris;
    SessionManager sessionManager = SessionManager.getInstance();
    String resp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.uye_giris_layout);

        etUyeGirisKullaniciAdi = (EditText) findViewById(R.id.etUyeGirisKullaniciAdi);
        etUyeGirisSifre = (EditText) findViewById(R.id.etUyeGirisSifre);
        btnUyeGiris = (Button) findViewById(R.id.btnUyeGiris);

        btnUyeGiris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ToastYazdir("Üye giris işlemi başarılı bir şekilde gerçekleşti.");
                new servis().execute(etUyeGirisKullaniciAdi.getText().toString(),etUyeGirisSifre.getText().toString());
            }
        });
    }

    class  servis extends AsyncTask<String,String,String>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }

        @Override
        protected String doInBackground(String... params) {
            try {
                HttpClient httpClient = new DefaultHttpClient();
                HttpGet request = new HttpGet();
                ResponseHandler response = new BasicResponseHandler();

                String Adi = params[0];
                String Sifresi = params[1];

                String thePath = getIntent().getStringExtra("Url")  +"kanvercanver.asmx/uyeGiris?";
                if(!Adi.equals(""))
                    thePath += "kullaniciAdi=" + URLEncoder.encode(Adi) ;
                else {
                    ToastYazdir("Lütfen Adını Giriniz!");
                    return null;
                }
                if(!Sifresi.equals(""))
                    thePath += "kullaniciSifresi=" + URLEncoder.encode(Sifresi) ;
                else {
                    ToastYazdir("Lütfen Şifrenizi Giriniz!");
                    return null;
                }

                request.setURI(new URI(thePath));

                resp = (String) httpClient.execute(request, response);
                resp = new GeneralActions().cutstr(resp);

                if ( resp.trim().equals("İşlem Başarılı")) {
                    ToastYazdir("Üye giris işlemi başarılı bir şekilde gerçekleşti.");

                    sessionManager.setContext(getApplicationContext());
                    sessionManager.setValue("loginStatus", true);
                }
                else
                    ToastYazdir("Üye giris işlemi başarısız oldu!");

                Intent i = new Intent(UyeGiris.this, MainActivity.class);
                i.putExtra("Url", getIntent().getStringExtra("Url"));
                startActivity(i);

            } catch (IOException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
    public void install_elements() {

    }

    private void ToastYazdir(final String str) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
