package com.acme.counter;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.util.Log;
import android.view.View;

public class CounterViewModel extends BaseObservable {

    private int count = 0;

    public void increment() {
        setCount(getCount() + 1);
    }

    public void decrement() {
        setCount(getCount() - 1);
    }

    @Bindable
    public int getCount() {
        return count;
    }

    private void setCount(int count) {
        this.count = count;
        notifyPropertyChanged(BR.count);
    }
}
