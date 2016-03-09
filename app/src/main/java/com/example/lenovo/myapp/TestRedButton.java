package com.example.lenovo.myapp;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by lenovo on 2016/3/8.
 */
public class TestRedButton extends View implements View.OnClickListener {

    private Paint mPanit;
    private Rect mRect;
    private int mNumber = 20;

    //自定义属性
    private int mBackgroundColor;

    public TestRedButton(Context context) {
        this(context, null);
    }

    public TestRedButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TestRedButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        mPanit = new Paint();
        mRect = new Rect();

        this.setOnClickListener(this);

        //获取自定义属性的全部属性
        TypedArray typedArray = context.obtainStyledAttributes(attrs,R.styleable.TestRedButton);

        mBackgroundColor = typedArray.getColor(R.styleable.TestRedButton_backgroundColor, Color.RED);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 做一个圆形的红色按钮
        // 设置画布为红色
        /**
         * 画了红色的圆
         */
        mPanit.setColor(Color.RED);
        canvas.drawCircle(getWidth()/2, getHeight()/2, getWidth()/2, mPanit);

        // 中间有一个白色的数字
        mPanit.setColor(Color.WHITE);
        mPanit.setTextSize(200);

        /**
         * mRect是这个数字四周的边距
         */
        String text = String.valueOf(mNumber);
        mPanit.getTextBounds(text, 0, text.length(), mRect);

        int textWidth = mRect.width();
        int textHeight = mRect.height();

        canvas.drawText(text, getWidth()/2 - textWidth/2, getHeight()/2 + textWidth/2, mPanit);


    }

    @Override
    public void onClick(View v) {
        /**
         * 每点击一次减少1
         */
        if(mNumber>0){
            mNumber--;
        }else{
            mNumber = 20;
        }
        invalidate();//数据刷新
    }
}
