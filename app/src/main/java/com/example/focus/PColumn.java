package com.example.focus;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.Collections;
import java.util.List;

public class PColumn extends View {
    private static Context context = null;
    private static AttributeSet attributeSet = null;
    /**
     * 自定义view实现柱状图
     * 首先定义一个类实现View
     */


    private Paint mLinePaint;
    private Paint mGreenPaint;
    private Paint mTextPaint;    //定义画笔

    private Context mContext;//定义上下文

    private float weight;
    private float height;
    private float mScale;//定义宽高

    Long maxtime  ;
    private String[] y_title;

    private static List<Person> mData;//分别为定义数据与数据源名称的集合

    public PColumn(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        com.example.focus.PColumn.context = context;
        attributeSet = attrs;
        //给定义的画笔进行加工
        mContext = context;
        mLinePaint = new Paint();
        mGreenPaint = new Paint();
        mTextPaint = new Paint();

        mLinePaint.setARGB(255, 223, 233, 231);
        mGreenPaint.setARGB(255, 0, 200, 149);
        mTextPaint.setARGB(255, 153, 153, 153);

        mGreenPaint.setStyle(Paint.Style.FILL);

        mTextPaint.setAntiAlias(true);
        mGreenPaint.setAntiAlias(true);
        mLinePaint.setAntiAlias(true);

        mScale = context.getResources().getDisplayMetrics().density;


    }

    //尺寸发生改变的时候调用
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        weight = 0.7F * w;
        height = 0.70F * h;
    }
    //绘制
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        maxtime =findmax();
        maxtime = maxtime- maxtime%5+5;
        String[] y = {maxtime+"", maxtime/5*4+"", maxtime/5*3+"", maxtime/5*2+"", maxtime/5*1+"", "0"};//这个数组是高度的值
        y_title = y;
        float min_height = height / 5;
        for (int i = 5; i >= 0; i--) {//画分割线
            if (i == 5) {
                mLinePaint.setARGB(255, 131, 148, 144);
            } else {
                mLinePaint.setARGB(255, 233, 233, 231);
            }
            canvas.drawLine(70 * mScale, 100*mScale + min_height * i, 70 * mScale + weight,  100*mScale + min_height * i, mLinePaint);
            mTextPaint.setTextAlign(Paint.Align.RIGHT);
            mTextPaint.setTextSize(15 * mScale);
            canvas.drawText(y_title[i], 60 * mScale, 100 * mScale + min_height * i, mTextPaint);//左边数字显示
        }
        mTextPaint.setTextAlign(Paint.Align.RIGHT);
        mTextPaint.setTextSize(15 * mScale);
        mTextPaint.setARGB(255, 60, 60, 60);
        canvas.drawText("时间/min", 60 * mScale, 130 * mScale - min_height , mTextPaint);
        mLinePaint.setARGB(255, 131, 148, 144);
        canvas.drawLine(70 * mScale, 130*mScale - min_height, 70 * mScale,  100*mScale + 5 *  min_height, mLinePaint);
        //显示y轴
        float min_weight = (weight) / (mData.size()+1);
        mTextPaint.setTextSize(12 * mScale);
        mTextPaint.setTextAlign(Paint.Align.CENTER);
        for (int i = 0; i < mData.size(); i++) {
            int leftR = (int) (70 * mScale + i * min_weight + min_weight / 2);
            int rightR = leftR + (int) (min_weight / 2);
            int buttomR = (int) (100 * mScale + 5*min_height );
            int topR = buttomR - (int) (height / maxtime * mData.get(i).age);//改变最大值
            canvas.drawRect(new RectF(leftR, topR, rightR, buttomR), mGreenPaint);//画图
            mTextPaint.setARGB(255, 153, 153, 153);
            canvas.drawText(mData.get(i).name, leftR + min_weight / 4, buttomR + 15 * mScale, mTextPaint);//下标显示
            mTextPaint.setARGB(255, 51, 51, 51);
            canvas.drawText(mData.get(i).age + "", leftR + min_weight / 4, topR - 10 * mScale, mTextPaint);//数据显示
        }
        //右标显示
        mTextPaint.setTextSize(15 * mScale);
        mTextPaint.setARGB(255, 60, 60, 60);
        canvas.drawText("标签", 70 * mScale +  weight, 100 * mScale + 5*min_height + 15 * mScale, mTextPaint);//下标显示
    }
    //传入数据并进行绘制
    public PColumn(List<Person> data) {
        super(com.example.focus.PColumn.context, com.example.focus.PColumn.attributeSet);
        mData = data;
        invalidate();
    }
    private long findmax(){
        long max = 0;
        for(int i = 0 ; i < mData.size();i++)
        {
            if(max < mData.get(i).age){
                max = mData.get(i).age;
            }
        }
        return max;
    }//寻找最大值
}
