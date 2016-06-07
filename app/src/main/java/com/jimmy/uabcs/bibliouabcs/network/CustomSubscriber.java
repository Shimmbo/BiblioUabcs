package com.jimmy.uabcs.bibliouabcs.network;

import android.util.Log;

import rx.Subscriber;
public class CustomSubscriber<T> extends Subscriber<T> {
    private static final String TAG = "library";
    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");
    }

    @Override
    public void onCompleted() {
        Log.i(TAG, "onCompleted");
    }

    @Override
    public void onError(Throwable e) {
        Log.e(TAG, e.getMessage());
    }

    @Override
    public void onNext(T t) {
        Log.i(TAG, "onNext");
    }
}
