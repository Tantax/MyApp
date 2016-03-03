package com.example.lenovo.myapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2016/3/1.
 */
public class ListViewDemoActivity extends Activity {

    private ListView mPhoneBookListView;
    private List<UserInfo> mUserInfos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_demo);

        mPhoneBookListView = (ListView) findViewById(R.id.list_view);

        mUserInfos = new ArrayList<>();
        mUserInfos.add(new UserInfo("张三",22));
        mUserInfos.add(new UserInfo("李四",25));
        mUserInfos.add(new UserInfo("王五",28));
        mUserInfos.add(new UserInfo("赵六",12));
        mUserInfos.add(new UserInfo("刘七",32));
        mUserInfos.add(new UserInfo("黄八",21));
        mUserInfos.add(new UserInfo("赵九",14));
        mUserInfos.add(new UserInfo("李十",26));

        PhoneBookAdapter phoneBookAdapter = new PhoneBookAdapter(ListViewDemoActivity.this, mUserInfos);
        mPhoneBookListView.setAdapter(phoneBookAdapter);


        // 更新ListView里的数据
        phoneBookAdapter.notifyDataSetChanged();

        // 点击事件
        mPhoneBookListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListViewDemoActivity.this, mUserInfos.get(position).getmUserName()+"被点击了！",Toast.LENGTH_SHORT).show();
            }
        });

        // 长按事件
        mPhoneBookListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListViewDemoActivity.this, mUserInfos.get(position).getmUserName()+"被长按了！",Toast.LENGTH_LONG).show();
                return false;
            }
        });

    }
}