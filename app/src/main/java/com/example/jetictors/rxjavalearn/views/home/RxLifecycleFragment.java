package com.example.jetictors.rxjavalearn.views.home;

import android.view.View;

import com.example.jetictors.rxjavalearn.R;
import com.example.jetictors.rxjavalearn.base.BaseFragment;

/**
 * 描述：RxLifecycle页面
 * 时间：2017/10/19  17:26
 * 作者：Jetictors
 * 版本  1.0.1
 */
public class RxLifecycleFragment extends BaseFragment{

    private static RxLifecycleFragment sRxLifecycleFragment;

    public static RxLifecycleFragment getInstance(){
        if (null == sRxLifecycleFragment){
            synchronized (RxLifecycleFragment.class){
                if (null == sRxLifecycleFragment){
                    sRxLifecycleFragment = new RxLifecycleFragment();
                }
            }
        }

        return sRxLifecycleFragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_reactive;
    }

    @Override
    public void initView(View view) {

    }

    @Override
    public void initData() {

    }
}
