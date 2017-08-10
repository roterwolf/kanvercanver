package com.recepkizilkurt.kanvercanver;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

//AppCompatActivity

public class MainActivity extends Activity {


    Button  btnGirisYap,btnBagisciOl, btnBagisciAra, btnIhtiyacAra, btnMesajBirak;
    TextView txtLabel,txtLogin;
    View.OnClickListener Listener;
    String siteUrl,kullaniciAdi;
    Boolean giris=false;
    SessionManager sessionManager = SessionManager.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGirisYap = (Button) findViewById(R.id.btnGirisYap);
        btnBagisciOl = (Button) findViewById(R.id.btnBagisciOl);
        btnBagisciAra = (Button) findViewById(R.id.btnBagisciAra);
        btnIhtiyacAra = (Button) findViewById(R.id.btnIhtiyacAra);
        btnMesajBirak = (Button) findViewById(R.id.btnMesajBirak);
        txtLabel = (TextView) findViewById(R.id.tvBaslik);
        txtLogin = (TextView) findViewById(R.id.tvLogin);
        //siteUrl = "http://kanvercanver.somee.com/";
        siteUrl = "http://www.recepkurt.somee.com/";
        try{
            if(sessionManager.getBoolValue("loginStatus")){
                kullaniciAdi = sessionManager.getStrValue("KullaniciAdi");
                txtLabel.setText("Hoşgeldin "+kullaniciAdi);
                txtLogin.setText("              Çıkış yap");
                giris = true;
            }
        }
        catch (Exception e){
            txtLabel.setText("Giriş yapılmadı..");
        }
        Listener =  new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                switch (v.getId()){
                    case R.id.btnGirisYap:
                        activity(UyeGiris.class);
                        break;
                    case R.id.btnBagisciOl:
                        activity(UyeOl.class);
                        break;
                    case R.id.btnBagisciAra:
                            if (giris)
                                activity(KanAra.class);
                            else
                                ToastYazdir("Lütfen giriş yapınız!");
                        break;
                    case R.id.btnIhtiyacAra:
                        activity(IhtiyacAra.class);
                        break;
                    case R.id.btnMesajBirak:

                             if (giris)
                                activity(Mesaj.class);
                             else
                                ToastYazdir("Lütfen giriş yapınız!");
                        break;
                    case R.id.tvLogin:
                        sessionManager.setBoolValue("loginStatus",false);
                        sessionManager.setIntValue("kullaniciId", 0);
                        sessionManager.setStrValue("KullaniciAdi", null);
                        sessionManager.setStrValue("Adi",null);
                        sessionManager.setStrValue("Soyadi", null);
                        activity(MainActivity.class);
                        break;

                }
            }
        };

        btnGirisYap.setOnClickListener(Listener);
        btnBagisciOl.setOnClickListener(Listener);
        btnBagisciAra.setOnClickListener(Listener);
        btnIhtiyacAra.setOnClickListener(Listener);
        btnMesajBirak.setOnClickListener(Listener);
        txtLogin.setOnClickListener(Listener);

   }


    private void activity (Class c) {
        Intent i =new Intent(MainActivity.this,c);
        i.putExtra("Url",siteUrl);
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
