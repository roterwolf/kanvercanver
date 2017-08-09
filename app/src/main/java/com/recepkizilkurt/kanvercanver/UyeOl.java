package com.recepkizilkurt.kanvercanver;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.List;

public class UyeOl extends Activity  implements
        OnItemSelectedListener {

    EditText etUyeOlKullaniciAdi, etUyeOlKullaniciSifre, etUyeOlAdi, etUyeOlSoyadi, etUyeOlDogumTarihi, etUyeOlAdresi,etUyeOlCepTelefonu;
    Spinner spinnerUyeOlKanGrubu, spinnerUyeOlIli, spinnerUyeOlIlcesi,spinnerUyeOlUyeTipi;
    Button btnUyeOlGonder;
    String resp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.uye_ol_layout);

        etUyeOlKullaniciAdi = (EditText) findViewById(R.id.etUyeOlKullaniciAdi);
        etUyeOlKullaniciSifre = (EditText) findViewById(R.id.etUyeOlKullaniciSifre);
        etUyeOlAdi = (EditText) findViewById(R.id.etUyeOlAdi);
        etUyeOlSoyadi = (EditText) findViewById(R.id.etUyeOlSoyadi);
        etUyeOlDogumTarihi = (EditText) findViewById(R.id.etUyeOlDogumTarihi);
        spinnerUyeOlKanGrubu = (Spinner) findViewById(R.id.spinnerUyeOlKanGrubu);
        spinnerUyeOlIli = (Spinner) findViewById(R.id.spinnerUyeOlIli);
        spinnerUyeOlIlcesi = (Spinner) findViewById(R.id.spinnerUyeOlIlcesi);
        spinnerUyeOlUyeTipi = (Spinner) findViewById(R.id.spinnerUyeTipi);
        etUyeOlAdresi = (EditText) findViewById(R.id.etUyeOlAdresi);
        etUyeOlCepTelefonu = (EditText) findViewById(R.id.etUyeOlCepTelefonu);
        btnUyeOlGonder = (Button) findViewById(R.id.btnUyeOlGonder);

        // Spinner click listener
        spinnerUyeOlIli.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> kgAdapterUyeOl = ArrayAdapter.createFromResource(this,R.array.kangrubu, android.R.layout.simple_spinner_item);
        spinnerUyeOlKanGrubu.setAdapter(kgAdapterUyeOl);
        ArrayAdapter<CharSequence> utAdapterUyeOl = ArrayAdapter.createFromResource(this,R.array.uyeTipi, android.R.layout.simple_spinner_item);
        spinnerUyeOlUyeTipi.setAdapter(utAdapterUyeOl);


        // Loading spinner data from database
        loadSpinnerData("",0);

        btnUyeOlGonder.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //ToastYazdir("Üye Kayıt işlemi başarılı bir şekilde gerçekleşti.");
                new Servis().execute(
                etUyeOlAdi.getText().toString(),
                etUyeOlSoyadi.getText().toString(),
                spinnerUyeOlKanGrubu.getSelectedItem().toString(),
                etUyeOlDogumTarihi.getText().toString(),
                etUyeOlCepTelefonu.getText().toString(),
                spinnerUyeOlIli.getSelectedItem().toString(),
                spinnerUyeOlIlcesi.getSelectedItem().toString(),
                etUyeOlAdresi.getText().toString(),
                spinnerUyeOlUyeTipi.getSelectedItem().toString(),
                etUyeOlKullaniciAdi.getText().toString(),
                etUyeOlKullaniciSifre.getText().toString()
                );
           }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        // On selecting a spinner item
        long ilkodu = adapterView.getItemIdAtPosition(i)+1;
        loadSpinnerData("ilcelistele",ilkodu);

        // Showing selected spinner item
        //Toast.makeText(adapterView.getContext(), "Seçilen İl: " + ilkodu,
        //        Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


    public class Servis extends AsyncTask<String, String, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            // Burada kullanıcımıza Yükkleniyor mesajını göstermek için bir ProgressDialog olşturuyoruz.
//            ProgressDialog pDialog = new ProgressDialog(UyeOl.this);
//            pDialog.setMessage("Kayıt Yapılıyor...");
//            pDialog.setIndeterminate(true);
//            pDialog.setCancelable(false); // ProgressDialog u iptal edilemez hale getirdik.
//            pDialog.show(); // ProgressDialog u gösteriyoruz.

        }

        @Override
        protected String doInBackground(String... params) {
            try {
                HttpClient httpClient = new DefaultHttpClient();
                HttpGet request = new HttpGet();
                ResponseHandler response = new BasicResponseHandler();


                String Adi = params[0];
                String Soyadi = params[1];
                String KanGrubu = params[2];
                String DogumTarihi = params[3];
                String CepTelefonu = params[4];
                String Ili = params[5];
                String Ilcesi = params[6];
                String Adres = params[7];
                String UyeTipi = params[8];
                String KullaniciAdi = params[9];
                String KullaniciSifresi = params[10];

                //String bagisci ="Bağışçı";

                String thePath = getIntent().getStringExtra("Url") + "kanvercanver.asmx/uyeKayit?";
                if (!Adi.equals(""))
                    thePath += "adi=" + URLEncoder.encode(Adi);
                else {
                    ToastYazdir("Lütfen adınızı giriniz!");
                    return null;
                }
                if (!Soyadi.equals(""))
                    thePath += "&soyadi=" + URLEncoder.encode(Soyadi);
                else {
                    ToastYazdir("Lütfen soyadınızı giriniz!");
                    return null;
                }
                if (!KanGrubu.equals(""))
                    thePath += "&kanGrubu=" + URLEncoder.encode(KanGrubu);
                else {
                    ToastYazdir("Lütfen kangrubunu giriniz!");
                    return null;
                }
                if (!DogumTarihi.equals(""))
                    thePath += "&dogumTarihi=" + URLEncoder.encode(DogumTarihi);
                if (!CepTelefonu.equals(""))
                    thePath += "&cepTelefonu=" + URLEncoder.encode(CepTelefonu);
                if (!Ili.equals(""))
                    thePath += "&ili=" + URLEncoder.encode(Ili);
                if (!Ilcesi.equals(""))
                    thePath += "&ilcesi=" + URLEncoder.encode(Ilcesi);
                if (!Adres.equals(""))
                    thePath += "&adres=" + URLEncoder.encode(Adres);
                if (!UyeTipi.equals(""))
                    thePath += "&uyeTipi=" + URLEncoder.encode(UyeTipi);
                if (!KullaniciAdi.equals(""))
                    thePath += "&kullaniciAdi=" + URLEncoder.encode(KullaniciAdi);
                else {
                    ToastYazdir("Lütfen kullanıcı adınızı giriniz!");
                    return null;
                }
                if (!KullaniciSifresi.equals(""))
                    thePath += "&kullaniciSifresi=" + URLEncoder.encode(KullaniciSifresi);
                else {
                    ToastYazdir("Lütfen kullanıcı şifrenizi giriniz!");
                    return null;
                }


                request.setURI(new URI(thePath));

                resp = (String) httpClient.execute(request, response);
                resp = new GeneralActions().cutstr(resp);

                if (resp.trim().equals("İşlem Başarılı")) {
                    ToastYazdir("Üye olma işlemi başarılı bir şekilde gerçekleşti.");

                    Intent i = new Intent(UyeOl.this, MainActivity.class);
                    i.putExtra("Url", getIntent().getStringExtra("Url"));
                    startActivity(i);
                } else {
                    ToastYazdir("Üye olma işlemi başarız!");

                    Intent i = new Intent(UyeOl.this, MainActivity.class);
                    i.putExtra("Url", getIntent().getStringExtra("Url"));
                    startActivity(i);
                }

            } catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }

          return null;
        }
    }

    private void ToastYazdir(final String str) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void loadSpinnerData(String listingType,long ilKodu) {
        // database handler
        DatabaseConnector db = new DatabaseConnector(getApplicationContext());
        if (listingType.equals("ilcelistele")) {
            // Spinner Drop down elements
            List<String> ilceler = db.getAllilceler(ilKodu);

            // Creating adapter for spinner
            ArrayAdapter<String> dataAdapterilceler = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ilceler);

            // Drop down layout style - list view with radio button
            dataAdapterilceler.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            // attaching data adapter to spinner
            spinnerUyeOlIlcesi.setAdapter(dataAdapterilceler);

        } else {
            // Spinner Drop down elements
            List<String> iller = db.getAllili();

            // Creating adapter for spinner
            ArrayAdapter<String> dataAdapteriller = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, iller);

            // Drop down layout style - list view with radio button
            dataAdapteriller.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            // attaching data adapter to spinner
            spinnerUyeOlIli.setAdapter(dataAdapteriller);
        }
    }

}
