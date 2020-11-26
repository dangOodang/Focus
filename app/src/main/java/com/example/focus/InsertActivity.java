package com.example.focus;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InsertActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);


        Button bt1 = (Button) findViewById(R.id.newRec);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                EditText et1 = (EditText) findViewById(R.id.editText1);
                com.example.focus.Person person = new com.example.focus.Person(et1.getText().toString(),0);
                insert(person);
                setResult(RESULT_OK, null);  //不回传intent可设为null
                finish();
            }
        });

        Button bt2 = (Button) findViewById(R.id.button_cancel1);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                finish();
            }
        });
    }


    public void insert(com.example.focus.Person person) {
        com.example.focus.DBHelper helper = new com.example.focus.DBHelper(getApplicationContext(), "test.db", null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        if (person.name != null && !person.name.isEmpty() ) {
            String sql = "INSERT INTO person VALUES (NULL, ?,?)";
            db.execSQL(sql, new Object[]{person.name, person.age});
            db.close();
            Toast.makeText(getApplicationContext(), "添加成功",
                    Toast.LENGTH_SHORT).show();

        }
        else {
            Toast.makeText(getApplicationContext(), "标签不能为空",
                    Toast.LENGTH_SHORT).show();
        }
    }

}
