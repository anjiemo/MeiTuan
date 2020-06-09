package com.example.meituan.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.meituan.R;
import com.example.meituan.adapters.ItemRvDishAdapter;
import com.example.meituan.base.BaseApplication;
import com.example.meituan.beans.BusinessInformation;
import com.example.meituan.beans.DishInfo;
import com.example.meituan.db.BusinessInformationDao;
import com.example.meituan.db.DaoSession;
import com.example.meituan.presenter.HomePresenter;
import com.example.meituan.utils.Constants;
import com.example.meituan.utils.Utils;

import java.util.List;

import static android.media.CamcorderProfile.get;

/**
 * 店铺详情
 */
public class ShopDetailActivity extends AppCompatActivity {

    private DaoSession mDaoSession = BaseApplication.getDaoSession();
    private ImageView ivLeft;
    private TextView tvTitle;
    private TextView tvAddress;
    private TextView tvPhone;
    private TextView tvSellNum;
    private TextView tvStartPrice;
    private TextView tvDeliveryFee;
    private RecyclerView rvDishList;
    private ItemRvDishAdapter mRvDishAdapter;
    private HomePresenter mHomePresenter;
    private List<DishInfo> mDishInfoList;
    private TextView tvCount;
    private RelativeLayout rlContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_detail);
        initView();
        initData();
        initListener();
    }

    private void initListener() {
        mRvDishAdapter.setOnItemClickListener(position -> {
            if (mHomePresenter != null) {
                List<DishInfo> dishInfoList = mHomePresenter.getDishInfoList();
                DishInfo dishInfo = dishInfoList.get(position);
                dishInfo.setOrderNum(dishInfo.getOrderNum() + 1);
                startActivityForResult(new Intent(this, OrderListActivity.class), 1);
            }
        });
        rlContainer.setOnClickListener(v -> startActivityForResult(new Intent(this, OrderListActivity.class), 1));
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (Utils.isNotEmpty(mHomePresenter)) {
            int dishCount = mHomePresenter.getDishCount();
            tvCount.setText(String.valueOf(dishCount));
        }
    }

    private void initData() {
        mHomePresenter = HomePresenter.getHomePresenter();
        Intent intent = getIntent();
        String shopName = intent.getStringExtra(Constants.SHOP_NAME);
        tvTitle.setText(shopName);
        List<BusinessInformation> businessInformationList = mDaoSession.queryBuilder(BusinessInformation.class)
                .where(BusinessInformationDao.Properties.Name.eq(shopName)).list();
        if (Utils.isNotEmpty(businessInformationList)) {
            BusinessInformation businessInformation = businessInformationList.get(0);
            tvAddress.setText(String.format("店铺地址：%s", businessInformation.getAddress()));
            tvPhone.setText(String.format("联系电话：%s", businessInformation.getPhone()));
            tvSellNum.setText(String.format("月销售量：%s", businessInformation.getSellNum()));
            tvStartPrice.setText(String.format("起步价：%s", businessInformation.getStartPrice()));
            tvDeliveryFee.setText(String.format("配送费：%s ¥", businessInformation.getDeliveryFee()));
        }
        mDishInfoList = mHomePresenter.getDishInfoList();
        mRvDishAdapter.setObjects(mDishInfoList);
        mHomePresenter.resetData();
        mHomePresenter.setDishCount(0);
    }

    private void initView() {
        ivLeft = findViewById(R.id.ivLeft);
        ivLeft.setOnClickListener(v -> finish());
        tvTitle = findViewById(R.id.tvTitle);
        tvAddress = findViewById(R.id.tvAddress);
        tvPhone = findViewById(R.id.tvPhone);
        tvSellNum = findViewById(R.id.tvSellNum);
        tvStartPrice = findViewById(R.id.tvStartPrice);
        tvDeliveryFee = findViewById(R.id.tvDeliveryFee);
        rvDishList = findViewById(R.id.rvDishList);
        rlContainer = findViewById(R.id.rlContainer);
        tvCount = findViewById(R.id.tvCount);
        LinearLayoutManager dishListManager = new LinearLayoutManager(this);
        mRvDishAdapter = new ItemRvDishAdapter(this);
        rvDishList.setLayoutManager(dishListManager);
        rvDishList.setAdapter(mRvDishAdapter);
    }
}