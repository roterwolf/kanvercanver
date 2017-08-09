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
import java.util.List;

/**
 * Created by recep.kizilkurt on 16.06.2017.
 */

public class IhtiyacAra extends Activity implements
            OnItemSelectedListener {
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

        // Spinner click listener
        spinnerIAIli.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> kgAdapterIA = ArrayAdapter.createFromResource(this,R.array.kangrubu,android.R.layout.simple_spinner_item);
        spinnerIAKanGrubu.setAdapter(kgAdapterIA);

        // Loading spinner data from database
        loadSpinnerData("",0);


        //siteUrlIA = "http://kanvercanver.somee.com/";
        siteUrlIA = "http://www.recepkurt.somee.com/";
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
        i.putExtra("MetodName","ihtiyacSahibiAra?");
        startActivity(i);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        // On selecting a spinner item
        long ilkodu = adapterView.getItemIdAtPosition(i)+1;
        loadSpinnerData("ilcelistele",ilkodu);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

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
            spinnerIAIlcesi.setAdapter(dataAdapterilceler);

        } else {
            // Spinner Drop down elements
            List<String> iller = db.getAllili();

            // Creating adapter for spinner
            ArrayAdapter<String> dataAdapteriller = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, iller);

            // Drop down layout style - list view with radio button
            dataAdapteriller.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            // attaching data adapter to spinner
            spinnerIAIli.setAdapter(dataAdapteriller);
        }
    }
}
