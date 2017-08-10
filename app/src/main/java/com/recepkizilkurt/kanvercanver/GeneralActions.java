package com.recepkizilkurt.kanvercanver;

import android.content.pm.PackageInstaller;
import android.icu.text.SimpleDateFormat;

import java.net.PasswordAuthentication;
import java.text.ParseException;
import java.util.Date;
import java.util.Properties;

/**
 * Created by recep.kizilkurt on 28.06.2017.
 */

public class GeneralActions {
    public String cutstr(String str){
        str =  str.replace("<?xml version=\"1.0\" encoding=\"utf-8\"?>","");
        str =  str.replace("<string xmlns=\"http://kanvercanver.somee.com/\">","");
        str =  str.replace("<string xmlns=\"http://www.recepkurt.somee.com/\">","");
        str =  str.replace("</string>","");
        str=str.replace("\\r\\n","");
        str.substring(2,str.length());

        return str;
    }
    public String convertDate(String dateString){

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
        String[] newDateArr = dateString.split("-");
        String newDate = newDateArr[2].split("T")[0]+"/"+newDateArr[1]+"/"+newDateArr[0];


        return newDate;
    }

}
