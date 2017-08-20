package com.acme.loginform;

import android.app.Application;

public class LoginFormApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        SharedPrefsUtils.init(this);
    }
}
