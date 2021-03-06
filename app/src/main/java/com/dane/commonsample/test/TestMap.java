package com.dane.commonsample.test;

import android.util.Log;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author chengr
 * description:
 * create on 2021/3/6
 */
public class TestMap {

    private static final String TAG = "TestMap";

    public static void testRemoveMap(){

        Map<String, String> mapData = new HashMap<>();
        mapData.put("1", "a");
        mapData.put("2", "b");
        mapData.put("3", "c");
        mapData.put("4", "d");
        mapData.put("5", "e");

        Iterator<Map.Entry<String, String>> iterator =mapData.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, String> entry = iterator.next();
            iterator.remove();
            Log.d(TAG, "testRemoveMap:removed=" + entry.getKey() + " size=" + mapData.size());
        }
        testRemoveMap2();
    }

    public static void testRemoveMap2(){

        Map<String, String> mapData = new HashMap<>();
        mapData.put("1", "a");
        mapData.put("2", "b");
        mapData.put("3", "c");
        mapData.put("4", "d");
        mapData.put("5", "e");

/*        Set<String> keySet =  mapData.keySet();
        for( String fileId : keySet){
            mapData.remove(fileId);
            keySet.remove(fileId);
            Log.d(TAG, "testRemoveMap2:removed=" + fileId + " size=" + mapData.size());
        }*/

        Iterator<String> iterator = mapData.keySet().iterator();
        while (iterator.hasNext()){
            String entry = iterator.next();
            iterator.remove();
            Log.d(TAG, "testRemoveMap2:removed=" + entry+ " size=" + mapData.size());
        }

     /*   Iterator<Map.Entry<String, String>> iterator =mapData.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, String> entry = iterator.next();
            mapData.remove(entry.getKey());
            Log.d(TAG, "testRemoveMap2:removed=" + entry.getKey());
        }*/

    }

}
