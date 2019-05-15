package com.leaf.statusbarutil;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;


/**
 * @author：created by leaf on 2019-05-07
 * Github地址：https://github.com/Ye-Miao
 * Desc: 主界面
 */
public class MainActivity extends AppCompatActivity {

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        StatusBarUtil.setColor(this, AppUtils.getColor(R.color.colorAccent));
        Toolbar toolbar = findViewById(R.id.toolbar);
        StatusBarUtil.setGradientColor(this, toolbar);
        StatusBarUtil.setDarkMode(this);
        //设置状态栏颜色
        Button btn = findViewById(R.id.btn);
        //设置状态栏透明
        Button btn1 = findViewById(R.id.btn1);
        //设置状态栏渐变
        Button btn2 = findViewById(R.id.btn2);
        //在fragment中使用
        Button btn3 = findViewById(R.id.btn3);
        //设置状态栏模式（亮光 or 暗淡）
        Button btn4 = findViewById(R.id.btn4);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }
}
