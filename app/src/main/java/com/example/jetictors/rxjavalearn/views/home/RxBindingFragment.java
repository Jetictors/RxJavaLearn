package com.example.jetictors.rxjavalearn.views.home;

import android.view.View;

import com.example.jetictors.rxjavalearn.R;
import com.example.jetictors.rxjavalearn.base.BaseFragment;

/**
 * 描述：RxBinding页面
 * 时间：2017/10/19  17:26
 * 作者：Jetictors
 * 版本  1.0.1
 */
public class RxBindingFragment extends BaseFragment{

    private static RxBindingFragment sRxBindingFragment;

    public static RxBindingFragment getInstance(){
        if (null == sRxBindingFragment){
            synchronized (RxBindingFragment.class){
                if (null == sRxBindingFragment){
                    sRxBindingFragment = new RxBindingFragment();
                }
            }
        }

        return sRxBindingFragment;
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
