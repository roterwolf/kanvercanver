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
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;

/**
 * Created by recep.kizilkurt on 14.06.2017.
 */

public class Mesaj extends Activity {

    Button btnMesajGonder;
    EditText etMesajKulAdi, etMesajSifre,etMesajAciklama;
    Spinner spinnerMesajKanGrubu;
    View.OnClickListener MesajListener;
    String siteUrlMesaj;
    Integer kullaniciId=0;
    String resp;
    SessionManager sessionManager = SessionManager.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.mesaj_birak_layout);

        btnMesajGonder = (Button) findViewById(R.id.btnMesajGonder);
        spinnerMesajKanGrubu = (Spinner) findViewById(R.id.spinnerMesajKanGrubu);
        etMesajAciklama = (EditText) findViewById(R.id.etMesajAciklama) ;


        ArrayAdapter<CharSequence> kgAdapterMesaj = ArrayAdapter.createFromResource(this,R.array.kangrubu,
                android.R.layout.simple_spinner_item);

        spinnerMesajKanGrubu.setAdapter(kgAdapterMesaj);
        try{
            kullaniciId = sessionManager.getIntValue("kullaniciId");
        }
        catch(Exception e){
            ToastYazdir("Kullanıcı Id alınamadı.");
        }

        //siteUrlMesaj = "http://kanvercanver.somee.com/";
        siteUrlMesaj = "http://www.recepkurt.somee.com/";
        MesajListener =  new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                switch (v.getId()){
                    case R.id.btnMesajGonder:
                        activityMesaj(Listele.class);
                        break;
                    default:
                        break;

                }
            }
        };

        btnMesajGonder.setOnClickListener(MesajListener);

        btnMesajGonder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new servis().execute(kullaniciId.toString(),spinnerMesajKanGrubu.getSelectedItem().toString(),etMesajAciklama.getText().toString());
            }
        });
    }

    class  servis extends AsyncTask<String,String,String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }
        @Override
        protected String doInBackground(String... params) {

                DefaultHttpClient httpClient = new DefaultHttpClient();
                ResponseHandler response = new BasicResponseHandler();

                String kullaniciId = params[0];
                String KanGrubu = params[1];
                String MesajAciklama = params[2];

            String thePath = getIntent().getStringExtra("Url") + "kanvercanver.asmx/mesajKaydet?";
            thePath += "&kanGrubu=" + URLEncoder.encode(KanGrubu) ;
            thePath += "&MesajAciklama=" + URLEncoder.encode(MesajAciklama) ;

            //https://www.youtube.com/watch?v=DwKvrVIRRVQ   sure4.20 ye bak HTTPGET deki Adresi al

            try {

                HttpGet request = new HttpGet(thePath);
                resp = (String) httpClient.execute(request, response);
                resp = new GeneralActions().cutstr(resp);

                if (resp.trim().equals("İşlem Başarılı")) {
                    ToastYazdir("Mesaj kaydetme işlemi başarılı bir şekilde gerçekleşti.");
                } else {
                    ToastYazdir("Mesaj kaydetme işlemi başarısız oldu.");
                }


                Intent i = new Intent(Mesaj.this, MainActivity.class);
                i.putExtra("Url", getIntent().getStringExtra("Url"));
                startActivity(i);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }

    }

    private void activityMesaj (Class c){
        Intent i =new Intent(Mesaj.this,c);
        i.putExtra("Url",siteUrlMesaj);
        startActivity(i);
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
