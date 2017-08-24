package com.acme.randomnumberstreamer;

import android.arch.lifecycle.LiveData;
import android.databinding.Bindable;
import android.databinding.Observable;
import android.databinding.PropertyChangeRegistry;
import android.support.annotation.Nullable;
import com.acme.randomnumberstreamer.BR;

public class BindableLiveData<T> extends LiveData<T> implements Observable {

    public BindableLiveData(T data) {
        setValue(data);
    }

    @Bindable
    @Nullable
    @Override
    public T getValue() {
        return super.getValue();
    }

    @Override
    public void postValue(T value) {
        super.postValue(value);
        notifyPropertyChanged(BR.value);
    }

    @Override
    public void setValue(T value) {
        super.setValue(value);
        notifyPropertyChanged(BR.value);
    }

    private transient PropertyChangeRegistry mCallbacks;

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {
        synchronized (this) {
            if (mCallbacks == null) {
                mCallbacks = new PropertyChangeRegistry();
            }
        }

        mCallbacks.add(callback);
    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {
        synchronized (this) {
            if (mCallbacks == null) {
                return;
            }
        }
        mCallbacks.remove(callback);
    }

    /**
     * Notifies listeners that all properties of this instance have changed.
     */
    public void notifyChange() {
        synchronized (this) {
            if (mCallbacks == null) {
                return;
            }
        }
        mCallbacks.notifyCallbacks(this, 0, null);
    }

    /**
     * Notifies listeners that a specific property has changed. The getter for the property
     * that changes should be marked with {@link Bindable} to generate a field in
     * <code>BR</code> to be used as <code>fieldId</code>.
     *
     * @param fieldId The generated BR id for the Bindable field.
     */
    public void notifyPropertyChanged(int fieldId) {
        synchronized (this) {
            if (mCallbacks == null) {
                return;
            }
        }
        mCallbacks.notifyCallbacks(this, fieldId, null);
    }

}
