package com.leaf.statusbarutil.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.leaf.library.StatusBarUtil;
import com.leaf.statusbarutil.fragment.FirstFragment;
import com.leaf.statusbarutil.fragment.FourthFragment;
import com.leaf.statusbarutil.R;
import com.leaf.statusbarutil.fragment.SecondFragment;
import com.leaf.statusbarutil.fragment.ThirdFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author：created by leaf on 2019-05-07
 * Github地址：https://github.com/Ye-Miao
 * Desc:
 */
public class InFragmentActivity extends AppCompatActivity {

    private int mCurrentPos = -1;
    private List<Fragment> mFragmentList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.use_in_fragment);

        StatusBarUtil.setTransparentForWindow(this);

        mFragmentList = Arrays.asList(
                FirstFragment.newInstance(),
                SecondFragment.newInstance(),
                ThirdFragment.newInstance(),
                FourthFragment.newInstance()
        );

        BottomNavigationView bottomMain = findViewById(R.id.bottom_main);
        bottomMain.setOnNavigationItemSelectedListener(menuItem -> {
            switch (menuItem.getItemId()) {
                case R.id.one:
                    switchFragmentIndex(0);
                    break;
                case R.id.two:
                    switchFragmentIndex(1);
                    break;
                case R.id.three:
                    switchFragmentIndex(2);
                    break;
                case R.id.four:
                    switchFragmentIndex(3);
                    break;
                default:
                    break;
            }
            return true;
        });
        switchFragmentIndex(0);
    }

    private void switchFragmentIndex(int position) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        if (mCurrentPos != -1) {
            fragmentTransaction.hide(mFragmentList.get(mCurrentPos));
        }
        if (!mFragmentList.get(position).isAdded()) {
            fragmentTransaction.add(R.id.fl_content, mFragmentList.get(position));
        }
        fragmentTransaction.show(mFragmentList.get(position)).commit();
        mCurrentPos = position;
    }


}
