package com.example.lenovo.myapp;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;

/**
 * Created by lenovo on 2016/2/23.
 */
public class SplashActivity extends Activity {

    public static final String TITLE = "title";
    public static final String USER_INFO = "UserInfo";
    public static final int REQUEST_CODE = 9999;
    private static final String TAG = SplashActivity.class.getSimpleName();

    Handler mHandler = new Handler();


    private TextView mTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mTextView = (TextView) findViewById(R.id.title_text_view);
        final String title = mTextView.getText().toString();


        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                UserInfo userInfo = new UserInfo("小明",21);
                //跳转到MainActivity
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                intent.putExtra(TITLE,title);
                intent.putExtra(USER_INFO, userInfo);
                startActivityForResult(intent, REQUEST_CODE);
            }
        },2000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.i(TAG,"resultCode:" + resultCode + ",resultCode:" + resultCode);

        if(requestCode == REQUEST_CODE && resultCode == MainActivity.RESULT_CODE){
            if(data != null){
                String title = data.getStringExtra(TITLE);
                mTextView.setText(title);
            }
        }
    }
}
