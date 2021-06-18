package com.dane.commonsample.life;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class ActivityLifeCycleObserver implements LifecycleObserver {

    private String name;

    public ActivityLifeCycleObserver(String name){
        this.name = name;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate(){
        log("onCreate");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart(){
        log("onStart");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume(){
        log("onResume");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause(){
        log("onPause");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop(){
        log("onStop");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy(){
        log("onDestroy");
    }

    private void log(String content){
        Log.d(name, content);
    }
}
