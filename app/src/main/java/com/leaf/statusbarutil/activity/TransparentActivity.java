package com.leaf.statusbarutil.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.leaf.library.StatusBarUtil;
import com.leaf.statusbarutil.R;
import com.leaf.statusbarutil.utils.AppUtils;

/**
 * @author：created by leaf on 2019-05-07
 * Github地址：https://github.com/Ye-Miao
 * Desc:
 */
public class TransparentActivity extends AppCompatActivity {
    private boolean isChanged;

    @Override
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_transparent);

        StatusBarUtil.setTransparentForWindow(this);

        Button btn = findViewById(R.id.button1);
        RelativeLayout relativeLayout = findViewById(R.id.container);

        btn.setOnClickListener(v -> {
            isChanged = !isChanged;
            if (isChanged) {
                relativeLayout.setBackground(AppUtils.getDrawable(R.mipmap.photo6));
            } else {
                relativeLayout.setBackground(AppUtils.getDrawable(R.mipmap.photo5));
            }
        });

    }
}
