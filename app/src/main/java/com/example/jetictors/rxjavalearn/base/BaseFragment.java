package com.example.jetictors.rxjavalearn.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 描述：基类Fragment
 * 时间：2017/10/12  16:50
 * 作者：Jetictors
 * 版本  1.0.1
 */
public abstract class BaseFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = null;
        if (getLayoutId() != 0){
            view = inflater.inflate(getLayoutId(),null);
        }
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        initView(view);
        initData();
    }

    public abstract int getLayoutId();

    public abstract void initView(View view);

    public abstract void initData();
}
