package com.example.mjie_.android_qizhonga;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

public class Main3Activity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 返回
     */
    private Button mToolNo;
    private Toolbar mMain3Tool;
    private Banner mMain3Banan;
    private TextView mMain3Tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initView();
    }

    private void initView() {
        mToolNo = (Button) findViewById(R.id.tool_no);
        mToolNo.setOnClickListener(this);
        mMain3Tool = (Toolbar) findViewById(R.id.main3_tool);
        mMain3Banan = (Banner) findViewById(R.id.main3_banan);
        mMain3Tool.setTitle("");
        setSupportActionBar(mMain3Tool);
        Intent intent = getIntent();
        ArrayList<String> url = intent.getStringArrayListExtra("url");
        mMain3Banan.setImages(url).setImageLoader(new ImgLod()).start();
        mMain3Tv = (TextView) findViewById(R.id.main3_tv);
        mMain3Tv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.tool_no:
                finish();
                break;
            case R.id.main3_tv:
                break;
        }
    }

    class ImgLod extends ImageLoader {

        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            String mpath = (String) path;

            Glide.with(Main3Activity.this).load(mpath).into(imageView);
        }
    }
}
