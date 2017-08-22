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
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
    TextView txtSifremiUnuttum ;
    String resp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.uye_giris_layout);

        etUyeGirisKullaniciAdi = (EditText) findViewById(R.id.etUyeGirisKullaniciAdi);
        etUyeGirisSifre = (EditText) findViewById(R.id.etUyeGirisSifre);
        btnUyeGiris = (Button) findViewById(R.id.btnUyeGiris);
        txtSifremiUnuttum = (TextView) findViewById(R.id.txtSifremiUnuttum);

        btnUyeGiris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ToastYazdir("Üye giris işlemi başarılı bir şekilde gerçekleşti.");
                new servis().execute("uyeGiris?",etUyeGirisKullaniciAdi.getText().toString(),etUyeGirisSifre.getText().toString());
            }
        });

        txtSifremiUnuttum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new servis().execute("sifrehatirlat?",etUyeGirisKullaniciAdi.getText().toString());
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

                DefaultHttpClient httpClient = new DefaultHttpClient();
                ResponseHandler response = new BasicResponseHandler();

                String WebMetod = params[0];
                String Adi;
                String Sifresi ;
                String thePath;



            if(WebMetod.equals("uyeGiris?"))
            {
                Adi= params[1];
                Sifresi = params[2];
                thePath = getIntent().getStringExtra("Url")  +"kanvercanver.asmx/"+WebMetod;

                if(!Adi.equals(""))
                    thePath += "kullaniciAdi=" + URLEncoder.encode(Adi) ;
                else {
                    ToastYazdir("Lütfen kullanıcı adınızı giriniz!");
                    return null;
                }

                if(!Sifresi.equals(""))
                    thePath += "&kullaniciSifresi=" + URLEncoder.encode(Sifresi) ;
                else {
                    ToastYazdir("Lütfen şifrenizi giriniz!");
                    return null;
                }
            }
            else if (WebMetod.equals("sifrehatirlat?")) {
                Adi = params[1];

                thePath = getIntent().getStringExtra("Url")  +"kanvercanver.asmx/"+WebMetod;

                if(!Adi.equals(""))
                    thePath += "kullaniciAdi=" + URLEncoder.encode(Adi) ;
                else {
                    ToastYazdir("Lütfen kullanıcı adınızı giriniz!");
                    return null;
                }
            }
            else{
                ToastYazdir("Yapılmak istenen işlem algılanamadı.");
                return null;
            }





            try {
                HttpGet request = new HttpGet(thePath);
                resp = (String) httpClient.execute(request, response);
                resp = new GeneralActions().cutstr(resp);

                if (resp.trim().equals("İşlem Başarılı"))
                    ToastYazdir("Lütfen mail adresinizi kontrol ediniz.");
                else{

                        JSONArray json = new JSONArray(resp.trim());

                        for (int i = 0; i < json.length(); i++) {
                            JSONObject e = json.getJSONObject(i);
                            if (e.getInt("Id") > 0) {
                                ToastYazdir("Üye giris işlemi başarılı bir şekilde gerçekleşti.");
                                sessionManager.setContext(getApplicationContext());
                                sessionManager.setBoolValue("loginStatus", true);
                                sessionManager.setIntValue("kullaniciId", e.getInt("Id"));
                                sessionManager.setStrValue("KullaniciAdi", e.getString("kullaniciAdi"));
                                sessionManager.setStrValue("Adi", e.getString("adi"));
                                sessionManager.setStrValue("Soyadi", e.getString("soyadi"));

                            } else
                                ToastYazdir("Üye giris işlemi başarısız oldu!");
                        }
                    }


                Intent i = new Intent(UyeGiris.this, MainActivity.class);
                i.putExtra("Url", getIntent().getStringExtra("Url"));
                startActivity(i);

            } catch (ClientProtocolException e) {
                e.printStackTrace();
                ToastYazdir("İşlem başarısız oldu!");
            } catch (IOException e) {
                e.printStackTrace();
                ToastYazdir("İşlem başarısız oldu!");
            } catch (JSONException e) {
                e.printStackTrace();
                ToastYazdir("İşlem başarısız oldu!");
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
}
