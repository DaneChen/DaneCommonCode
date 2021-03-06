package com.dane.commonsample.utils;

import android.app.ActivityManager;
import android.content.Context;

/**
 * Created by chen on 2017/4/13.
 */

public class AppUtils {

    /**
     * 获取当前app进程的名字
     * @param context
     * @return
     */
    public static String getCurProcessName(Context context) {
        int pid = android.os.Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningAppProcessInfo appProcess : activityManager.getRunningAppProcesses()) {
            if (appProcess.pid == pid) {
                return appProcess.processName;
            }
        }
        return null;
    }
}
