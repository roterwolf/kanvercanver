package com.recepkizilkurt.kanvercanver;

import android.widget.Toast;

/**
 * Created by recep.kizilkurt on 28.06.2017.
 */

public class GeneralActions {
    public String cutstr(String str){
        str =  str.replace("<?xml version=\"1.0\" encoding=\"utf-8\"?>","");
        str =  str.replace("<string xmlns=\"http://kanvercanver.somee.com/\">","");
        str =  str.replace("</string>","");
        str=str.replace("\\r\\n","");
        str.substring(2,str.length());
        return str;
    }
}
