package com.example.focus;


/* 自定义PopupWindow  主要用来显示ListView
 * @author Ansen
 * @param <T>
 * @param <T>
 * @create time 2015-11-3
 */

import android.app.ActionBar;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class SpinerPopWindow<T> extends PopupWindow {
    private LayoutInflater inflater;
    private ListView mListView;
    private List<T> list;
    private MyAdapter  mAdapter;
    private int index = 0;



    public SpinerPopWindow(Context context, List<T> list, AdapterView.OnItemClickListener clickListener) {
        super(context);
        inflater=LayoutInflater.from(context);
        this.list=list;
        init(clickListener);
    }



    private void init(AdapterView.OnItemClickListener clickListener){
        View view = inflater.inflate(R.layout.spiner_window_layout, null);
        setContentView(view);
        setWidth(ActionBar.LayoutParams.WRAP_CONTENT);
        setHeight(ActionBar.LayoutParams.WRAP_CONTENT);
        setFocusable(true);
        ColorDrawable dw = new ColorDrawable(0x00);
        setBackgroundDrawable(dw);
        mListView = (ListView) view.findViewById(R.id.listview);
        //deleteView = (ListView) view.findViewById(R.id.listview1);
        mListView.setAdapter(mAdapter=new MyAdapter());
        // deleteView.setAdapter(mAdapter=new MyAdapter());
        mListView.setOnItemClickListener(clickListener);

    }

    private class MyAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder=null;
            if(convertView==null){
                holder=new ViewHolder();
                convertView=inflater.inflate(R.layout.list_item, null);
                holder.tvName = (TextView) convertView.findViewById(R.id.what_text);
                holder.button = (Button) convertView.findViewById(R.id.del_btn);
                convertView.setTag(holder);

            }else{
                holder=(ViewHolder) convertView.getTag();
            }
            holder.tvName.setText(getItem(position).toString());
            if(!(position == 0||position == list.size()-1)){
                holder.button.setTag(position);
                holder.button.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        tag_activity.delete(position, list);
                        dismiss();
                    }

                });
            }
            //holder.tv2.setText(getItem(position).toString());
            return convertView;
        }
    }

    private class ViewHolder{
        private TextView tvName;
        private Button button;
    }
}
