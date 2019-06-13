package com.example.mjie_.android_qizhonga;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.mjie_.android_qizhonga.adapter.RecycAdapter;
import com.example.mjie_.android_qizhonga.bean.MBean;
import com.example.mjie_.android_qizhonga.model.ImpMyModel;
import com.example.mjie_.android_qizhonga.presenter.ImpMypresenter;
import com.example.mjie_.android_qizhonga.views.Myview;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity implements Myview {

    private Toolbar mMain2Tool;
    private RecyclerView mMain2Recyc;
    private Banner mMain2Banan;
    private RecycAdapter adapter;
    private ArrayList<MBean.ResultBean> beans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
    }

    private void initView() {
        mMain2Tool = (Toolbar) findViewById(R.id.main2_tool);
        mMain2Recyc = (RecyclerView) findViewById(R.id.main2_recyc);
        mMain2Banan = (Banner) findViewById(R.id.main2_banan);

        mMain2Tool.setTitle("");
        setSupportActionBar(mMain2Tool);
        mMain2Recyc.setLayoutManager(new LinearLayoutManager(this));
        beans = new ArrayList<>();
        adapter = new RecycAdapter(this, beans);
        mMain2Recyc.setAdapter(adapter);
        ImpMypresenter mypresenter = new ImpMypresenter(new ImpMyModel(), this);
        mypresenter.getData();
    }

    @Override
    public void onOK(MBean mBean) {
        if (mBean != null) {
            List<MBean.ResultBean> result = mBean.getResult();
            mMain2Banan.setImages(result).setImageLoader(new ImgLod()).start();
            beans.addAll(result);
            adapter.notifyDataSetChanged();
            Log.e("TAG", "网路数据:" + result.size());
            adapter.setMyonc(new RecycAdapter.Myonc() {
                @Override
                public void myonc(int post) {
                    ArrayList<String> list = new ArrayList<>();
                    for (int i = 0; i < beans.size(); i++) {
                        list.add(beans.get(i).getHeader());
                    }
                    Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
                    intent.putStringArrayListExtra("url",list);
                    startActivity(intent);
                }
            });
        } else {
            Toast.makeText(this, "没有数据", Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public void onNo(String error) {
        Log.e("TAG", "onNo ::" + error);
    }

    class ImgLod extends ImageLoader {

        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            MBean.ResultBean mpath = (MBean.ResultBean) path;
            String images = mpath.getImages();
            Glide.with(Main2Activity.this).load(images).into(imageView);
        }
    }
}
