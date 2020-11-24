package com.example.focus;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
/**
 * 主Activity  用来实现popupwindow
 * @author ansen
 */
public class tag_activity extends Activity {
    public static int flag = 0;
    //private static int flag;//是否删除
    private List<SpinerPopWindow<String>> mSpinerPopWindow;
    private List<String> list_work;
    private List<String> list_study;
    private List<String> list_sport;
    private List<String> list_other;
    private List<String> list = new ArrayList<String>();
    private TextView tvValue;


    int j;
    int place;

    //   private Button button = findViewById(R.id.btn);
    //   private EditText edtext =findViewById(R.id.edit_text);
    PopupWindow popupWindow;

    public static <T> void delete(int index,List<T> list1) {

        list1.remove(index);
        flag = 1;
    }





    private  void init_popw(View v1){
        popupWindow=new PopupWindow( v1, ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT);
        popupWindow.setFocusable(true);
        ColorDrawable dw = new ColorDrawable(0x00);
        popupWindow.setBackgroundDrawable(dw);
        popupWindow.setOutsideTouchable(true);
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spiner);
        initData_list();
        initSpiner();
        for(j=0;j<4;j++) {
            switch (j + 1) {
                case 1:
                    tvValue = (TextView) findViewById(R.id.tv_value1);
                    list= list_work;
                    break;
                case 2:
                    tvValue = (TextView) findViewById(R.id.tv_value2);
                    list = list_study ;
                    break;
                case 3:
                    tvValue = (TextView) findViewById(R.id.tv_value3);
                    list = list_sport ;
                    break;
                case 4:
                    tvValue = (TextView) findViewById(R.id.tv_value4);
                    list = list_other ;
                    break;
            }

            tvValue.setOnClickListener(clickListener);//显示下拉框
            mSpinerPopWindow.get(place).setOnDismissListener(dismissListener);
            setTextImage(R.drawable.up);
        }
    }

    /**
     * 监听popupwindow取消
     */
    private PopupWindow.OnDismissListener dismissListener=new PopupWindow.OnDismissListener() {
        @Override
        public void onDismiss() {
            setTextImage(R.drawable.up);
        }
    };

    /**
     * popupwindow显示的ListView的item点击事件
     */

    private AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            switch (place) {
                case 0:
                    list = list_work;
                    break;
                case 1:
                    list = list_study;
                    break;
                case 2:
                    list = list_sport;
                    break;
                case 3:
                    list = list_other;
                    break;
            }

            if (position == list.size() - 1) {
                LayoutInflater inflater = LayoutInflater.from(tag_activity.this);
                View myview = inflater.inflate(R.layout.new_window, null);//引用自定义布局
                init_popw(myview);
                popupWindow.showAtLocation(inflater.inflate(R.layout.activity_spiner, null), Gravity.CENTER,0,200 );
                myview.findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {//获取布局里面按钮
                    @Override
                    public void onClick(View v) {
                        EditText editText = myview.findViewById(R.id.edit_text);
                        if (TextUtils.isEmpty(editText.getText())) {
                            Toast.makeText(tag_activity.this, "输入为空！", Toast.LENGTH_SHORT).show();

                        } else {
                            String st = editText.getText().toString();
                            String st1 = list.get(list.size() - 1);
                            list.remove( list.size() - 1);
                            list.add(st);
                            list.add(st1);
                            popupWindow.dismiss();
                            mSpinerPopWindow.get(place).dismiss();
                            switch (place){
                                case 0:
                                    tvValue = (TextView) findViewById(R.id.tv_value1);
                                    setTextImage(R.drawable.up);
                                    break;
                                case 1:
                                    tvValue = (TextView) findViewById(R.id.tv_value2);
                                    setTextImage(R.drawable.up);
                                    break;
                                case 2:
                                    tvValue = (TextView) findViewById(R.id.tv_value3);
                                    setTextImage(R.drawable.up);
                                    break;
                                case 3:
                                    tvValue = (TextView) findViewById(R.id.tv_value4);
                                    setTextImage(R.drawable.up);
                                    break;
                            }
                            mSpinerPopWindow.get(place).setWidth(tvValue.getWidth());
                            mSpinerPopWindow.get(place).showAsDropDown(tvValue);
                            tvValue.setText(list.get(position));
                        }
                    }
                });
            }

              /* meditwindow.button.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String string = meditwindow.editText.getText().toString();
                        list.add(string);
                    }
                });

              //  String st = edtext.getText().toString();
               // list.add(st);
*/
            else {
                tvValue.setText(list.get(position));
                Toast.makeText(tag_activity.this, "点击了:" + list.get(position),Toast.LENGTH_LONG).show();
                mSpinerPopWindow.get(place).dismiss();
            }
        }
    };


    /**
     * 显示PopupWindow
     */
    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.tv_value1:
                    tvValue = (TextView) findViewById(R.id.tv_value1);
                    place=0;
                    setTextImage(R.drawable.up);
                    break;
                case R.id.tv_value2:
                    tvValue = (TextView) findViewById(R.id.tv_value2);
                    place=1;
                    setTextImage(R.drawable.up);
                    break;
                case R.id.tv_value3:
                    tvValue = (TextView) findViewById(R.id.tv_value3);
                    place=2;
                    setTextImage(R.drawable.up);

                    break;
                case R.id.tv_value4:
                    tvValue = (TextView) findViewById(R.id.tv_value4);
                    setTextImage(R.drawable.up);
                    place=3;
                    break;
            }
            mSpinerPopWindow.get(place).setWidth(tvValue.getWidth());
            mSpinerPopWindow.get(place).showAsDropDown(tvValue);
        }
    };

    /**
     * 初始化数据
     */
    private void initSpiner(){
        mSpinerPopWindow = new ArrayList<>();
        mSpinerPopWindow.add(new SpinerPopWindow<String>(this, list_work, itemClickListener));
        mSpinerPopWindow.add(new SpinerPopWindow<String>(this, list_study, itemClickListener));
        mSpinerPopWindow.add(new SpinerPopWindow<String>(this, list_sport, itemClickListener));
        mSpinerPopWindow.add(new SpinerPopWindow<String>(this, list_other, itemClickListener));
    }

    private void initData_list() {
        list_work = new ArrayList<String>();
        list_study = new ArrayList<String>();
        list_sport = new ArrayList<String>();
        list_other = new ArrayList<String>();
        list_work.add("工作");
        list_work.add("新建子类");
        list_study.add("学习");
        list_study.add("新建子类");
        list_sport.add("运动");
        list_sport.add("新建子类");
        list_other.add("其他");
        list_other.add("新建子类");
    }
    /**
     * 给TextView右边设置图片
     * @param resId
     */

    private void setTextImage(int resId) {
        Drawable drawable = getResources().getDrawable(resId);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(),drawable.getMinimumHeight());// 必须设置图片大小，否则不显示
        tvValue.setCompoundDrawables(null, null, drawable, null);
    }
    /*public boolean isEmpty() {
        if (TextUtils.isEmpty(edtext.getText())) {
            Toast.makeText(MainActivity.this, "输入为空", Toast.LENGTH_SHORT).show();
            return  true;
        }
        return false;
    }*/

}

