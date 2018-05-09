package com.tokentracker.api;


import android.support.v4.util.ArrayMap;

import com.tokentracker.bean.TokenBean;

import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.QueryMap;
import rx.Observable;


/**
 * Created by Riven
 * 服务器接口
 */
public interface ApiService {


    //添加银行卡
    @GET("/api")
    Observable<TokenBean> requestTokenAmount(
            @Header("Cache-Control") String cacheControl,
            @QueryMap ArrayMap<String, String> map
    );

}