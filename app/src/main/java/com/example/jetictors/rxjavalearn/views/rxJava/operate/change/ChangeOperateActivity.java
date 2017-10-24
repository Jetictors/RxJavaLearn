package com.example.jetictors.rxjavalearn.views.rxJava.operate.change;

import android.util.Log;

import com.example.jetictors.rxjavalearn.base.BaseActivity;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.observables.GroupedObservable;

/**
 * 描述：变换操作符页
 * 时间：2017/10/11  13:26
 * 作者：Jetictors
 * 版本  1.0.1
 */
public class ChangeOperateActivity extends BaseActivity{

    private final String TAG = getClass().getSimpleName();

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
     * 变换操作符之————map()
     */
    private void rxJavaTestMap(){

        /*
            1.
         */
        Observable.fromArray(1,2,3)
                .map(new Function<Integer, String>() {
                    @Override
                    public String apply(Integer integer) throws Exception {
                        return "变换操作符map() : Integer 转换为 String => " + integer;
                    }
                })
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
     * 变换操作符之————flatMap()
     */
    private void rxJavaTestFlatMap(){
        Observable.fromArray(1,2,3)
                .flatMap(new Function<Integer, ObservableSource<String>>() {
                    @Override
                    public ObservableSource<String> apply(Integer integer) throws Exception {
                        switch (integer){
                            case 1:
                                return new Observable<String>() {
                                    @Override
                                    protected void subscribeActual(Observer<? super String> observer) {
                                        observer.onNext("1 -> 变换操作符flatMap() 事件1");
                                        observer.onNext("1 -> 变换操作符flatMap() 事件2");
                                        observer.onNext("1 -> 变换操作符flatMap() 事件3");
                                        observer.onComplete();
                                    }
                                };
                            case 2:
                                return new Observable<String>() {
                                    @Override
                                    protected void subscribeActual(Observer<? super String> observer) {
                                        observer.onNext("2 -> 变换操作符flatMap() 事件1");
                                        observer.onNext("2 -> 变换操作符flatMap() 事件2");
                                        observer.onNext("2 -> 变换操作符flatMap() 事件3");
                                        observer.onComplete();
                                    }
                                };
                            case 3:
                                return new Observable<String>() {
                                    @Override
                                    protected void subscribeActual(Observer<? super String> observer) {
                                        observer.onNext("3 -> 变换操作符flatMap() 事件1");
                                        observer.onNext("3 -> 变换操作符flatMap() 事件2");
                                        observer.onNext("3 -> 变换操作符flatMap() 事件3");
                                        observer.onComplete();
                                    }
                                };
                            default:
                               return new Observable<String>() {
                                   @Override
                                   protected void subscribeActual(Observer<? super String> observer) {
                                        observer.onError(new Throwable("不存在的事件"));
                                   }
                               };
                        }
                    }
                })
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
     * 变换操作符之————concatMap()
     */
    private void rxjavaTestConcatMap(){

        /*
            1.
         */
        Observable.fromArray(1,2,3)
                .concatMap(new Function<Integer, ObservableSource<String>>() {
                    @Override
                    public ObservableSource<String> apply(Integer integer) throws Exception {
                        switch (integer) {
                            case 1:
                                return new Observable<String>() {
                                    @Override
                                    protected void subscribeActual(Observer<? super String> observer) {
                                        observer.onNext("1 -> 变换操作符concatMap() 事件1");
                                        observer.onNext("1 -> 变换操作符concatMap() 事件2");
                                        observer.onNext("1 -> 变换操作符concatMap() 事件3");
                                        observer.onComplete();
                                    }
                                };
                            case 2:
                                return new Observable<String>() {
                                    @Override
                                    protected void subscribeActual(Observer<? super String> observer) {
                                        observer.onNext("2 -> 变换操作符concatMap() 事件1");
                                        observer.onNext("2 -> 变换操作符concatMap() 事件2");
                                        observer.onNext("2 -> 变换操作符concatMap() 事件3");
                                        observer.onComplete();
                                    }
                                };
                            case 3:
                                return new Observable<String>() {
                                    @Override
                                    protected void subscribeActual(Observer<? super String> observer) {
                                        observer.onNext("3 -> 变换操作符concatMap() 事件1");
                                        observer.onNext("3 -> 变换操作符concatMap() 事件2");
                                        observer.onNext("3 -> 变换操作符concatMap() 事件3");
                                        observer.onComplete();
                                    }
                                };
                            default:
                                return new Observable<String>() {
                                    @Override
                                    protected void subscribeActual(Observer<? super String> observer) {
                                        observer.onError(new Throwable("不存在的事件"));
                                    }
                                };
                        }
                    }
                })
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

    private void rxJavaTestScan(){
        Observable.fromArray(1,2,3)
                .scan(new BiFunction<Integer, Integer, Integer>() {
                    @Override
                    public Integer apply(Integer integer, Integer integer2) throws Exception {
                        return integer + integer2;
                    }
                })
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e(TAG,"onSubscribe()方法执行");
                    }

                    @Override
                    public void onNext(Integer value) {
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
     * 变换操作符之————buffer()
     */
    private void rxJavaTestBuffer(){
        Observable.fromArray(1,2,3,4,5,6)
                .buffer(2, TimeUnit.SECONDS)
                .subscribe(new Observer<List<Integer>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e(TAG,"onSubscribe()方法执行");
                    }

                    @Override
                    public void onNext(List<Integer> list) {
                        Log.e(TAG,"onNext()方法执行");
                        for (Integer value : list){
                            Log.e(TAG,"value = " + value);
                        }
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
     * 变换操作符之————groupBy()
     */
    private void rxJavaTestGroupBy(){
        Observable.fromArray(1,2,3,4,5,6,7,8)
                .groupBy(new Function<Integer, String>() {
                    @Override
                    public String apply(Integer integer) throws Exception {
                        return "比那还操作符之groupBy()  " + integer;
                    }
                })
                .subscribe(new Observer<GroupedObservable<String, Integer>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e(TAG,"onSubscribe()方法执行");
                    }

                    @Override
                    public void onNext(GroupedObservable<String, Integer> value) {
                        Log.e(TAG,"onNext()方法执行");

                        Log.e(TAG,"value.key => " + value.getKey());
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

}
