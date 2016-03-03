package com.example.lenovo.myapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

/**
 * Created by lenovo on 2016/3/1.
 */
public class ListViewDemoActivity extends Activity {

    private ListView mPhoneBookListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_demo);

        mPhoneBookListView = (ListView) findViewById(R.id.list_view);

        PhoneBookAdapter phoneBookAdapter = new PhoneBookAdapter(ListViewDemoActivity.this);
        mPhoneBookListView.setAdapter(phoneBookAdapter);

    }
}