package com.example.meituan.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.meituan.R;
import com.example.meituan.adapters.ItemRvOrderListAdapter;
import com.example.meituan.base.BaseApplication;
import com.example.meituan.beans.DishInfo;
import com.example.meituan.db.DaoSession;
import com.example.meituan.presenter.HomePresenter;
import com.example.meituan.utils.Constants;
import com.example.meituan.utils.Utils;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * 订单列表
 */
public class OrderListActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "OrderListActivity";
    private ImageView ivLeft;
    private TextView tvTitle;
    private RecyclerView rvOrderList;
    private Button btnSubmit;
    private HomePresenter mHomePresenter;
    private LinearLayoutManager mOrderListManager;
    private ItemRvOrderListAdapter mOrderListAdapter;
    private SharedPreferences mSp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_list);
        initView();
        initData();
    }

    /**
     * 初始化数据
     */
    private void initData() {
        mHomePresenter = HomePresenter.getHomePresenter();
        List<DishInfo> dishInfoList = mHomePresenter.getDishInfoList();
        if (Utils.isNotEmpty(dishInfoList)) {
            mOrderListAdapter.setObjects(dishInfoList);
        }
    }

    private void initView() {
        ivLeft = findViewById(R.id.ivLeft);
        ivLeft.setOnClickListener(v -> {
            setResultData();
            finish();
        });
        tvTitle = findViewById(R.id.tvTitle);
        tvTitle.setText("订单列表");
        rvOrderList = findViewById(R.id.rvOrderList);
        mOrderListManager = new LinearLayoutManager(this);
        mOrderListAdapter = new ItemRvOrderListAdapter(this);
        rvOrderList.setLayoutManager(mOrderListManager);
        rvOrderList.setAdapter(mOrderListAdapter);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(this);
    }

    /**
     * 在界面挂起的时候将数据返回给上一个界面
     */
    @Override
    protected void onPause() {
        super.onPause();
        setResultData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setResultData();
    }

    /**
     * 在当前界面统计好数量，然后返回给上一个界面
     */
    private void setResultData() {
        if (Utils.isNotEmpty(mOrderListAdapter)) {
            List<DishInfo> dishInfoList = mOrderListAdapter.getObjects();
            int dishCount = 0;
            for (DishInfo dishInfo : dishInfoList) {
                dishCount += dishInfo.getOrderNum();
            }
            if (Utils.isNotEmpty(mHomePresenter)) {
                mHomePresenter.setDishCount(dishCount);
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSubmit:
                mSp = getSharedPreferences(Constants.SETTING, MODE_PRIVATE);
                boolean isLogin = mSp.getBoolean(Constants.IS_LOGIN, false);
                //如果已经登录，则跳转到订单列表界面
                if (!isLogin) {
                    startActivity(new Intent(this, LoginActivity.class));
                    return;
                }
                List<DishInfo> dishInfoList = mOrderListAdapter.getObjects();
                //所有菜品的总金额
                int allPrice = 0;
                for (DishInfo dishInfo : dishInfoList) {
                    //每一个类别的菜品总金额
                    double price = dishInfo.getOrderNum() * dishInfo.getDishPrice();
                    allPrice += price;
                }
                if (allPrice == 0) {
                    Toast.makeText(this, "订单空空如也，先去选菜吧~", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent(this, OrderSubmissionSuccessfulActivity.class);
                intent.putExtra(Constants.ALL_PRICE, allPrice);
                startActivityForResult(intent,2);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //从上一个界面返回时，清空订单列表
        if (Utils.isNotEmpty(mOrderListAdapter)) {
            mOrderListAdapter.resetObjects();
        }
    }
}