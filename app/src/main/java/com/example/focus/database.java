package com.example.focus;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class database extends Activity {

    private static int DB_VERSION=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

//        Button bt1=(Button) findViewById(R.id.button1);
//        Button bt2=(Button) findViewById(R.id.button2);
//        Button bt3=(Button) findViewById(R.id.button3);
//        Button bt4=(Button) findViewById(R.id.button4);
        Button bt5=(Button) findViewById(R.id.button5);
//        Button bt6=(Button) findViewById(R.id.button6);
        TextView tv=(TextView)findViewById(R.id.textView1);



        View.OnClickListener listener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
//                    case R.id.button1:
//                        createdb();
//                        break;
//                    case R.id.button2:
//                        Person person=new Person();
//                        person.name="wustzz";
//                        person.age=39;
//                        insert(person);
//                        break;
//                    case R.id.button3:
//                        deleteById(1);
//                        break;
//
//                    case R.id.button4:
//                        Person person1=new Person();
//                        person1.name="wustzz";
//                        person1.age=39;
//                        updateById(1,person1);
//                        break;

                    case R.id.button5:
                        find();
                        break;

                }
            }
        };


//        bt1.setOnClickListener(listener);
//        bt2.setOnClickListener(listener);
//        bt3.setOnClickListener(listener);
//        bt4.setOnClickListener(listener);
        bt5.setOnClickListener(listener);
//        bt6.setOnClickListener(listener);


    }

//    public void createdb(){
//        DBHelper helper = new DBHelper(getApplicationContext(), "test.db", null,DB_VERSION);
//        //调用getWritableDatabase()或getReadableDatabase()才会真正创建或打开
//        SQLiteDatabase db=helper.getWritableDatabase();
//        db.close(); //操作完成后关闭数据库连接
//        Toast.makeText(getApplicationContext(), "数据库创建成功", Toast.LENGTH_SHORT).show();
//    }



    public void find(){
        DBHelper helper = new DBHelper(getApplicationContext(), "test.db", null,DB_VERSION);
        SQLiteDatabase db=helper.getWritableDatabase();
        Cursor cursor = db.rawQuery( "SELECT * FROM person where age>?", new String[]{"10"} );
        TextView tv=(TextView)findViewById(R.id.textView_list); //简单用TextView显示一下数据
//        tv.setText("查询到"+cursor.getCount()+"条记录(当前数据库版本号="+DB_VERSION+")");
//        while (cursor.moveToNext()) { //遍历结果集
//            int id = cursor.getInt(cursor.getColumnIndex("id") );
//            String name = cursor.getString(cursor.getColumnIndex("name") );
//            int age = cursor.getInt(cursor.getColumnIndex("age") );
//            tv.setText(tv.getText()+"\n"+"id="+id+",name="+name+",age="+age);
//        }
        cursor.close(); //关闭cursor
        db.close(); //关闭数据库连接


        Intent it = new Intent( database.this, ShowActivity.class );
        startActivity(it);

    }


}