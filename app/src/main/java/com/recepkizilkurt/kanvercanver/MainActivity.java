package com.recepkizilkurt.kanvercanver;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.Window;
import android.widget.Toast;

//AppCompatActivity

public class MainActivity extends Activity {


    Button  btnGirisYap,btnBagisciOl, btnBagisciAra, btnIhtiyacAra, btnMesajBirak;
    View.OnClickListener Listener;
    String siteUrl;
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
        siteUrl = "http://kanvercanver.somee.com/";


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
                        try {
                            if (sessionManager.getValue("loginStatus"))
                                activity(KanAra.class);
                            else
                                ToastYazdir("Lütfen giriş yapınız!");

                        }
                        catch (Exception e) {
                            ToastYazdir("Lütfen giriş yapınız!");
                        }

                        break;
                    case R.id.btnIhtiyacAra:
                        activity(IhtiyacAra.class);
                        break;
                    case R.id.btnMesajBirak:
                        activity(Mesaj.class);
                        break;

                }
            }
        };

        btnGirisYap.setOnClickListener(Listener);
        btnBagisciOl.setOnClickListener(Listener);
        btnBagisciAra.setOnClickListener(Listener);
        btnIhtiyacAra.setOnClickListener(Listener);
        btnMesajBirak.setOnClickListener(Listener);



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
