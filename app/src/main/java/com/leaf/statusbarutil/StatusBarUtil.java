package com.leaf.statusbarutil;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.annotation.IntRange;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

/**
 * @author：created by leaf on 2019-05-07
 * Github地址：https://github.com/Ye-Miao
 * Desc: 状态栏工具类
 */
public class StatusBarUtil {

    private static final int DEFAULT_COLOR = 0;
    private static final int DEFAULT_ALPHA = 0;


    /**
     * 设置状态栏颜色
     *
     * @param activity 当前界面
     * @param color    状态栏颜色值
     */
    public static void setColor(Activity activity, @ColorInt int color) {
        setColor(activity.getWindow(), color, DEFAULT_ALPHA);
    }

    /**
     * 设置纯色状态栏（自定义颜色，alpha）
     *
     * @param activity 当前界面
     * @param color    状态栏颜色值
     * @param alpha    状态栏透明度
     */
    public static void setColor(Activity activity, @ColorInt int color, @IntRange(from = 0, to = 255) int alpha) {
        setColor(activity.getWindow(), color, alpha);
    }

    /**
     * 设置状态栏颜色
     *
     * @param window 当前界面的window
     * @param color  状态栏颜色值
     * @param alpha  状态栏透明度
     */
    private static void setColor(Window window, @ColorInt int color, @IntRange(from = 0, to = 255) int alpha) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(cipherColor(color, alpha));
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            setTranslucentView((ViewGroup) window.getDecorView(), color, alpha);
        }
    }

    /**
     * 设置状态栏渐变颜色
     *
     * @param activity 当前界面
     */
    public static void setGradientColor(Activity activity, View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            activity.getWindow().setStatusBarColor(cipherColor(DEFAULT_COLOR, DEFAULT_ALPHA));
            setTransparentForWindow(activity);
            setPaddingTop(activity, view);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            setTranslucentView((ViewGroup) activity.getWindow().getDecorView(), StatusBarUtil.DEFAULT_COLOR, DEFAULT_ALPHA);
            setPaddingTop(activity, view);
        }
    }


    /**
     * 设置透明
     */
    public static void setTransparentForWindow(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            activity.getWindow().setStatusBarColor(Color.TRANSPARENT);
            activity.getWindow()
                    .getDecorView()
                    .setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            activity.getWindow()
                    .setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }

    /**
     * 增加View的paddingTop,增加的值为状态栏高度 (智能判断，并设置高度)
     *
     * @param context 当前Context
     * @param view    需要增高的View
     */
    private static void setPaddingTop(Context context, View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            ViewGroup.LayoutParams lp = view.getLayoutParams();
            if (lp != null && lp.height > 0) {
                lp.height += getStatusBarHeight(context);
            }
            view.setPadding(view.getPaddingLeft(), view.getPaddingTop() + getStatusBarHeight(context),
                    view.getPaddingRight(), view.getPaddingBottom());
        }
    }


    /**
     * 计算alpha色值
     *
     * @param color 状态栏颜色值
     * @param alpha 状态栏透明度
     */
    private static int cipherColor(@ColorInt int color, int alpha) {
        if (alpha == 0) {
            return color;
        }
        float a = 1 - alpha / 255f;
        int red = color >> 16 & 0xff;
        int green = color >> 8 & 0xff;
        int blue = color & 0xff;
        red = (int) (red * a + 0.5);
        green = (int) (green * a + 0.5);
        blue = (int) (blue * a + 0.5);
        return 0xff << 24 | red << 16 | green << 8 | blue;
    }


    private static void setTranslucentView(ViewGroup viewGroup, @ColorInt int color, @IntRange(from = 0, to = 255) int alpha) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            int cipherColor = cipherColor(color, alpha);
            View translucentView = viewGroup.findViewById(android.R.id.custom);
            if (translucentView == null) {
                if (cipherColor != 0) {
                    translucentView = new View(viewGroup.getContext());
                    translucentView.setId(android.R.id.custom);
                    ViewGroup.LayoutParams params =
                            new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, getStatusBarHeight(viewGroup.getContext()));
                    viewGroup.addView(translucentView, params);
                }
            } else {
                translucentView.setBackgroundColor(cipherColor);
            }
        }
    }

    private static int getStatusBarHeight(Context context) {
        int result = 24;
        // 获得状态栏高度
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        } else {
            TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, result, Resources.getSystem().getDisplayMetrics());
        }
        return result;
    }
}
