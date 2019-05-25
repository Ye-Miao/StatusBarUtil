package com.leaf.statusbarutil;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.TextView;

import com.leaf.library.StatusBarUtil;


/**
 * @author：created by leaf on 2019-05-07
 * Github地址：https://github.com/Ye-Miao
 * Desc: 主界面
 */
public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;

    @SuppressLint("SetTextI18n")
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = findViewById(R.id.toolbar);

        StatusBarUtil.setColor(this, AppUtils.getColor(R.color.start_blue));

        Button btn = findViewById(R.id.btn);
        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);
        Button btn3 = findViewById(R.id.btn3);
        Button btn4 = findViewById(R.id.btn4);
        Button btn5 = findViewById(R.id.btn5);
        TextView mVersionText = findViewById(R.id.version_text);

        //TODO 设置状态栏颜色
        btn.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, ColorActivity.class)));

        //TODO 设置透明
        btn1.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, TransparentActivity.class)));

        //TODO 设置状态栏渐变
        btn2.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, GradientActivity.class)));

        //TODO 在fragment中使用
        btn3.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, InFragmentActivity.class)));

        //TODO 设置状态栏模式（亮光）仅在android6.0及以上有效
        btn4.setOnClickListener(v -> {
            StatusBarUtil.setColor(MainActivity.this, AppUtils.getColor(R.color.start_blue));
            mToolbar.setBackgroundColor(AppUtils.getColor(R.color.start_blue));
            StatusBarUtil.setLightMode(MainActivity.this);
        });

        //TODO 设置状态栏模式（暗色）仅在android6.0及以上有效
        btn5.setOnClickListener(v -> {
            StatusBarUtil.setColor(MainActivity.this, AppUtils.getColor(R.color.end_blue));
            mToolbar.setBackgroundColor(AppUtils.getColor(R.color.end_blue));
            StatusBarUtil.setDarkMode(MainActivity.this);
        });

        mVersionText.setText(
                "手机厂商：" + AppUtils.getDeviceBrand() + "\n" +
                        "手机型号：" + AppUtils.getSystemModel() + "\n" +
                        "Android系统版本号：" + AppUtils.getSystemVersion()
        );
    }
}
