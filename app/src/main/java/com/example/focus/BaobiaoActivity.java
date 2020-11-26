package com.example.focus;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BaobiaoActivity extends AppCompatActivity {

    private Button mBtnNext;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baobiao);
        mBtnNext=findViewById(R.id.btn_next);
        tv = findViewById(R.id.total_time);
        tv.setText(get_total_time()+"分钟");

        mBtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(com.example.focus.BaobiaoActivity.this,smalltag.class);
                startActivity(intent);
            }
        });
    }
    private int get_total_time(){
        int total_time = 0;
        com.example.focus.DBHelper helper = new com.example.focus.DBHelper(getApplicationContext(), "test.db", null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT id as _id,name,age FROM person", null);
        while (cursor.moveToNext()){
            total_time+=cursor.getInt(cursor.getColumnIndex("age"));
        }
        cursor.close();
        db.close();
        return total_time;
    }
}