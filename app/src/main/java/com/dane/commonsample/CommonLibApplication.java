package com.dane.commonsample;

import android.app.Application;

import com.dane.commonsample.utils.AppUtils;

/**
 * Created by chen on 2017/4/13.
 */

public class CommonLibApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        
        checkPackageName();
    }

    private void checkPackageName() {

        //这两个方法的效果是一致的，有部分的app会做这个判断，通过此判断才做初始化，不知道什么目的
        String current = AppUtils.getCurProcessName(this);
        String mainProcessName = getPackageName();
        if( mainProcessName.equals(current))
        {
            return;
        }
    }
}
