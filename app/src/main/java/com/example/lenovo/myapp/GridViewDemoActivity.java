package com.example.lenovo.myapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2016/3/1.
 */
public class GridViewDemoActivity extends Activity {

    private GridView mPhoneBookGridView;
    private List<UserInfo> mUserInfos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridview_demo);

        mPhoneBookGridView = (GridView) findViewById(R.id.grid_View);

        mUserInfos = new ArrayList<>();
        mUserInfos.add(new UserInfo("张三",22));
        mUserInfos.add(new UserInfo("李四",25));
        mUserInfos.add(new UserInfo("王五",28));
        mUserInfos.add(new UserInfo("赵六",12));
        mUserInfos.add(new UserInfo("刘七",32));
        mUserInfos.add(new UserInfo("黄八",21));
        mUserInfos.add(new UserInfo("赵九",14));
        mUserInfos.add(new UserInfo("李十",26));

        final PhoneBookAdapter phoneBookAdapter = new PhoneBookAdapter(GridViewDemoActivity.this, mUserInfos);
        mPhoneBookGridView.setAdapter(phoneBookAdapter);

        // 点击事件
        mPhoneBookGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0) {
                    // 新建另外一批数据
                    mUserInfos.clear();
                    mUserInfos.add(new UserInfo("我是新数据一",1));
                    mUserInfos.add(new UserInfo("我是新数据二",2));
                    mUserInfos.add(new UserInfo("我是新数据三",3));
                    // 替换老的数据
                    phoneBookAdapter.resetData(mUserInfos);
                    // 刷新ListView，让它更新自己的视图
                    phoneBookAdapter.notifyDataSetChanged();
                }

                Toast.makeText(GridViewDemoActivity.this, mUserInfos.get(position).getmUserName()+"被点击了！",Toast.LENGTH_SHORT).show();
            }
        });

        // 长按事件
        mPhoneBookGridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(GridViewDemoActivity.this, mUserInfos.get(position).getmUserName()+"被长按了！",Toast.LENGTH_LONG).show();
                return false;
            }
        });

    }
}