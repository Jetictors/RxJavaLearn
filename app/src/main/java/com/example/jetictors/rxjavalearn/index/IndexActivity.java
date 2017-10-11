package com.example.jetictors.rxjavalearn.index;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.jetictors.rxjavalearn.home.MainActivity;
import com.example.jetictors.rxjavalearn.R;

/**
 * 描述：启动页
 * 时间：2017/10/11  13:16
 * 作者：Jetictors
 * 版本  1.0.1
 */
public class IndexActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                IndexActivity.this.startActivity(new Intent(IndexActivity.this, MainActivity.class));
                IndexActivity.this.finish();
            }
        },1500);
    }
}
