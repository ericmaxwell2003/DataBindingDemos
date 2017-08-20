package com.acme.loginform;

import android.app.ProgressDialog;
import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.Toast;

import com.acme.loginform.databinding.ActivityLoginBinding;

public class LoginActivity extends LifecycleActivity {

    public ProgressDialog progressDialog;
    public LoginViewModel viewModel;
    public Button loginButton;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityLoginBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        loginButton = findViewById(R.id.login_button);

        viewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
        binding.setVm(viewModel);

        bindProgressDialog();
        bindErrors();
    }


    private void bindProgressDialog() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setMessage(getString(R.string.login_connecting_text));

        viewModel.state.observe(this, new Observer<LoginViewModel.State>() {
            @Override
            public void onChanged(@Nullable LoginViewModel.State state) {

                if(state == null) { return; }

                switch (state) {
                    case WAITING_USER:
                        hideProgress();
                        break;
                    case ATTEMPTING_LOGIN:
                        showProgress();
                        break;
                    case AUTHENTICATED:
                        authSuccessful();
                        break;
                }

            }
        });
    }

    private void bindErrors() {
        viewModel.error.observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String errorMessage) {
                if(!TextUtils.isEmpty(errorMessage)) {
                    showMessage(errorMessage);
                }
            }
        });
    }

    private void authSuccessful() {
        hideProgress();
        // In real app would go to next screen.
        showMessage(getString(R.string.login_success));
    }

    private void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void showProgress() {
        loginButton.setEnabled(false);
        progressDialog.show();
    }

    private void hideProgress() {
        loginButton.setEnabled(true);
        progressDialog.dismiss();
    }

}

