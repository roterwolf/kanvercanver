package com.recepkizilkurt.kanvercanver;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

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
 * Created by Recep KIZILKURT on 14/06/2017.
 */

public class KanAra extends Activity  implements
        OnItemSelectedListener {

    Button btnKanAraListele;
    Spinner spinnerKanAraKanGrubu,spinnerKanAraIli,spinnerKanAraIlcesi;
    View.OnClickListener btnListenerKanAra;
    View.OnClickListener spniliListenerKanAra;
    String resp;
    ArrayList<String> dataListIl = new ArrayList<String>();
    ArrayList<String> dataListIlce = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.kan_ara_layout);


        btnKanAraListele = (Button) findViewById(R.id.btnKanAraListele);
        spinnerKanAraKanGrubu = (Spinner) findViewById(R.id.spinnerKanAraKanGrubu);
        spinnerKanAraIli = (Spinner) findViewById(R.id.spinnerKanAraIli);
        spinnerKanAraIlcesi = (Spinner) findViewById(R.id.spinnerKanAraIlcesi);

        // Spinner click listener
        spinnerKanAraIli.setOnItemSelectedListener(this);



        ArrayAdapter<CharSequence> kgAdapterKanAra = ArrayAdapter.createFromResource(this,R.array.kangrubu,android.R.layout.simple_spinner_item);
		spinnerKanAraKanGrubu.setAdapter(kgAdapterKanAra);

        // Loading spinner data from database
        loadSpinnerData("",0);
		



        btnListenerKanAra =  new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                switch (v.getId()){
                    case R.id.btnKanAraListele:
                        activityKanAra(Listele.class);
                        break;
                  default:
                        break;

                }
            }
        };
        btnKanAraListele.setOnClickListener(btnListenerKanAra);
    }


    private void activityKanAra (Class c)   {
        Intent i =new Intent(KanAra.this,c);
        i.putExtra("Url",getIntent().getStringExtra("Url"));
        i.putExtra("KanGrubu",spinnerKanAraKanGrubu.getSelectedItem().toString());
        i.putExtra("Ili",spinnerKanAraIli.getSelectedItem().toString());
        i.putExtra("Ilcesi",spinnerKanAraIlcesi.getSelectedItem().toString());
        startActivity(i);
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
            spinnerKanAraIlcesi.setAdapter(dataAdapterilceler);

        } else {
            // Spinner Drop down elements
            List<String> iller = db.getAllili();

            // Creating adapter for spinner
            ArrayAdapter<String> dataAdapteriller = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, iller);

            // Drop down layout style - list view with radio button
            dataAdapteriller.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            // attaching data adapter to spinner
            spinnerKanAraIli.setAdapter(dataAdapteriller);
        }
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


}
