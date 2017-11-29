package com.playground.academy.britt.networkingdemo.data;

/**
 * Created by britt on 11/22/17.
 */

public abstract class MyCallback<T> {
    protected int index = -1;

    public MyCallback(int index) {
        this.index = index;
    }

    public MyCallback() {
        this(-1);
    }

    public abstract void onSuccess(T data);

    public abstract void onFailure();


    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
