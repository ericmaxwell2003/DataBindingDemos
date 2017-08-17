package com.acme.counter;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.acme.counter.databinding.ActivityCounterBinding;

public class CounterActivity extends AppCompatActivity {

    private CounterViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        viewModel = ViewModelProviders.of(this).get(CounterViewModel.class);
        ActivityCounterBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_counter);
        binding.setViewModel(viewModel);

    }
}
