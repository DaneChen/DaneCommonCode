package com.dane.commonsample.viewmodel;

import android.os.AsyncTask;

import com.dane.commonsample.UI.TestKotlin;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * @author chengr
 * description:
 * create on 2021/2/23
 */
public class TestViewModel extends ViewModel {

    private MutableLiveData<Integer> testLiveData;

    public TestViewModel() {
        this.testLiveData = new MutableLiveData<>();
    }

    public void getData(){
        new AsyncTask<Void, Void, Integer>() {
            @Override
            protected void onPostExecute(Integer s) {
                testLiveData.setValue(s);//抛出用户信息
            }
            @Override
            protected Integer doInBackground(Void... voids) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return 10;
            }
        }.execute();

        TestKotlin.Companion.testBaseDataType();
    }

    public LiveData<Integer> getUserLiveData() {
        return testLiveData;
    }
}
