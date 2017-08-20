package com.acme.loginform;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class LoginViewModel extends ViewModel {

    public enum State { WAITING_USER, ATTEMPTING_LOGIN, AUTHENTICATED  }
    private SharedPrefsUtils sharedPrefs = SharedPrefsUtils.getInstance();
    private FakeLoginService loginService = new FakeLoginService();

    public String username = sharedPrefs.getLastUsername();
    public String password = "";

    public MutableLiveData<State> state = new MutableLiveData<>();
    public MutableLiveData<String> error = new MutableLiveData<>();

    public void login() {

        state.postValue(State.ATTEMPTING_LOGIN);
        updateLastUsedUsername();

        loginService.attemptLogin(username, password, new FakeLoginService.LoginCallback() {
            @Override
            public void onSuccess(FakeLoginService.User user) {
                state.postValue(State.AUTHENTICATED);
            }

            @Override
            public void onFailure(Throwable e) {
                error.postValue("Login Error!!");
                state.postValue(State.WAITING_USER);
            }
        });
    }

    private void updateLastUsedUsername() {
        sharedPrefs.setLastUsername(username);
    }
}
