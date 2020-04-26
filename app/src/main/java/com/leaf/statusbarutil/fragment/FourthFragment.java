package com.leaf.statusbarutil.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leaf.statusbarutil.R;

import java.util.Objects;

/**
 * @author：created by apple on 2019-11-26
 * email: 15622113269@163.com
 * Desc:
 */
public class FourthFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fourth_fragment, container, false);
    }

    public static FourthFragment newInstance() {
        return new FourthFragment();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Toolbar toolbar = view.findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(v -> Objects.requireNonNull(getActivity()).finish());
    }
}
