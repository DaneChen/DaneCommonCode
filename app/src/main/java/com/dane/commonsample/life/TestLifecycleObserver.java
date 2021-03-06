package com.dane.commonsample.life;

import com.dane.commonsample.viewmodel.TestViewModel;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

/**
 * @author chengr
 * description:
 * create on 2021/2/23
 */
public class TestLifecycleObserver implements LifecycleObserver {

    private TestViewModel mTestViewModel;

    public TestLifecycleObserver(TestViewModel mTestViewModel) {
        this.mTestViewModel = mTestViewModel;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void getData(){
        mTestViewModel.getData();
    }
}
