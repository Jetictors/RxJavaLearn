package com.example.jetictors.rxjavalearn.views.home;

import android.view.View;

import com.example.jetictors.rxjavalearn.R;
import com.example.jetictors.rxjavalearn.base.BaseFragment;

/**
 * 描述：RxJava页面
 * 时间：2017/10/19  17:26
 * 作者：Jetictors
 * 版本  1.0.1
 */
public class RxJavaFragment extends BaseFragment{

    private static RxJavaFragment sRxJavaFragment;

    public static RxJavaFragment getInstance(){
        if (null == sRxJavaFragment){
            synchronized (RxJavaFragment.class){
                if (null == sRxJavaFragment){
                    sRxJavaFragment = new RxJavaFragment();
                }
            }
        }

        return sRxJavaFragment;
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
