package com.acme.counter;

import android.databinding.Bindable;
import android.util.Log;

public class CounterViewModel extends ObservableViewModel {

    private static final String TAG = CounterViewModel.class.getName();
    private int count = 0;

    public void increment() {
        count++;
        notifyPropertyChanged(BR.countLabel);
        Log.i(TAG, "Counter [" + count + "]");
    }

    public void decrement() {
        count--;
        notifyPropertyChanged(BR.countLabel);
        Log.i(TAG, "Counter: [" + count + "]");
    }

    @Bindable
    public String getCountLabel() {
        return String.valueOf(count);
    }

}
