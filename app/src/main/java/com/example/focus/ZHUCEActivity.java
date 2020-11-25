package com.example.focus;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class ZHUCEActivity extends AppCompatActivity {
    private Button mBtnzc;
    private EditText email1,password1,user1;
    private String em,pa;
//    private Object ZHUCEActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_z_h_u_c_e);
        mBtnzc = findViewById(R.id.btn_login2);

        mBtnzc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email1=(EditText) findViewById(R.id.et_5);
                password1=(EditText) findViewById(R.id.et_4);
                user1=(EditText) findViewById(R.id.et_3);
//                AsyncCustomEndpoints ace = new AsyncCustomEndpoints();
//
//                JSONObject params = new JSONObject();

//                try {
//                    params.put("email", email1.getText().toString());
//                    params.put("password",password1.getText().toString());
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }

                new Thread(new SubThread_TT(email1.getText().toString(),password1.getText().toString(),user1.getText().toString())).start();//跳转到SubThread_TT子进程
            }
        });
    }

}
//public class  ZHUCEActivity2 extends AppCompatActivity{
//    private Button mBtnzc;
//    private EditText email1,password1;
//    private String em,pa;
//
//}