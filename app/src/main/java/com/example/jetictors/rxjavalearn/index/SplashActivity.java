package com.example.jetictors.rxjavalearn.index;

import android.content.Intent;
import android.os.Handler;

import com.example.jetictors.rxjavalearn.base.BaseActivity;
import com.example.jetictors.rxjavalearn.R;
import com.example.jetictors.rxjavalearn.home.activity.MainActivity;

/**
 * 描述：启动页
 * 时间：2017/10/11  13:16
 * 作者：Jetictors
 * 版本  1.0.1
 */
public class SplashActivity extends BaseActivity{

    @Override
    public int getLayoutId() {
        return R.layout.activity_index;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {
        new Handler().postDelayed(() -> {
            SplashActivity.this.startActivity(new Intent(SplashActivity.this, MainActivity.class));
            SplashActivity.this.finish();
        },1500);
    }
}
