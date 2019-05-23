package com.leaf.statusbarutil;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;

import java.util.Random;

/**
 * @author：created by leaf on 2019/5/23
 * Github地址：https://github.com/Ye-Miao
 * Desc:
 */
public class ColorActivity extends AppCompatActivity {

    private int mColor;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_color);

        Toolbar mToolbar = findViewById(R.id.toolbar);
        Button mChangeColor = findViewById(R.id.change_color);

        StatusBarUtil.setColor(this, AppUtils.getColor(R.color.start_blue));

        mChangeColor.setOnClickListener(v -> {
            Random random = new Random();
            mColor = 0xff000000 | random.nextInt(0xffffff);
            mToolbar.setBackgroundColor(mColor);
            StatusBarUtil.setColor(ColorActivity.this, mColor);
        });
    }
}
