package com.example.jetictors.rxjavalearn.home.fragment;

import android.view.View;

import com.example.jetictors.rxjavalearn.R;
import com.example.jetictors.rxjavalearn.base.BaseFragment;

/**
 * 描述：ReactiveX页面
 * 时间：2017/10/11  13:26
 * 作者：Jetictors
 * 版本  1.0.1
 */
public class ReactiveXFragment extends BaseFragment{

    private static ReactiveXFragment sReactiveXFragment;

    public static ReactiveXFragment getInstance(){
        if (null == sReactiveXFragment){
            synchronized (ReactiveXFragment.class){
                if (null == sReactiveXFragment){
                    sReactiveXFragment = new ReactiveXFragment();
                }
            }
        }

        return sReactiveXFragment;
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
