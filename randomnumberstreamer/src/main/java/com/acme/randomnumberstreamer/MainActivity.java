package com.acme.randomnumberstreamer;

import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.acme.randomnumberstreamer.databinding.ActivityMainBinding;

public class MainActivity extends LifecycleActivity {

    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
//
 //        final ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
//        binding.setViewModel(mainViewModel);
//
//        mainViewModel.randomLiveData.observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                Log.d("MainActivity", "New value posted -> " + s);
//            }
//        });
    }
}
