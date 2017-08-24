package com.acme.counterwithanimation;

import android.databinding.Bindable;
import android.util.Log;

public class CounterViewModel extends ObservableViewModel {

    private static final String TAG = CounterViewModel.class.getName();
    private int count = 0;

    public void increment() {
        count++;
        notifyChange();
        Log.i(TAG, "Counter [" + count + "]");
    }

    public void decrement() {
        count--;
        notifyChange();
        Log.i(TAG, "Counter: [" + count + "]");
    }

    @Bindable
    public String getCountLabel() {
        return String.valueOf(count);
    }

    @Bindable
    public boolean isEvenNumberVisible() {
        return count % 2 == 0;
    }

}
