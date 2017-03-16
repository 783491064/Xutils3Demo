package com.example.bjc.xutils3demo;

import android.app.Application;

import org.xutils.x;

/**
 * Created by 毕静存 on 2016/11/14.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(true);

    }
}
