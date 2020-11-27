package com.example.focus;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class timeendActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeend);
        int Timee=   getIntent().getIntExtra("time",0);
        int age = getIntent().getIntExtra("age",0);
        String User = getIntent().getStringExtra("name") ;
        TextView lblTitle=(TextView)findViewById(R.id.textView4);
        lblTitle.setText("本次计时持续"+Timee+"分钟");
        //update data
        Button button = (Button)findViewById(R.id.button2);
        button.setOnClickListener(v -> {
            com.example.focus.DBHelper helper = new com.example.focus.DBHelper(getApplicationContext(), "test.db", null,1);
            SQLiteDatabase db=helper.getWritableDatabase();
            //更新数据，id值不能修改

            db.execSQL("Update person set  age=? where name = ?", new Object[ ]{ Timee + age,User} );
            db.close();
            Toast.makeText(getApplicationContext(), "记录修改成功", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(timeendActivity.this,ShowActivity.class);
            startActivity(intent);
        });
    }

}