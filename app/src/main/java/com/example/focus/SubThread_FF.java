package com.example.focus;

import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static cn.bmob.v3.Bmob.getApplicationContext;

public class SubThread_FF implements Runnable{
    private  final String TAG = getClass().getSimpleName();
    private String email;

    SubThread_FF(String email){
        this.email = email;
    }

    @Override
    public void run(){

        String res = "";
        JsonObject object = null;
        StringBuffer buffer = new StringBuffer();
        try {
            URL url = new URL("https://pycloud.bmob.cn/129c9e5ac930fbc2/restPassword?email="+email);
            HttpURLConnection urlCon = (HttpURLConnection) url.openConnection();

            int response = urlCon.getResponseCode();

            System.out.println(urlCon.getResponseCode());
            if (200 == urlCon.getResponseCode()) {
                InputStream is = urlCon.getInputStream();
                InputStreamReader isr = new InputStreamReader(is, "utf-8");
                BufferedReader br = new BufferedReader(isr);
                String str = null;
                while ((str = br.readLine()) != null) {
                    buffer.append(str);
                }
                br.close();
                isr.close();
                is.close();
                res = buffer.toString();
                JsonParser parse = new JsonParser();
                object = (JsonObject) parse.parse(res);//服务器返回的字典

                final JsonObject MSGobj = object;
                String text=object.get("msg").getAsString();
//                if(text.equals("success")){
//                    Handler handler = new Handler(Looper.getMainLooper());
//                    handler.post(new Runnable() {
//                        @Override
//                        public void run() {
//                            Toast.makeText(getApplicationContext(),"请查看你的邮箱",Toast.LENGTH_SHORT).show();
//                        }
//                    });
//                }else{
//                    Toast.makeText(getApplicationContext(),"邮箱不存在",Toast.LENGTH_SHORT).show();
//                }
            } else {
                throw new Exception("连接失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
//    public class User{
//        @SerializedName("session")
//    }
}
