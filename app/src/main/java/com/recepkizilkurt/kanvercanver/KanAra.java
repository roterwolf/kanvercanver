package com.recepkizilkurt.kanvercanver;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

/**
 * Created by Recep KIZILKURT on 14/06/2017.
 */

public class KanAra extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.kan_ara_layout);

    }
}
