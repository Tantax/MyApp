package com.example.lenovo.myapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2016/3/1.
 */
public class GridViewAdapter extends BaseAdapter {
    private Context mContext;

    private LayoutInflater mLayoutInflater;

    private List<UserInfo> mUserInfos = new ArrayList<>();

    public GridViewAdapter(Context context, List<UserInfo> userInfos) {
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
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    /**
     * 每一行数据显示在界面上，用户能够看到
     *
     * @param i
     * @param view
     * @param viewGroup
     * @return
     */
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        // 返回一个视图
        ViewHolder viewHolder;
        if (view == null) {
            view = mLayoutInflater.inflate(R.layout.item_phone_book_friend, null);

            viewHolder = new ViewHolder();
            // 获取控件
            viewHolder.nameTextView = (TextView) view.findViewById(R.id.name_text_view);
            viewHolder.ageTextView = (TextView) view.findViewById(R.id.age_text_view);
            viewHolder.avatarImageView = (ImageView) view.findViewById(R.id.avatar_image_view);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }
        // 和数据之间进行绑定
        viewHolder.nameTextView.setText(mUserInfos.get(i).getmUserName());
        viewHolder.ageTextView.setText(String.valueOf(mUserInfos.get(i).getmAge()));
        viewHolder.avatarImageView.setImageResource(R.drawable.ic_launcher);
        return view;
    }

    class ViewHolder {
        TextView nameTextView;
        TextView ageTextView;
        ImageView avatarImageView;
    }

    /**
     * 重置数据
     *
     * @param userInfos
     */
    public void resetData(List<UserInfo> userInfos) {
        mUserInfos = userInfos;
    }
}
