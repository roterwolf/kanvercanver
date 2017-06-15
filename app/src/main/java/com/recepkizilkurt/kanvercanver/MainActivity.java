package com.recepkizilkurt.kanvercanver;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.Window;

//AppCompatActivity

public class MainActivity extends Activity {


    Button  btnGirisYap,btnBagisciOl, btnBagisciAra, btnIhtiyacAra, btnMesajBirak;
    View.OnClickListener Listener;
    String siteUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        install_elements();

    }

    private void install_elements() {
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
                        activity(KanAra.class);
                        break;
                    case R.id.btnIhtiyacAra:
                        activity(KanAra.class);
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

    private void activity (Class c)
    {
        Intent i =new Intent(MainActivity.this,c);
        i.putExtra("Url",siteUrl);
        startActivity(i);
    }
}
