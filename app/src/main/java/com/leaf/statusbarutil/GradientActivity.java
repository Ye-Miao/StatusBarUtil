package com.leaf.statusbarutil;

import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;

import java.util.Random;

/**
 * @author：created by leaf on 2019/5/23
 * Github地址：https://github.com/Ye-Miao
 * Desc:
 */
public class GradientActivity extends AppCompatActivity {

    private int mStartColor;
    private int mEndColor;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gradient_color);

        Toolbar mToolbar = findViewById(R.id.toolbar);
        Button mSetGradient21 = findViewById(R.id.set_gradient_21);
        Button mSetGradient19 = findViewById(R.id.set_gradient_19);

        mSetGradient21.setOnClickListener(v -> {
            Random random = new Random();
            mStartColor = 0xff000000 | random.nextInt(0xffffff);
            mEndColor = 0xff000000 | random.nextInt(0xffffff);
            int[] colors = {mStartColor, mEndColor};
            GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, colors);

            mToolbar.setBackground(gradientDrawable);
            StatusBarUtil.setGradientColor(GradientActivity.this, mToolbar);
        });

        mSetGradient19.setOnClickListener(v -> {
            Random random = new Random();
            mStartColor = 0xff000000 | random.nextInt(0xffffff);
            mEndColor = 0xff000000 | random.nextInt(0xffffff);
            int[] colors = {mStartColor, mEndColor};
            GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, colors);

            mToolbar.setBackground(gradientDrawable);
            StatusBarUtil.setGradientColor(GradientActivity.this, gradientDrawable);
        });

    }
}
