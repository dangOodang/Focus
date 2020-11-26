package com.example.focus;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.List;

import static cn.bmob.v3.Bmob.getApplicationContext;

/**
 * Created by lenovo on 2018/4/28.
 */

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS person ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "name VARCHAR(20),"
                + "age SMALLINT)");

    }
    public static List<Person> getlist(List<Person> li){
        com.example.focus.DBHelper helper = new com.example.focus.DBHelper(getApplicationContext(), "test.db", null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT id as _id,name,age FROM person", null);
        while (cursor.moveToNext()){
            Person p = new Person(cursor.getString(cursor.getColumnIndex("name")),cursor.getInt(cursor.getColumnIndex("age")));
            li.add(p);
        }
        cursor.close();
        return li;
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS person"); //删除数据表，谨慎使用
        onCreate(db); //重新建表
    }

}