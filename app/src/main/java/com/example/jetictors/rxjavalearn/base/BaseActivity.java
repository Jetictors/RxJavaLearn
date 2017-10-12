package com.example.jetictors.rxjavalearn.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * 描述：基类Activity
 * 时间：2017/10/12  16:20
 * 作者：Jetictors
 * 版本  1.0.1
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getLayoutId() != 0){
            setContentView(getLayoutId());
            initView();
            initData();
        }
    }

    protected <T extends View> T $(int resId) {
        return (T) super.findViewById(resId);
    }

    public abstract int getLayoutId();

    public abstract void initView();

    public abstract void initData();
}
