package com.myemcu.app_17readapp_16;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences accessPreferences,loginPreferences;
    private Context appContext=null;
    private Button  myBtn;
    private int     mCnt;
    private String  mName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
                // 创建上下文
                appContext=createPackageContext("com.myemcu.app_16sharedpreferences",Context.CONTEXT_IGNORE_SECURITY);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        myBtn = (Button) findViewById(R.id.myBtn);
        myBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getApp16Shared();
            }
        });
    }

    private void getApp16Shared() {
        accessPreferences = appContext.getSharedPreferences("access", Context.MODE_WORLD_READABLE);
        mCnt = accessPreferences.getInt("count", 0);

        loginPreferences = appContext.getSharedPreferences("login", Context.MODE_WORLD_READABLE);
        mName = loginPreferences.getString("name", null);

        Toast.makeText(this,"您好，"+ mName +"，APP_16已经被使用了"+ mCnt +"次，真尼玛帅!", Toast.LENGTH_LONG).show();
    }
}
