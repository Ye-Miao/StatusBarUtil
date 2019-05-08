package com.leaf.statusbarutil;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Looper;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import android.os.Handler;
import android.support.annotation.ArrayRes;
import android.support.annotation.StringRes;
import android.support.v4.content.ContextCompat;

/**
 * @author：created by leaf on 2019-05-08
 * Github地址：https://github.com/Ye-Miao
 * Desc: 工具类
 */
public class AppUtils {

    private static Context mContext;

    public static void init(Context context) { //在Application中初始化
        mContext = context;
    }

    public static Context getAppContext() {
        return mContext;
    }

    public static AssetManager getAssets() {
        return mContext.getAssets();
    }

    public static float getDimension(int id) {
        return getResource().getDimension(id);
    }

    public static Resources getResource() {
        return mContext.getResources();
    }

    public static Drawable getDrawable(int resId) {
        return ContextCompat.getDrawable(mContext, resId);
    }

    public static int getColor(int resId) {
        return ContextCompat.getColor(mContext,resId);
    }

    public static String getString(@StringRes int resId) {
        return mContext.getResources().getString(resId);
    }

    public static String[] getStringArray(@ArrayRes int resId) {
        return mContext.getResources().getStringArray(resId);
    }

}