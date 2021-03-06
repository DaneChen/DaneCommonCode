package com.dane.commonsample.UI;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.dane.commonsample.R;
import com.dane.commonsample.life.TestLifecycleObserver;
import com.dane.commonsample.test.TestMap;
import com.dane.commonsample.viewmodel.TestViewModel;
import com.dane.toollib.util.NotificationUtil;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

/**
 * @author chengr
 * description:
 * create on 2021/2/23
 */
public class TestViewModelActivity extends AppCompatActivity {

    public static void startActivity(Context context) {
        context.startActivity(new Intent(context, TestViewModelActivity.class));
    }

    private TextView mTvTestResult;

    private TestViewModel userViewModel = null;

    private AudioManager mAm;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_view_model);
        mTvTestResult = findViewById(R.id.id_tv_test_result);

        userViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(TestViewModel.class);
        addObserver();
        getLifecycle().addObserver(new TestLifecycleObserver(userViewModel));


        mAm = (AudioManager)getSystemService(AUDIO_SERVICE);

        TestMap.testRemoveMap();

        getWindow().getDecorView().postDelayed(new Runnable() {
            @Override
            public void run() {
                //testNotification();

                getWindow().getDecorView().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        requestFocus();
                        mAm.abandonAudioFocus(afChangeListener);
                        NotificationManager mNotificationManager = (NotificationManager)TestViewModelActivity.this.getSystemService(Context.NOTIFICATION_SERVICE);
                        //mNotificationManager.notify(1, notification);
                    }
                }, 1000);
            }
        }, 1000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //mAm.abandonAudioFocus(afChangeListener);
    }

    private void addObserver() {
        userViewModel.getUserLiveData().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                mTvTestResult.setText(String.valueOf(integer));
            }
        });
    }

    private boolean requestFocus() {
        // Request audio focus for playback
        //mAm.requestAudioFocus(new AudioFocusRequest(){})
        int result = mAm.requestAudioFocus(afChangeListener,
                // Use the music stream.
                AudioManager.STREAM_VOICE_CALL,
                // Request permanent focus.
                AudioManager.AUDIOFOCUS_GAIN);
        Log.d("TestViewModelActivity", "onAudioFocusChange=requestFocus=" + result);
        return result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED;
    }


    private Notification notification = null;
    private void testNotification() {
        NotificationManager mNotificationManager = (NotificationManager)
                this.getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationUtil.Channel channel = new NotificationUtil.Channel("123444", "测试通知",
                NotificationManager.IMPORTANCE_MIN, "测试通知描述", NotificationCompat.VISIBILITY_PUBLIC,
                new long[]{0, 500}, null);
        notification = NotificationUtil.Companion.createNotificationBuilder(this, channel, "我是title", "我的content", null).build();
        mNotificationManager.notify(1, notification);
    }

    AudioManager.OnAudioFocusChangeListener afChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        public void onAudioFocusChange(int focusChange) {

            Log.d("TestViewModelActivity", "onAudioFocusChange=" + focusChange);

            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT) {
                // Pause playback
                //pause();
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                // Resume playback
                //();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                // mAm.unregisterMediaButtonEventReceiver(RemoteControlReceiver);
                mAm.abandonAudioFocus(afChangeListener);
                // Stop playback
                //stop();
            }
        }
    };

}
