package com.example.focus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class myhome extends AppCompatActivity {
    private Button mBtnbutton;
    private Button mBtnbutton1;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myhome);
        //mBtnbutton1=findViewById(R.id.button_set);
        mBtnbutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
          //      Intent intent=new Intent(myhome.this,set.class);
                //      startActivity(intent);
            }
        });
//        mBtnbutton = findViewById(R.id.up_B);
//        mBtnbutton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(myhome.this,updatepassword.class);
//                startActivity(intent);
//            }
//        });
    }
}
