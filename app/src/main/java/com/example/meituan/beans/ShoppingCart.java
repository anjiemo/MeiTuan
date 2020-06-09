package com.example.meituan.beans;

import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Keep;

public class ShoppingCart {

    @Id
    private String shopName;
    private DishInfo mDishInfo;

    @Keep
    public ShoppingCart(String shopName, DishInfo dishInfo) {
        this.shopName = shopName;
        mDishInfo = dishInfo;
    }

    @Keep
    public ShoppingCart() {
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public DishInfo getDishInfo() {
        return mDishInfo;
    }

    public void setDishInfo(DishInfo dishInfo) {
        mDishInfo = dishInfo;
    }
}
