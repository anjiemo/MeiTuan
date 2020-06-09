package com.example.meituan.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.meituan.MainActivity;
import com.example.meituan.R;
import com.example.meituan.base.BaseApplication;
import com.example.meituan.beans.UserInfo;
import com.example.meituan.db.DaoSession;
import com.example.meituan.db.UserInfoDao;
import com.example.meituan.utils.Constants;
import com.example.meituan.utils.Utils;
import com.google.gson.Gson;

import java.util.List;

/**
 * 登录界面
 */
public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "LoginActivity";
    private DaoSession mDaoSession = BaseApplication.getDaoSession();
    private EditText etId;
    private EditText etPassword;
    private Button btnLogin;
    private ImageView ivLeft;
    private TextView tvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        ivLeft = findViewById(R.id.ivLeft);
        ivLeft.setOnClickListener(v -> finish());
        tvTitle = findViewById(R.id.tvTitle);
        tvTitle.setText("登录");
        etId = findViewById(R.id.etId);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLogin:
                submit();
                break;
        }
    }

    private void submit() {
        // validate
        String etIdString = etId.getText().toString().trim();
        if (TextUtils.isEmpty(etIdString)) {
            Toast.makeText(this, "账号不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        String etPasswordString = etPassword.getText().toString().trim();
        if (TextUtils.isEmpty(etPasswordString)) {
            Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        Log.d(TAG, "submit: ===============UserId：" + etIdString);
        Log.d(TAG, "submit: ===============Password：" + etPasswordString);
        List<UserInfo> userInfoList = mDaoSession.queryBuilder(UserInfo.class)
                .where(UserInfoDao.Properties.UserId.eq(etIdString), UserInfoDao.Properties.Password.eq(etPasswordString)).list();
        Log.d(TAG, "submit: ==============" + new Gson().toJson(userInfoList));
        SharedPreferences sp = getSharedPreferences(Constants.SETTING, MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        //如果不为空则证明存在该用户
        if (Utils.isNotEmpty(userInfoList)) {
            edit.putBoolean(Constants.IS_LOGIN, true);
            edit.putString(Constants.USER_ID, etIdString);
            edit.putString(Constants.PASS_WORD, etPasswordString);
            finish();
        } else {
            edit.putBoolean(Constants.IS_LOGIN, false);
            // 去注册
            Toast.makeText(this, "账号或密码错误，请重试！", Toast.LENGTH_SHORT).show();
        }
        edit.apply();
    }
}