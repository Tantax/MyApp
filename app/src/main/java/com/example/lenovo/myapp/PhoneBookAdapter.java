package com.example.lenovo.myapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2016/3/1.
 */
public class PhoneBookAdapter extends BaseAdapter {
    private Context mContext;

    private LayoutInflater mLayoutInflater;

    private List<UserInfo> mUserInfos = new ArrayList<>();

    public PhoneBookAdapter(Context context, List<UserInfo> userInfos) {
        mContext = context;
        mUserInfos = userInfos;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // 有多少条数据
        return mUserInfos.size();
    }

    @Override
    public Object getItem(int i) {
        // 返回某一个的对象
        return mUserInfos.get(i);
    }

    @Override
    public long getItemId(int i) {

        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        // 返回一个视图
        view = mLayoutInflater.inflate(R.layout.item_phone_book_friend,null);
        // 获取控件
        TextView nameTextView = (TextView) view.findViewById(R.id.name_text_view);
        TextView ageTextView = (TextView) view.findViewById(R.id.age_text_view);
        ImageView avatatimageView = (ImageView) view.findViewById(R.id.avatar_image_view);


        // 和数据之间进行绑定
        nameTextView.setText(mUserInfos.get(i).getmUserName());
        ageTextView.setText(String.valueOf(mUserInfos.get(i).getmAge()));
        avatatimageView.setImageResource(R.drawable.ic_launcher);

        return view;
    }
}
