package com.acme.counterwithanimation;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.acme.counterwithanimation.databinding.ActivityCounterBinding;

public class CounterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        CounterViewModel viewModel = ViewModelProviders.of(this).get(CounterViewModel.class);

        ActivityCounterBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_counter);
        binding.setViewModel(viewModel);
    }

}
