package com.example.mjie_.android_qizhonga;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /**
     * 欢迎来到北京积云教育
     */
    private TextView mTvSend;
    private int con = 3;

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                if (con > 0) {
                    con--;
                    handler.sendEmptyMessageDelayed(1, 1000);
                } else {
                    startActivity(new Intent(MainActivity.this, Main2Activity.class));
                }

            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mTvSend = (TextView) findViewById(R.id.tv_send);
        handler.sendEmptyMessageDelayed(1, 1000);
    }
}
