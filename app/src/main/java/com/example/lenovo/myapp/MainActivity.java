package com.example.lenovo.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //点击触发事件
                Toast.makeText(MainActivity.this, "点击事件！", Toast.LENGTH_SHORT).show();
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
    }

}
