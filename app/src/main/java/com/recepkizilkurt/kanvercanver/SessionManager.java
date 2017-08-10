package com.recepkizilkurt.kanvercanver;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by recep.kizilkurt on 2.08.2017.
 */

public class SessionManager {
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    private static final String PREF_NAME    = "com.recepkizilkurt.kanvercanver";

    private static SessionManager mSessionManager;

    private SessionManager() {

    }

    private SessionManager(Context context){
        mSharedPreferences = context.getSharedPreferences(PREF_NAME, 0);
        mEditor = mSharedPreferences.edit();
    }

    public static SessionManager getInstance(){
        if (mSessionManager == null)
            mSessionManager = new SessionManager();

        return mSessionManager;
    }

    public static SessionManager getInstance(Context context){
        if (mSessionManager == null)
            mSessionManager = new SessionManager(context);

        return mSessionManager;
    }

    public void setContext(Context context) {
        mSharedPreferences = context.getSharedPreferences(PREF_NAME, 0);
        mEditor = mSharedPreferences.edit();
    }

    public void setBoolValue(String key, boolean value) {
        mEditor.putBoolean(key, value);
        mEditor.commit();
    }
    public void setIntValue(String key, Integer value) {
        mEditor.putInt(key, value);
        mEditor.commit();
    }
    public void setStrValue(String key, String value) {
        mEditor.putString(key, value);
        mEditor.commit();
    }
    public boolean getBoolValue(String key) {
        return mSharedPreferences.getBoolean(key,false);
    }

    public Integer getIntValue(String key) {
        return mSharedPreferences.getInt(key,0);
    }
    public String getStrValue(String key) {
        return mSharedPreferences.getString(key,null);
    }
}