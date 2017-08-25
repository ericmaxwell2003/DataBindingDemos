package com.acme.counterwithanimation;

import android.databinding.Bindable;
import android.util.Log;

public class CounterViewModel extends ObservableViewModel {

    private int count = 0;

    public void increment() {
        count++;
        notifyChange();
    }

    public void decrement() {
        count--;
        notifyChange();
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
