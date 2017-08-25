package com.acme.counter;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class CounterViewModelTest {

    private CounterViewModel counterViewModel;

    @Before
    public void setup() {
        counterViewModel = new CounterViewModel();
    }

    @Test
    public void testInitialState() {
        Assert.assertEquals(0, counterViewModel.getCount());
    }

    @Test
    public void testIncrement() {
        for (int i = 1; i <= 5; i++) {
            counterViewModel.increment();
            Assert.assertEquals(i, counterViewModel.getCount());
        }
    }

    @Test
    public void testDecrement() {
        for (int i = 1; i <= 5; i++) {
            counterViewModel.decrement();
            Assert.assertEquals(i * -1, counterViewModel.getCount());
        }
    }
}