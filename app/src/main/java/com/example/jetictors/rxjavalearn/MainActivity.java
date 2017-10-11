package com.example.jetictors.rxjavalearn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class MainActivity extends AppCompatActivity {

    private TextView mTvValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTvValue = (TextView)findViewById(R.id.main_tv);

        findViewById(R.id.main_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                testObserver();
//                testObserver1();
            }
        });
    }

    /**
     * 链式使用
     */
    private void testObserver1() {
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                e.onNext("事件一");
                e.onNext("事件二");
                e.onNext("事件三");
                e.onComplete();
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onNext(String value) {
                String str = mTvValue.getText().toString().trim();
                mTvValue.setText(str + value);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    /**
     * 步骤式使用
     */
    private void testObserver(){

//        // 创建被观察者并发送事件
//        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
//            @Override
//            public void subscribe(ObservableEmitter<String> e) throws Exception {
//                e.onNext("事件一");
//                e.onNext("事件二");
//                e.onNext("事件三");
//                e.onComplete();
//            }
//        });

        Observable<String> observable1 = Observable.just("a","b","c");

        observable1.subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String value) {
                String str = mTvValue.getText().toString().trim();
                mTvValue.setText(str + value);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

//        //创建观察者
//        Observer<String> observer = new Observer<String>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//            }
//
//            @Override
//            public void onNext(String value) {
//                String str = mTvValue.getText().toString().trim();
//                mTvValue.setText(str + value);
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        };
//
//        // 订阅，及把观察者与被观察者关联起来
//        observable.subscribe(observer);
    }
}
