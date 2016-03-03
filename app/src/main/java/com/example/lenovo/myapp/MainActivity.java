package com.example.lenovo.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static final int RESULT_CODE = 1234;
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG,"onCreate");
        findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //点击触发事件
                Intent intent = new Intent();
                intent.putExtra(SplashActivity.TITLE,"这是主页送回给起始页的数据");
                setResult(RESULT_CODE,intent);
                finish();//关闭当前页面
            }
        });
        findViewById(R.id.button_second).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //点击触发事件
                Intent intent = new Intent(MainActivity.this,SplashActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.button_three).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ListViewDemoActivity.class);
                startActivity(intent);
            }
        });

        Intent intent = getIntent();
        if(intent != null){
            String title =  intent.getStringExtra(SplashActivity.TITLE);
            UserInfo userInfo = (UserInfo) intent.getSerializableExtra(SplashActivity.USER_INFO);
            setTitle("名字是：" + userInfo.getmUserName());
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"onStart:");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG,"onResume:");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,"onPause:");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,"onStop:");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"onDestroy:");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG,"onRestart:");
    }
}
