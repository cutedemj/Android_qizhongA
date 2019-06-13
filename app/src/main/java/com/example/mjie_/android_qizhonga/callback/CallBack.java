package com.example.mjie_.android_qizhonga.callback;

import com.example.mjie_.android_qizhonga.bean.MBean;

public interface CallBack {
    void onOK(MBean mBean);

    void onNo(String error);
}
