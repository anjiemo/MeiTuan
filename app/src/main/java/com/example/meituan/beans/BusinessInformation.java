package com.example.meituan.beans;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Keep;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class BusinessInformation {

    @Id
    //店铺名称
    private String name;
    //店铺logo
    private String logo;
    //店铺类型
    private int type;
    //店铺地址
    private String address;
    //月销售量
    private int sellNum;
    //起步价
    private int startPrice;
    //联系电话
    private String phone;
    //配送费
    private int deliveryFee;

    @Keep
    public BusinessInformation(String name, String logo, int type, String address,
            int sellNum, int startPrice, String phone, int deliveryFee) {
        this.name = name;
        this.logo = logo;
        this.type = type;
        this.address = address;
        this.sellNum = sellNum;
        this.startPrice = startPrice;
        this.phone = phone;
        this.deliveryFee = deliveryFee;
    }

    @Keep
    public BusinessInformation() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getSellNum() {
        return sellNum;
    }

    public void setSellNum(int sellNum) {
        this.sellNum = sellNum;
    }

    public int getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(int startPrice) {
        this.startPrice = startPrice;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(int deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
