package com.example.lenovo.myapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by lenovo on 2016/3/1.
 */
public class PhoneBookAdapter extends BaseAdapter {
    private Context mContext;

    private LayoutInflater mLayoutInflater;

    private String[] mNames ={
            "小明","小花"
    };

    public PhoneBookAdapter(Context context) {
        mContext = context;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // 有多少条数据
        return mNames.length;
    }

    @Override
    public Object getItem(int i) {
        // 返回某一个的对象
        return mNames[i];
    }

    @Override
    public long getItemId(int i) {

        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        // 返回一个视图
        view = mLayoutInflater.inflate(R.layout.item_phone_book_friend,null);
        TextView nameTextView = (TextView) view.findViewById(R.id.name_text_view);
        nameTextView.setText(mNames[i]);
        return view;
    }
}
