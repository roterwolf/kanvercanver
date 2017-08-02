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
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by recep.kizilkurt on 14.06.2017.
 */

public class Mesaj extends Activity {

    Button btnMesajGonder;
    EditText etMesajKulAdi, etMesajSifre,etMesajAciklama;
    Spinner spinnerMesajKanGrubu;
    View.OnClickListener MesajListener;
    String siteUrlMesaj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.mesaj_birak_layout);
        install_elements();

        btnMesajGonder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastYazdir("Mesaj Kayıt İşlemi başarılı bir şekilde yapıldı.");
                new servis().execute(etMesajKulAdi.getText().toString(),etMesajSifre.getText().toString(),spinnerMesajKanGrubu.getSelectedItem().toString(),etMesajAciklama.getText().toString());
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
            try {
                HttpClient httpClient = new DefaultHttpClient();
                HttpGet request = new HttpGet();

                String kullaniciAdi = params[0];
                String Sifre = params[1];
                String KanGrubu = params[2];
                String MesajAciklama = params[3];

                //https://www.youtube.com/watch?v=DwKvrVIRRVQ   sure4.20 ye bak HTTPGET deki Adresi al
                request.setURI(new URI(getIntent().getStringExtra("Url") + "kanvercanver.asmx/mesajKaydet?kullaniciAdi=" + kullaniciAdi + "&Sifre=" + Sifre +"&KanGrubu="+KanGrubu+"&MesajAciklama="+MesajAciklama+""));

                if (!httpClient.execute(request).equals(null)) {
                    ToastYazdir("Üye giris işlemi başarılı bir şekilde gerçekleşti.");
                    Thread.sleep(1500);
                    Intent i = new Intent(Mesaj.this, MainActivity.class);
                    i.putExtra("Url", getIntent().getStringExtra("Url"));
                    startActivity(i);
                }


            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }

    }
    private void install_elements() {

        btnMesajGonder = (Button) findViewById(R.id.btnMesajGonder);
        etMesajKulAdi = (EditText) findViewById(R.id.etMesajAdi) ;
        etMesajSifre = (EditText) findViewById(R.id.etMesajSifre) ;
        spinnerMesajKanGrubu = (Spinner) findViewById(R.id.spinnerMesajKanGrubu);
        etMesajAciklama = (EditText) findViewById(R.id.etMesajAciklama) ;


        ArrayAdapter<CharSequence> kgAdapterMesaj = ArrayAdapter.createFromResource(this,R.array.kangrubu,
                android.R.layout.simple_spinner_item);

        spinnerMesajKanGrubu.setAdapter(kgAdapterMesaj);


        siteUrlMesaj = "http://kanvercanver.somee.com/";
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
