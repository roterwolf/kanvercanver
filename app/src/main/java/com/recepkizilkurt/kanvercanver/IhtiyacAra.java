package com.recepkizilkurt.kanvercanver;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by recep.kizilkurt on 16.06.2017.
 */

public class IhtiyacAra extends Activity{
    Button btnIAKanAra;
    Spinner spinnerIAKanGrubu,spinnerIAIli,spinnerIAIlcesi;
    View.OnClickListener ListenerIA;
    String siteUrlIA;
    String resp;
    ArrayList<String> dataListIl = new ArrayList<String>();
    ArrayList<String> dataListIlce = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ihtiyac_ara_layout);

        btnIAKanAra = (Button) findViewById(R.id.btnIAKanAra);
        spinnerIAKanGrubu = (Spinner) findViewById(R.id.spinnerIAKanGrubu);
        spinnerIAIli = (Spinner) findViewById(R.id.spinnerIAIli);
        spinnerIAIlcesi = (Spinner) findViewById(R.id.spinnerIAIlcesi);

        new AspDataKanAra().execute("ilListele?");
        install_elements();
    }

    private void install_elements() {

        ArrayAdapter<CharSequence> kgAdapterIA = ArrayAdapter.createFromResource(this,R.array.kangrubu,android.R.layout.simple_spinner_item);

        ArrayAdapter<String> iliAdapterIA = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,dataListIl);

        //ArrayAdapter<CharSequence> ilcesiAdapterIA= ArrayAdapter.createFromResource(this,R.array.ilcesi,android.R.layout.simple_spinner_item);


        spinnerIAKanGrubu.setAdapter(kgAdapterIA);
        spinnerIAIli.setAdapter(iliAdapterIA);
        //spinnerIAIlcesi.setAdapter(ilcesiAdapterIA);
        siteUrlIA = "http://kanvercanver.somee.com/";
        ListenerIA =  new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.btnIAKanAra:
                        activityIA(Listele.class);
                        break;
                    default:
                        break;
                }
            }
        };
        btnIAKanAra.setOnClickListener(ListenerIA);
    }
    private void activityIA (Class c)    {
        Intent i =new Intent(IhtiyacAra.this,c);
        i.putExtra("Url",siteUrlIA);
        i.putExtra("KanGrubu",spinnerIAKanGrubu.getSelectedItem().toString());
        i.putExtra("Ili",spinnerIAIli.getSelectedItem().toString());
        i.putExtra("Ilcesi",spinnerIAIlcesi.getSelectedItem().toString());
        startActivity(i);
    }

    public class AspDataKanAra extends AsyncTask<String, String, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }


        @Override
        protected String doInBackground(String... params) {
            DefaultHttpClient hc = new DefaultHttpClient();
            ResponseHandler response = new BasicResponseHandler();

            String MetodName = params[0];
            String thePath = getIntent().getStringExtra("Url") + "kanvercanver.asmx/"+MetodName;
            try {
                HttpGet request = new HttpGet(thePath);
                resp = (String) hc.execute(request, response);
                resp = new GeneralActions().cutstr(resp);

                JSONArray json = new JSONArray(resp.trim());

                for (int i = 0; i<json.length();i++) {
                    JSONObject e = json.getJSONObject(i);
                    if(MetodName.equals("ilListele?"))
                        dataListIl.add(e.getString("name"));
                    else
                        dataListIlce.add(e.getString("name"));
                }

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
        }

    }
}
