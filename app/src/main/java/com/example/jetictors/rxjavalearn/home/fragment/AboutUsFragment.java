package com.example.jetictors.rxjavalearn.home.fragment;

import android.view.View;

import com.example.jetictors.rxjavalearn.R;
import com.example.jetictors.rxjavalearn.base.BaseFragment;

/**
 * 描述：关于我 页面
 * 时间：2017/10/19  17:26
 * 作者：Jetictors
 * 版本  1.0.1
 */
public class AboutUsFragment extends BaseFragment{

    private static AboutUsFragment sAboutUsFragment;

    public static AboutUsFragment getInstance(){
        if (null == sAboutUsFragment){
            synchronized (AboutUsFragment.class){
                if (null == sAboutUsFragment){
                    sAboutUsFragment = new AboutUsFragment();
                }
            }
        }

        return sAboutUsFragment;
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
