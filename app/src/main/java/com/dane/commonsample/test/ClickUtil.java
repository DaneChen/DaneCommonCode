package com.dane.commonsample.test;

import android.view.View;

/**
 * @author chengr
 * description:
 * create on 2021/3/11
 */
public class ClickUtil {

    public static void fastClick(final View view, final View.OnClickListener clickListener){
        if( view == null || clickListener == null){
            return;
        }
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onClick(v);
                view.setClickable(false);
                view.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        view.setClickable(true);
                    }
                }, 500);
            }
        });
    }

}
