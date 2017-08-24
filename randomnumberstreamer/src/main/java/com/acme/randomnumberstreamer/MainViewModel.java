package com.acme.randomnumberstreamer;

public class MainViewModel extends ObservableViewModel {

    private RandomNumberStreamer randomNumberStreamer;
    public BindableLiveData<String> randomLiveData;

    public MainViewModel() {
        randomNumberStreamer = new RandomNumberStreamer();
        randomLiveData = randomNumberStreamer.openLiveNumberStream(2);
    }

    @Override
    protected void onCleared() {
        randomNumberStreamer.cancelTimer();
    }
}
