package com.example.jetictors.rxjavalearn.views.index;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Handler;
import android.util.Log;

import com.example.jetictors.rxjavalearn.base.BaseActivity;
import com.example.jetictors.rxjavalearn.R;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.observers.FutureObserver;
import io.reactivex.internal.operators.flowable.FlowableAll;
import io.reactivex.internal.operators.flowable.FlowableFromCallable;
import io.reactivex.internal.operators.flowable.FlowableFromPublisher;
import io.reactivex.internal.operators.observable.ObservablePublish;
import io.reactivex.schedulers.Schedulers;

/**
 * 描述：启动页
 * 时间：2017/10/11  13:16
 * 作者：Jetictors
 * 版本  1.0.1
 * @author Jetictors
 */
public class SplashActivity extends BaseActivity{

    private final String TAG = getClass().getSimpleName();

    @Override
    public int getLayoutId() {
        return R.layout.activity_index;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {
//        new Handler().postDelayed(() -> {
//            SplashActivity.this.startActivity(new Intent(SplashActivity.this, MainActivity.class));
//            SplashActivity.this.finish();
//        },1500);

//        rxJavaTestCreate();
//        rxJavaTestJust();
//        rxJavaTestFormArray();
//        rxJavaTestFormIterable();
//        rxJavaTestInterval();
//        rxJavaTestIntervalRange();
//        rxJavaTestMap();
        rxJavaTestFlatMap();

    }

    /**
     * 测试创建
     * create 最简单的最基本的创建操作符
     */
    private void rxJavaTestCreate(){
        Observable.create((ObservableOnSubscribe<Integer>) emitter -> {
            emitter.onNext(1);
            emitter.onNext(2);
            emitter.onNext(3);
            emitter.onComplete();
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.e(TAG,"onSubscribe");
            }

            @Override
            public void onNext(Integer value) {
                Log.e(TAG,"onNext");
                Log.e(TAG,"value = " + value);
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG,"onError");
            }

            @Override
            public void onComplete() {
                Log.e(TAG,"onComplete");
            }
        });
    }

    /**
     * 测试just操作符
     */
    private void rxJavaTestJust(){
        Observable.just(1,2,3)
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e(TAG,"onSubscribe");
                    }

                    @Override
                    public void onNext(Integer value) {
                        Log.e(TAG,"onNext");
                        Log.e(TAG,"value = " + value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG,"onError");
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG,"onComplete");
                    }
                });
    }

    private void rxJavaTestFormArray(){
        String[] numbers = new String[]{"1","2","3"};
        Observable.fromArray(numbers)
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e(TAG,"onSubscribe");
                    }

                    @Override
                    public void onNext(String value) {
                        Log.e(TAG,"onNext");
                        Log.e(TAG,"value = " + value);
                    }


                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG,"onError");
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG,"onComplete");
                    }
                });
    }

    private void rxJavaTestFormIterable(){
        List<String> mStrData = new ArrayList<>();
        mStrData.add("item 1");
        mStrData.add("item 2");
        mStrData.add("item 3");

        Observable.fromIterable(mStrData)
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e(TAG,"onSubscribe");
                    }

                    @Override
                    public void onNext(String value) {
                        Log.e(TAG,"onNext");
                        Log.e(TAG,"value = " + value);
                    }


                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG,"onError");
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG,"onComplete");
                    }
                });
    }

    private void rxJavaTestInterval(){
        Observable.interval(2, TimeUnit.SECONDS)
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e(TAG,"onSubscribe");
                    }

                    @Override
                    public void onNext(Long value) {
                        Log.e(TAG,"onNext");
                        Log.e(TAG,"value = " + value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG,"onError");
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG,"onComplete");
                    }

                });
    }

    private void rxJavaTestRange(){
        Observable.range(1,5)
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("rxJavaTestRange","运行了onSubscribe()方法");
                    }

                    @Override
                    public void onNext(Integer value) {
                        Log.e("rxJavaTestRange","运行了onNext()方法");
                        Log.e("rxJavaTestRange","value = " + value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("rxJavaTestRange","运行了onError()方法");
                    }

                    @Override
                    public void onComplete() {
                        Log.e("rxJavaTestRange","运行了onComplete()方法");
                    }
                });
    }

    private void rxJavaTextRangeLong(){
        Observable.rangeLong(1,4)
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Long value) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void rxJavaTestIntervalRange(){
        Observable.intervalRange(1,10,2,3,TimeUnit.SECONDS)
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        Log.e(TAG,"aLong = " + aLong);
                    }
                });

        Observable.intervalRange(1,10,1,3,TimeUnit.SECONDS,AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Long value) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

        Observable.just(1,2,3)
                .ambWith(new Observable<Integer>() {
                    @Override
                    protected void subscribeActual(Observer<? super Integer> observer) {
                        observer.onNext(4);
                        observer.onNext(5);
                        observer.onNext(6);
                    }
                })
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Integer value) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void rxJavaTestMap(){
        Observable.just(10,20,30)
                .map(integer -> {
                    // Integer 变换成String
                    return "我是变换操作符map()" + integer;
                })
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("rxJavaTestMap","运行了onSubscribe()方法");
                    }

                    @Override
                    public void onNext(String value) {
                        Log.e("rxJavaTestMap","运行了onNext()方法");
                        Log.e("rxJavaTestMap","value = " + value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("rxJavaTestMap","运行了onError()方法");
                    }

                    @Override
                    public void onComplete() {
                        Log.e("rxJavaTestMap","运行了onComplete()方法");
                    }
                });
    }
    
    private void rxJavaTestFlatMap(){
        Observable.just(1,2,3,4)
                .flatMap(new Function<Integer, ObservableSource<String>>() {
                    @Override
                    public ObservableSource<String> apply(Integer integer) throws Exception {
                        return Observable.just("5","6","7","8");
                    }
                })
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("rxJavaTestFlatMap","运行了onSubscribe()方法");
                    }

                    @Override
                    public void onNext(String value) {
                        Log.e("rxJavaTestFlatMap","运行了onNext()方法");
                        Log.e("rxJavaTestFlatMap","value = " + value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("rxJavaTestFlatMap","运行了onError()方法");
                    }

                    @Override
                    public void onComplete() {
                        Log.e("rxJavaTestFlatMap","运行了onComplete()方法");
                    }
                });
    }

}
