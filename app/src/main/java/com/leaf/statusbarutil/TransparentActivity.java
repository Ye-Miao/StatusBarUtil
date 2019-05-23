package com.leaf.statusbarutil;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.RelativeLayout;

/**
 * @author：created by leaf on 2019-05-07
 * Github地址：https://github.com/Ye-Miao
 * Desc:
 */
public class TransparentActivity extends AppCompatActivity {
    private boolean isChanged;
    private RelativeLayout relativeLayout;


    @Override
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_transparent);

        StatusBarUtil.setTransparentForWindow(this);

        Button btn = findViewById(R.id.button1);
        relativeLayout = findViewById(R.id.container);

        btn.setOnClickListener(v -> {
            isChanged = !isChanged;
            if (isChanged) {
                relativeLayout.setBackgroundDrawable(AppUtils.getDrawable(R.mipmap.photo6));
            } else {
                relativeLayout.setBackgroundDrawable(AppUtils.getDrawable(R.mipmap.photo5));
            }
        });

    }
}
