package com.example.jetictors.rxjavalearn.home.fragment;

import android.view.View;

import com.example.jetictors.rxjavalearn.R;
import com.example.jetictors.rxjavalearn.base.BaseFragment;

/**
 * 描述：项目介绍 页面
 * 时间：2017/10/19  17:26
 * 作者：Jetictors
 * 版本  1.0.1
 */
public class ProjectIllustrateFragment extends BaseFragment{

    private static ProjectIllustrateFragment sProjectIllustrateFragment;

    public static ProjectIllustrateFragment getInstance(){
        if (null == sProjectIllustrateFragment){
            synchronized (ProjectIllustrateFragment.class){
                if (null == sProjectIllustrateFragment){
                    sProjectIllustrateFragment = new ProjectIllustrateFragment();
                }
            }
        }

        return sProjectIllustrateFragment;
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
