package com.example.jetictors.rxjavalearn.views.home;

import android.view.View;

import com.example.jetictors.rxjavalearn.R;
import com.example.jetictors.rxjavalearn.base.BaseFragment;

/**
 * 描述：RxPremissions页面
 * 时间：2017/10/19  17:26
 * 作者：Jetictors
 * 版本  1.0.1
 */
public class RxPremissionsFragment extends BaseFragment{

    private static RxPremissionsFragment sRxPremissionsFragment;

    public static RxPremissionsFragment getInstance(){
        if (null == sRxPremissionsFragment){
            synchronized (RxPremissionsFragment.class){
                if (null == sRxPremissionsFragment){
                    sRxPremissionsFragment = new RxPremissionsFragment();
                }
            }
        }

        return sRxPremissionsFragment;
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
