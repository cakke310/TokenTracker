package com.tokentracker.base.rxjava;

import android.content.Context;

import com.tokentracker.Util.ACache;

import java.io.Serializable;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * des:处理服务器数据的缓存
 */
//################################使用例子#############################
/*
Observable<LoginData> fromNetwork = Api.getDefault()
        .login(phone, password)
        .compose(RxHelper.handleResult());

        RxCache.load(context,cacheKey,1000*60*30,fromNetwork,false)
        .subscribe(new RxSubscribe<LoginData>(context, "登录中...") {
    @Override
    protected void _onNext(LoginData data) {
            showToast(R.string.login_success);
            //TODO login success
            }

    @Override
    protected void _onError(String message) {
           showToast(message);
            }
    });
 */


public class RxCache {
    /**
     * @param context
     * @param cacheKey
     * @param expireTime
     * @param fromNetwork
     * @param forceRefresh
     * @param <T>
     * @return
     */
    public static <T> Observable<T> load(final Context context,
                                         final String cacheKey,
                                         final int expireTime,
                                         Observable<T> fromNetwork,
                                         boolean forceRefresh) {
        /**
         * 从缓存中取得
         */
        Observable<T> fromCache = Observable.create(new Observable.OnSubscribe<T>() {
            @Override
            public void call(Subscriber<? super T> subscriber) {
                //获取缓存
                T cache = (T) ACache.get(context).getAsObject(cacheKey);//有缓存
                if (cache != null) {
                    subscriber.onNext(cache);//就用缓存
                } else {
                    subscriber.onCompleted();
                }
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());


        /**
         * 从服务器请求中取得
         * 这里的fromNetwork 不需要指定Schedule,在handleRequest中已经变换了
         */
        fromNetwork = fromNetwork.map(new Func1<T, T>() {
            @Override
            public T call(T result) {
                //保存缓存
                ACache.get(context).put(cacheKey, (Serializable) result, expireTime);
                return result;
            }
        });

        //强制刷新则返回接口数据
        if (forceRefresh) {
            return fromNetwork;
        } else {
            //否则返回缓存
            return Observable.concat(fromCache, fromNetwork).first();
        }
    }
}
