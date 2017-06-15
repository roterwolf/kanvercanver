package com.recepkizilkurt.kanvercanver;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

/**
 * Created by recep.kizilkurt on 14.06.2017.
 */

public class UyeGiris extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.uye_giris_layout);
    }
}
