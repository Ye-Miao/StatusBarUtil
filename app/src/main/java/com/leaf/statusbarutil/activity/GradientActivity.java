package com.leaf.statusbarutil.activity;

import android.annotation.SuppressLint;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.TextView;

import com.leaf.library.StatusBarUtil;
import com.leaf.statusbarutil.R;
import com.leaf.statusbarutil.utils.AppUtils;

import java.util.Random;

/**
 * @author：created by leaf on 2019/5/23
 * Github地址：https://github.com/Ye-Miao
 * Desc:
 */
public class GradientActivity extends AppCompatActivity {

    private Toolbar mToolbar;

    @SuppressLint("SetTextI18n")
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gradient_color);

        mToolbar = findViewById(R.id.toolbar);
        Button mSetGradient = findViewById(R.id.set_gradient);
        TextView mVersionText = findViewById(R.id.version_text);

        changeColor();

        mSetGradient.setOnClickListener(v -> {
            changeColor();
        });

        mVersionText.setText(
                "手机厂商" + AppUtils.getDeviceBrand() + "\n" +
                        "手机型号" + AppUtils.getSystemModel() + "\n" +
                        "Android系统版本号" + AppUtils.getSystemVersion()
        );
    }

    @SuppressLint("NewApi")
    private void changeColor() {
        Random random = new Random();
        int mStartColor = 0xff000000 | random.nextInt(0xffffff);
        int mEndColor = 0xff000000 | random.nextInt(0xffffff);
        int[] colors = {mStartColor, mEndColor};
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, colors);

        mToolbar.setBackground(gradientDrawable);
        StatusBarUtil.setGradientColor(GradientActivity.this, mToolbar);
    }
}
