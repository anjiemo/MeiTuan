package com.example.meituan.base;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;

import com.example.meituan.db.DaoMaster;
import com.example.meituan.db.DaoSession;
import com.example.meituan.presenter.HomePresenter;


@SuppressLint("StaticFieldLeak")
public class BaseApplication extends Application {

    private static Handler mHandler = new Handler();
    private static Context sContext = null;
    private static DaoSession sDaoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = this;
        initGreenDao();
    }

    private void initGreenDao() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, "userInfo.db");
        SQLiteDatabase db = devOpenHelper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        sDaoSession = daoMaster.newSession();
    }

    public static DaoSession getDaoSession() {
        return sDaoSession;
    }

    public static Context getContext() {
        return sContext;
    }

    public static Handler getHandler() {
        return mHandler;
    }
}
