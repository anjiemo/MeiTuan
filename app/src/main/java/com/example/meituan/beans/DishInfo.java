package com.example.meituan.beans;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Keep;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class DishInfo {

    @Id
    //菜名
    private String dishName;
    //菜品的logo
    private String dishLogo;
    //菜品的点赞量
    private int starNum;
    //菜品价格
    private double dishPrice;
    //订购数量
    private int orderNum;

    @Keep
    public DishInfo() {
    }

    @Keep
    public DishInfo(String dishName, String dishLogo, int starNum, double dishPrice, int orderNum) {
        this.dishName = dishName;
        this.dishLogo = dishLogo;
        this.starNum = starNum;
        this.dishPrice = dishPrice;
        this.orderNum = orderNum;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getDishLogo() {
        return dishLogo;
    }

    public void setDishLogo(String dishLogo) {
        this.dishLogo = dishLogo;
    }

    public int getStarNum() {
        return starNum;
    }

    public void setStarNum(int starNum) {
        this.starNum = starNum;
    }

    public double getDishPrice() {
        return dishPrice;
    }

    public void setDishPrice(double dishPrice) {
        this.dishPrice = dishPrice;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }
}
