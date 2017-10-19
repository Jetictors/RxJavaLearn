package com.example.jetictors.rxjavalearn.home.fragment;

import android.view.View;

import com.example.jetictors.rxjavalearn.R;
import com.example.jetictors.rxjavalearn.base.BaseFragment;

/**
 * 描述：RxBus页面
 * 时间：2017/10/19  17:26
 * 作者：Jetictors
 * 版本  1.0.1
 */
public class RxBusFragment extends BaseFragment{

    private static RxBusFragment sRxBusFragment;

    public static RxBusFragment getInstance(){
        if (null == sRxBusFragment){
            synchronized (RxBusFragment.class){
                if (null == sRxBusFragment){
                    sRxBusFragment = new RxBusFragment();
                }
            }
        }

        return sRxBusFragment;
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
