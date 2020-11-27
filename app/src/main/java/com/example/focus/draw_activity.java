package com.example.focus;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class draw_activity extends AppCompatActivity {
    private static List<Person> mData = new ArrayList<>();;        //  数据值,  数据姓名


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pcolumn);


        //  柱形图
        initSQLiteTwo();

        PColumn pColumn = new PColumn(mData);    //  将数据源传递给自定义柱形图类
    }

    private void initSQLiteTwo() {
        //初始化数据
        mData.clear();
        com.example.focus.DBHelper helper = new com.example.focus.DBHelper(getApplicationContext(), "test.db", null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT id as _id,name,age FROM person", null);
        while (cursor.moveToNext()){
            Person p = new Person(cursor.getString(cursor.getColumnIndex("name")),cursor.getInt(cursor.getColumnIndex("age")));
            mData.add(p);
        }
        cursor.close();
        db.close();
    }
}