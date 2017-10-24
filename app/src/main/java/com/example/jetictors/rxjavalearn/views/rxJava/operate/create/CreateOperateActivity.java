package com.example.jetictors.rxjavalearn.views.rxJava.operate.create;

import android.util.Log;

import com.example.jetictors.rxjavalearn.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * 描述：创建操作符页
 * 时间：2017/10/11  13:26
 * 作者：Jetictors
 * 版本  1.0.1
 */
public class CreateOperateActivity extends BaseActivity{

    private final  String TAG = getClass().getSimpleName();

    @Override
    public int getLayoutId() {
        return 0;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    /**
     * 创建操作符之————create()
     */
    private void rxJavaTestCreate(){

        // 1. 分步骤式 创建
        stepCreate();

        // 2. 链式 创建
        linkCreate();

    }

    /**
     * 创建操作符之————just()
     */
    private void rxJavaTestJust(){

        /*
            1. just() 有10个重载方法，及最多支持10个参数,参数从t1 ... t2。
            2. 当just()方法的参数大于1个时，调用的是formArray操作符。有兴趣的可以看看源码。
            3. just会返回一个被观察者。
         */
        Observable.just("事件1","事件2","事件3")
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e(TAG,"onSubscribe()方法执行");
                    }

                    @Override
                    public void onNext(String value) {
                        Log.e(TAG,"onNext()方法执行");
                        Log.e(TAG,"value = " + value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG,"onError()方法执行");
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG,"onComplete()方法执行");
                    }
                });
    }

    /**
     * 创建操作符之————fromArray()
     */
    private void rxJavaTestFromArray(){
        String[] mItems = new String[]{"事件1","事件2","事件3"};

        /*
            1. 接受一个数组，或者可变长参数
            2. fromArray()会返回一个Observable对象(被观察者)。有兴趣的可以查看源码
         */

        // Observable.fromArray("事件1","事件2","事件3").subscribe(...);

        Observable.fromArray(mItems)
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e(TAG,"onSubscribe()方法执行");
                    }

                    @Override
                    public void onNext(String value) {
                        Log.e(TAG,"onNext()方法执行");
                        Log.e(TAG,"value = " + value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG,"onError()方法执行");
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG,"onComplete()方法执行");
                    }
                });
    }

    /**
     * 创建操作符之————fromIterable()
     */
    private void rxJavaTestFromIterable(){
        List<String> mStrList = new ArrayList<>();

        for(int i = 0 ; i < 3 ; i++){
           mStrList.add(i,"事件" + i);
        }

        /*
            1. 接受一个列表。
            2. fromIterable()会返回一个Observable对象(被观察者)。有兴趣的可以查看源码
         */
        Observable.fromIterable(mStrList)
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e(TAG,"onSubscribe()方法执行");
                    }

                    @Override
                    public void onNext(String value) {
                        Log.e(TAG,"onNext()方法执行");
                        Log.e(TAG,"value = " + value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG,"onError()方法执行");
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG,"onComplete()方法执行");
                    }
                });
    }

    /**
     * 链式创建
     * 使用create()操作符
     */
    private void linkCreate() {
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                // 发送事件
                emitter.onNext("事件1");
                emitter.onNext("事件2");
                emitter.onNext("事件3");
                emitter.onComplete();
                emitter.onError(new Throwable("测试error事件"));
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.e(TAG,"onSubscribe()方法执行");
            }

            @Override
            public void onNext(String value) {
                Log.e(TAG,"onNext()方法执行");
                Log.e(TAG,"value = " + value);
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG,"onError()方法执行");
            }

            @Override
            public void onComplete() {
                Log.e(TAG,"onComplete()方法执行");
            }
        });
    }

    /**
     * 分步骤式创建
     * 使用create()操作符
     * 此过程主要讲解创建一个被观察者和观察者以及他们之间订阅的过程
     */
    private void stepCreate() {
        // 1. 创建一个被观察者
        Observable<String> observableTest = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                // 发送事件
                emitter.onNext("事件1");
                emitter.onNext("事件2");
                emitter.onNext("事件3");
                emitter.onComplete();
                emitter.onError(new Throwable("测试error事件"));
            }
        });

        // 创建一个观察者
        Observer<String> observerTest = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.e(TAG,"onSubscribe()方法执行");
            }

            @Override
            public void onNext(String value) {
                Log.e(TAG,"onNext()方法执行");
                Log.e(TAG,"value = " + value);
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG,"onError()方法执行");
            }

            @Override
            public void onComplete() {
                Log.e(TAG,"onComplete()方法执行");
            }
        };

        // 订阅 （连接观察者与被观察者）
        observableTest.subscribe(observerTest);
    }

}
