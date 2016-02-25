package com.example.lenovo.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int RESULT_CODE = 1234;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //点击触发事件
                Intent intent = new Intent();
                intent.putExtra(SplashActivity.TITLE,"主页送回的数据");
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

        Intent intent = getIntent();
        if(intent != null){
            String title =  intent.getStringExtra(SplashActivity.TITLE);
            UserInfo userInfo = (UserInfo) intent.getSerializableExtra(SplashActivity.USER_INFO);
            setTitle("名字是："+userInfo.getmUserName());

        }
    }

}
