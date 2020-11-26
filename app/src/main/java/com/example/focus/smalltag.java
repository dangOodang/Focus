package com.example.focus;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class smalltag extends AppCompatActivity {

    private LayoutInflater inflater;
    private ListView listView;



    private static List<Person> mlist ;

    public static  void getlist(List<Person> li){
        li = mlist;
    }
    public smalltag()
    {
        mlist = new ArrayList<>();
    }
    private void init() {
        com.example.focus.DBHelper helper = new com.example.focus.DBHelper(getApplicationContext(), "test.db", null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT id as _id,name,age FROM person", null);
        while (cursor.moveToNext()){
            Person p = new Person(cursor.getString(cursor.getColumnIndex("name")),cursor.getInt(cursor.getColumnIndex("age")));
            mlist.add(p);
        }
        cursor.close();
        db.close();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.smallltag);
        init();

        tagtimeadapter adapter = new tagtimeadapter(com.example.focus.smalltag.this,R.layout.tagtime);
        ListView listView = findViewById(R.id.listview);
        listView.setAdapter(adapter);

        Button btn = findViewById(R.id.to_draw);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳到下一个界面
                Intent intent = new Intent(com.example.focus.smalltag.this,draw_activity.class);
                startActivity(intent);
                Toast.makeText(com.example.focus.smalltag.this,"跳转了吗", Toast.LENGTH_SHORT).show();
            }
        });
    }



    public class tagtimeadapter extends ArrayAdapter
    {
        public tagtimeadapter(@NonNull Context context, int resource) {
            super(context, resource);
        }
        @Override
        public int getCount() {
            return 1;
        }

        @Override
        public Person getItem(int position) {
            return mlist.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            ViewHolder holder=null;
            if(convertView==null){
                holder=new ViewHolder();
                inflater=LayoutInflater.from(com.example.focus.smalltag.this);
                convertView = inflater.inflate(R.layout.tagtime, null);
                holder.tv1 = (TextView) convertView.findViewById(R.id.textleft);
                holder.tv2 = (TextView) convertView.findViewById(R.id.textright);
                convertView.setTag(holder);

            }else{
                holder=(ViewHolder) convertView.getTag();
            }
            holder.tv1.setText(getItem(position).name.toString());
            holder.tv2.setText(""+getItem(position).age+"");
            return convertView;

        }

    private class ViewHolder{
        private TextView tv1;
        private TextView tv2;
    }
        }
    }
