package com.acme.counter;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.acme.counter.databinding.ActivityCounterBinding;

public class CounterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityCounterBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_counter);
        binding.setViewModel(new CounterViewModel());
    }

}
