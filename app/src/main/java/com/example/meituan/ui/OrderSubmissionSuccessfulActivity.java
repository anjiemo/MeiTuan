package com.example.meituan.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.meituan.R;
import com.example.meituan.beans.DishInfo;
import com.example.meituan.presenter.HomePresenter;
import com.example.meituan.utils.Constants;

import java.util.List;

public class OrderSubmissionSuccessfulActivity extends AppCompatActivity {

    private TextView tvCountPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_submission_successful);
        initView();
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        int price = intent.getIntExtra(Constants.ALL_PRICE, 0);
        tvCountPrice.setText(String.format("本次支付：%s元", price));
    }

    private void initView() {
        tvCountPrice = findViewById(R.id.tvCountPrice);
    }

    @Override
    protected void onPause() {
        super.onPause();
        setResultData();
    }

    private void setResultData() {
        HomePresenter homePresenter = HomePresenter.getHomePresenter();
        List<DishInfo> dishInfoList = homePresenter.getDishInfoList();
        for (DishInfo dishInfo : dishInfoList) {
            dishInfo.setOrderNum(0);
        }
        homePresenter.setDishCount(0);
        Intent intent = new Intent();
        setResult(RESULT_OK, intent);
    }
}