package com.example.mjie_.android_qizhonga.model;

import com.example.mjie_.android_qizhonga.api.MyServer;
import com.example.mjie_.android_qizhonga.bean.MBean;
import com.example.mjie_.android_qizhonga.callback.CallBack;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ImpMyModel implements MyModel {
    @Override
    public void getdata(final CallBack callBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyServer.url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        MyServer myServer = retrofit.create(MyServer.class);
        Observable<MBean> data = myServer.getData();
        data.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MBean mBean) {
                        if (mBean != null) {
                            callBack.onOK(mBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onNo(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
