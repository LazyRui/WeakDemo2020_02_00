package com.bawei.day0222.utils;

import com.bawei.day0222.api.Api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * ProjectName: Day0222
 * PackageName: com.bawei.day0222.utils
 * ClassName:   RretrofitUtils
 * Description: Java类的作用
 * Author: Lazy
 * CreateDate: 2020/2/22_15:41
 */
public class RretrofitUtils {
    private static RretrofitUtils rretrofitUtils;
    private final Retrofit retrofit;

    public RretrofitUtils() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)).build();
        retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public static RretrofitUtils getInstance() {
        if (rretrofitUtils == null) {
            synchronized (RretrofitUtils.class) {
                if (rretrofitUtils == null) {
                    rretrofitUtils = new RretrofitUtils();
                }
            }
        }
        return rretrofitUtils;
    }


    public <T> T createService(Class<T> tClass) {
        return retrofit.create(tClass);
    }
}
