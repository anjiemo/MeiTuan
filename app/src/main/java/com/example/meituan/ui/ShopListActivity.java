package com.example.meituan.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.meituan.R;
import com.example.meituan.adapters.ItemRvShopAdapter;
import com.example.meituan.base.BaseApplication;
import com.example.meituan.beans.BusinessInformation;
import com.example.meituan.db.BusinessInformationDao;
import com.example.meituan.db.DaoSession;
import com.example.meituan.utils.Constants;

import java.util.List;

/**
 * 店铺列表
 */
public class ShopListActivity extends AppCompatActivity {

    private DaoSession mDaoSession = BaseApplication.getDaoSession();
    RecyclerView rvShop;
    private ItemRvShopAdapter mShopAdapter;
    private ImageView ivLeft;
    private TextView tvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_list);
        initView();
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        int type = intent.getIntExtra(Constants.TYPE, -1);
        // 从数据库中查询该类型的商家列表
        List<BusinessInformation> businessInformationList = mDaoSession.queryBuilder(BusinessInformation.class)
                .where(BusinessInformationDao.Properties.Type.eq(type)).list();
        mShopAdapter.setObjects(businessInformationList);
    }

    private void initView() {
        ivLeft = findViewById(R.id.ivLeft);
        ivLeft.setOnClickListener(v -> finish());
        tvTitle = findViewById(R.id.tvTitle);
        tvTitle.setText("商家列表");
        rvShop = findViewById(R.id.rvShop);
        mShopAdapter = new ItemRvShopAdapter(this);
        LinearLayoutManager shopLayoutManager = new LinearLayoutManager(this);
        rvShop.setLayoutManager(shopLayoutManager);
        rvShop.setAdapter(mShopAdapter);
    }
}