package com.example.meituan;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.meituan.adapters.ItemRvMenuTypeAdapter;
import com.example.meituan.adapters.ItemRvShopAdapter;
import com.example.meituan.base.BaseApplication;
import com.example.meituan.beans.BusinessInformation;
import com.example.meituan.db.BusinessInformationDao;
import com.example.meituan.db.DaoSession;
import com.example.meituan.presenter.HomePresenter;
import com.example.meituan.ui.ShopListActivity;
import com.example.meituan.utils.Constants;
import com.example.meituan.utils.Utils;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DaoSession mDaoSession = BaseApplication.getDaoSession();
    RecyclerView rvMenu;
    RecyclerView rvShop;
    private ItemRvMenuTypeAdapter mMenuTypeAdapter;
    private ItemRvShopAdapter mShopAdapter;
    private HomePresenter mHomePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initListener();
    }

    private void initListener() {
        mMenuTypeAdapter.setOnItemClickListener(position -> {
            List<BusinessInformation> businessInformationList = mDaoSession.queryBuilder(BusinessInformation.class)
                    .where(BusinessInformationDao.Properties.Type.eq(position)).list();
            // 如果数据库中没有该类型的数据，则代表没有商家信息，反之则有
            if (Utils.isNotEmpty(businessInformationList)) {
                Intent intent = new Intent(this, ShopListActivity.class);
                intent.putExtra(Constants.TYPE, position);
                startActivity(intent);
                return;
            }
            Toast.makeText(this, "没有商家信息！", Toast.LENGTH_SHORT).show();
        });
    }

    private void initData() {
        HomePresenter.getHomePresenter().resetData();
        SharedPreferences sp = getSharedPreferences(Constants.SETTING, MODE_PRIVATE);
        String userId = sp.getString(Constants.USER_ID, null);
        if (TextUtils.isEmpty(userId)) {
            Toast.makeText(this, "您还未登陆，将以游客身份使用~", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "欢迎回来：" + userId + " ！", Toast.LENGTH_SHORT).show();
        }
        if (Utils.isNotEmpty(mHomePresenter)) {
            mMenuTypeAdapter.setObjects(mHomePresenter.getMenuTypes());
            mShopAdapter.setObjects(mHomePresenter.getBusinessInformationList());
        }
    }

    private void initView() {
        rvMenu = findViewById(R.id.rvMenu);
        rvShop = findViewById(R.id.rvShop);
        mHomePresenter = HomePresenter.getHomePresenter();
        mMenuTypeAdapter = new ItemRvMenuTypeAdapter(this);
        GridLayoutManager menuLayoutManager = new GridLayoutManager(this, 3);
        rvMenu.setLayoutManager(menuLayoutManager);
        rvMenu.setAdapter(mMenuTypeAdapter);
        mShopAdapter = new ItemRvShopAdapter(this);
        LinearLayoutManager shopLayoutManager = new LinearLayoutManager(this);
        rvShop.setLayoutManager(shopLayoutManager);
        rvShop.setAdapter(mShopAdapter);
    }
}