package com.acme.loginform;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SharedPrefsUtils {

    private static final String LAST_USER_KEY = "com.acme.loginform.lastuser";
    private static SharedPrefsUtils privateInstance;

    private SharedPreferences sharedPreferences;

    public static void init(Application application) {
        if(privateInstance == null) {
            privateInstance = new SharedPrefsUtils(application);
        }
    }

    private SharedPrefsUtils(Application application) {
        this.sharedPreferences = PreferenceManager.getDefaultSharedPreferences(application);
    }

    public static SharedPrefsUtils getInstance() {
        return privateInstance;
    }

    public String getLastUsername() {
        return sharedPreferences.getString(LAST_USER_KEY, "");
    }

    public void setLastUsername(String value) {
        sharedPreferences.edit().putString(LAST_USER_KEY, value).apply();
    }

}
