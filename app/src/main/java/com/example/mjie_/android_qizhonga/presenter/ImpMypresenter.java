package com.example.mjie_.android_qizhonga.presenter;

import com.example.mjie_.android_qizhonga.bean.MBean;
import com.example.mjie_.android_qizhonga.callback.CallBack;
import com.example.mjie_.android_qizhonga.model.ImpMyModel;
import com.example.mjie_.android_qizhonga.model.MyModel;
import com.example.mjie_.android_qizhonga.views.Myview;

import retrofit2.http.POST;

public class ImpMypresenter implements Mypresenter, CallBack {
    private ImpMyModel myModel;
    private Myview myview;

    public ImpMypresenter(ImpMyModel myModel, Myview myview) {
        this.myModel = myModel;
        this.myview = myview;
    }

    @Override
    public void getData() {
        if (myModel != null) {
            myModel.getdata(this);
        }
    }

    @Override
    public void onOK(MBean mBean) {
        if (myModel != null) {
            myview.onOK(mBean);
        }
    }

    @Override
    public void onNo(String error) {
        if (myModel != null) {
            myview.onNo(error);
        }
    }
}
