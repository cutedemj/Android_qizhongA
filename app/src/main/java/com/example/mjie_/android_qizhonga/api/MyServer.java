package com.example.mjie_.android_qizhonga.api;

import com.example.mjie_.android_qizhonga.bean.MBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface MyServer {
    String url = "https://api.apiopen.top/";

    @GET("getJoke")
    Observable<MBean> getData();
}
