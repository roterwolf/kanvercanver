package com.recepkizilkurt.kanvercanver;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.util.ArrayList;

/**
 * Created by recep.kizilkurt on 16.06.2017.
 */

public class Listele extends Activity {
    ArrayAdapter<String> adapterListele;
    String resp;
    ArrayList<String> data = new ArrayList<>();
    String Url = "http://kanvercanver.somee.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listele_layout);
        String kanGrubu =getIntent().getStringExtra("KanGrubu");
        String ili =getIntent().getStringExtra("Ili");
        String ilcesi =getIntent().getStringExtra("Ilcesi");

        new AspData().execute(kanGrubu,ili,ilcesi);
    }

   public class AspData extends AsyncTask<String, String, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }


        @Override
        protected String doInBackground(String... params) {
            DefaultHttpClient hc = new DefaultHttpClient();
            ResponseHandler response = new BasicResponseHandler();

            String KanGrubu = params[0];
            String Ili = params[1].split("-")[0];
            String Ilcesi = params[2];

            String thePath = getIntent().getStringExtra("Url") + "kanvercanver.asmx/bagisciAra?";
            thePath += "&kanGrubu=" + URLEncoder.encode(KanGrubu) ;
            thePath += "&ili=" + URLEncoder.encode(Ili) ;
            thePath += "&ilcesi=" + URLEncoder.encode(Ilcesi) ;

            thePath = getIntent().getStringExtra("Url") + "kanvercanver.asmx/ilListele?";
            try {
                HttpGet request = new HttpGet(thePath);
                resp = (String) hc.execute(request, response);
                resp = new GeneralActions().cutstr(resp);


                JSONArray json = new JSONArray(resp.trim());


                for (int i = 0; i<json.length();i++) {
                    JSONObject e = json.getJSONObject(i);
                    data.add(e.getString("adi") +" "+ e.getString("soyadi") +" - "+ e.getString("adres") +" - "+ e.getString("cepTelefonu"));
                }


                adapterListele = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,data);


            } catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }


        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            ListView lv = (ListView) findViewById(R.id.lvBagisicilar);
            lv.setAdapter(adapterListele);
        }

    }

}
