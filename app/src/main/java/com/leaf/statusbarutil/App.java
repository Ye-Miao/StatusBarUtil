package com.leaf.statusbarutil;

import android.app.Application;

/**
 * @author：created by leaf on 2019-05-08
 * Github地址：https://github.com/Ye-Miao
 * Desc:
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AppUtils.init(this);
    }
}
