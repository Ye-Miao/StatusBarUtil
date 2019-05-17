package com.leaf.statusbarutil;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import java.util.Random;


/**
 * @author：created by leaf on 2019-05-07
 * Github地址：https://github.com/Ye-Miao
 * Desc: 主界面
 */
public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private Button btn;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;

    private int mStartColor;
    private int mEndColor;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = findViewById(R.id.toolbar);
        StatusBarUtil.setColor(MainActivity.this, AppUtils.getColor(R.color.start_blue));
        setSupportActionBar(mToolbar);


        btn = findViewById(R.id.btn);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);

        //TODO 设置状态栏颜色
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                mStartColor = 0xff000000 | random.nextInt(0xffffff);

                mToolbar.setBackgroundColor(mStartColor);
                StatusBarUtil.setColor(MainActivity.this, mStartColor);
            }
        });

        //TODO 设置透明
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TransparentActivity.class));
            }
        });

        //TODO 设置状态栏渐变
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                mStartColor = 0xff000000 | random.nextInt(0xffffff);
                mEndColor = 0xff000000 | random.nextInt(0xffffff);
                int[] colors = {mStartColor, mEndColor};
                GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, colors);

                mToolbar.setBackground(gradientDrawable);
                StatusBarUtil.setGradientColor(MainActivity.this, mToolbar);
            }
        });

        //TODO 在fragment中使用
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, InFragmentActivity.class));
            }
        });

        //设置状态栏模式（亮光）
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StatusBarUtil.setColor(MainActivity.this, AppUtils.getColor(R.color.start_blue));
                mToolbar.setBackgroundColor(AppUtils.getColor(R.color.start_blue));
                StatusBarUtil.setLightMode(MainActivity.this);
            }
        });
        //TODO 设置状态栏模式（暗色）
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StatusBarUtil.setColor(MainActivity.this, AppUtils.getColor(R.color.end_blue));
                mToolbar.setBackgroundColor(AppUtils.getColor(R.color.end_blue));
                StatusBarUtil.setDarkMode(MainActivity.this);
            }
        });
    }
}
