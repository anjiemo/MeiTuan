package com.example.meituan.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Window;
import android.view.WindowManager;

import com.example.meituan.MainActivity;
import com.example.meituan.R;
import com.example.meituan.base.BaseApplication;
import com.example.meituan.presenter.HomePresenter;
import com.example.meituan.utils.Constants;

/**
 * 闪屏页
 */
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        SharedPreferences sp = getSharedPreferences(Constants.SETTING, MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putBoolean(Constants.IS_LOGIN, false);
        edit.putString(Constants.USER_ID, null);
        edit.putString(Constants.PASS_WORD, null);
        edit.apply();
        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Looper.prepare();
            startActivity(new Intent(this, MainActivity.class));
            finish();
            Looper.loop();
        }).start();
    }
}