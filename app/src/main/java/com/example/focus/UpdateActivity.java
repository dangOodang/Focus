package com.example.focus;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);


        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        String name=bundle.getString("username");
        int age = bundle.getInt("age");
//显示ShowActivity传来的id、name、age字段值
        com.example.focus.DBHelper helper = new com.example.focus.DBHelper(getApplicationContext(), "test.db", null,1);
        SQLiteDatabase db=helper.getWritableDatabase();
        //更新数据，id值不能修改
        db.execSQL("Update person set  age=? where name = ?", new Object[ ]{ age,name} );
        db.close();
        Toast.makeText(getApplicationContext(), "记录修改成功", Toast.LENGTH_SHORT).show();
        Intent intent1 = new Intent(UpdateActivity.this,ShowActivity.class);
        startActivity(intent1);
    }
}
