package com.example.lenovo.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public static final int RESULT_CODE = 1234;
    private static final String TAG = MainActivity.class.getSimpleName();
    private Button mButton_first;
    private Button mButton_second;
    private Button mButton_three;
    private Button mButton_gridView;
    private Button mButton_testView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

//        handleIntentData();
    }

    private void initViews() {
        mButton_first = (Button) findViewById(R.id.button_first);
        mButton_second = (Button) findViewById(R.id.button_second);
        mButton_three = (Button) findViewById(R.id.button_three);
        mButton_gridView = (Button) findViewById(R.id.button_gridView);
        mButton_testView = (Button) findViewById(R.id.button_test_view);

        mButton_first.setOnClickListener(this);
        mButton_second.setOnClickListener(this);
        mButton_three.setOnClickListener(this);
        mButton_gridView.setOnClickListener(this);
        mButton_testView.setOnClickListener(this);
    }

    private void handleIntentData() {
        Intent intent = getIntent();
        if(intent != null){
            String title =  intent.getStringExtra(SplashActivity.TITLE);
            UserInfo userInfo = (UserInfo) intent.getSerializableExtra(SplashActivity.USER_INFO);
            setTitle("名字是：" + userInfo.getmUserName());
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_first:
                //点击触发事件
                Intent intent = new Intent();
                intent.putExtra(SplashActivity.TITLE,"这是主页送回给起始页的数据");
                setResult(RESULT_CODE,intent);
                finish();//关闭当前页面
                break;
            case R.id.button_second:
                startActivity(new Intent(MainActivity.this,SplashActivity.class));
                break;
            case R.id.button_three:
                startActivity(new Intent(MainActivity.this,ListViewDemoActivity.class));
                break;
            case R.id.button_gridView:
                startActivity(new Intent(MainActivity.this,GridViewDemoActivity.class));
                break;
            case R.id.button_test_view:
                startActivity(new Intent(MainActivity.this,TestViewButtonActivity.class));
            default:
                break;
        }
    }
}
