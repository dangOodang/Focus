package com.example.focus;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class ShowActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);


        com.example.focus.DBHelper helper = new com.example.focus.DBHelper(getApplicationContext(), "test.db", null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT id as _id,name,age FROM person", null);

        String[] from = {"name", "age"};
        int[] to = {R.id.txtName, R.id.txtAge};
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.listview, cursor, from, to);
        //使用SimpleCursorAdapter填充ListView
        //cursor.close();不能close()，否则SimpleCursorAdapter将不能从Cursor中读取数据显示
        ListView li = (ListView) findViewById(R.id.listView1);
        li.setAdapter(adapter);
//        TextView tv = (TextView) findViewById(R.id.textView_rem);
//        tv.setText("查询到" + cursor.getCount() + "条记录");


        ListView list1 = (ListView) findViewById(R.id.listView1);
        registerForContextMenu(list1);  //将上下文菜单注册到ListView上


        Button bt1 = (Button) findViewById(R.id.button_add); //注意id值
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(com.example.focus.ShowActivity.this, InsertActivity.class);
                startActivityForResult(intent, 100);
            }
        });


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100)
            if (resultCode == RESULT_OK) {
                onCreate(null);
            } // 100表明是来自于InsertActivity的回传


        if (requestCode == 200)  //200表明是来自于InsertActivity的回传
            if (resultCode == RESULT_OK) {
                onCreate(null);   //ShowActivity重新执行onCreate，即完成刷新
            }

    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.setHeaderTitle("操作");
        getMenuInflater().inflate(R.menu.manage, menu);
    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {  //添加上下文菜单选中项方法
            switch (item.getItemId()) {
            case R.id.delete:
                delete(item); //代码见后
                return true;
            case R.id.update:
                update(item); //代码见后
                return true;
            default:
                return false;
        }
    }

    //删除：根据id值作为删除记录的条件
    public void delete(MenuItem item) {
        final AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        if (info.id > 0) {
            new AlertDialog.Builder(this).setTitle("删除" + info.id)
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            com.example.focus.DBHelper helper = new com.example.focus.DBHelper(getApplicationContext(), "test.db", null, 1);
                            SQLiteDatabase db = helper.getWritableDatabase();
                            db.execSQL("Delete from person where id = ? ", new Object[]{info.id});
                            db.close();
                            Toast.makeText(getApplicationContext(), "删除成功", Toast.LENGTH_SHORT).show();
                            onCreate(null); //重新加载一次Activity，刷新
                        }
                    })
                    .setNegativeButton("取消", null).show();
        }
    }

    public void update(MenuItem item) {
    // do it!
        final AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        Intent intent = new Intent(com.example.focus.ShowActivity.this, com.example.focus.Timercounter.class);
        Bundle bundle = new Bundle();
        bundle.putString("username", ((TextView) info.targetView.findViewById(R.id.txtName)).getText().toString());
        bundle.putInt("age", Integer.parseInt(((TextView) info.targetView.findViewById(R.id.txtAge)).getText().toString()) );
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
