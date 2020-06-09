package com.example.meituan.presenter;

import android.util.Log;

import com.example.meituan.R;
import com.example.meituan.base.BaseApplication;
import com.example.meituan.beans.BusinessInformation;
import com.example.meituan.beans.DishInfo;
import com.example.meituan.beans.MenuType;
import com.example.meituan.beans.UserInfo;
import com.example.meituan.db.DaoSession;
import com.example.meituan.utils.Constants;
import com.example.meituan.utils.Utils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomePresenter {

    private static final String TAG = "HomePresenter";
    private DaoSession mDaoSession = BaseApplication.getDaoSession();
    private List<MenuType> mMenuTypes = new ArrayList<>();
    private static HomePresenter sHomePresenter = null;
    private List<DishInfo> mDishInfoList;

    private HomePresenter() {
        mMenuTypes.add(new MenuType(R.drawable.img_takeaway, "外卖"));
        mMenuTypes.add(new MenuType(R.drawable.img_supermarket, "超市"));
        mMenuTypes.add(new MenuType(R.drawable.img_melon, "瓜果"));
        mMenuTypes.add(new MenuType(R.drawable.img_fresh_flowers, "鲜花"));
        mMenuTypes.add(new MenuType(R.drawable.img_recreation, "娱乐"));
        mMenuTypes.add(new MenuType(R.drawable.img_milk_tea, "奶茶"));
    }

    public static HomePresenter getHomePresenter() {
        if (sHomePresenter == null) {
            synchronized (HomePresenter.class) {
                if (sHomePresenter == null) {
                    sHomePresenter = new HomePresenter();
                }
            }
        }
        return sHomePresenter;
    }

    public List<MenuType> getMenuTypes() {
        return mMenuTypes;
    }

    /**
     * 重置商家数据
     */
    public void resetData() {
        resetUserInfo();
        resetBusinessInfo();
        resetDishInfo();
        mDishInfoList = mDaoSession.loadAll(DishInfo.class);
    }

    /**
     * 重置菜品信息
     */
    private void resetDishInfo() {
        //菜品信息
        List<DishInfo> dishInfoList = new Gson().fromJson(Constants.DISH_INFO, new TypeToken<List<DishInfo>>() {
        }.getType());
        if (Utils.isNotEmpty(mDaoSession)) {
            int count = 0;
            mDaoSession.deleteAll(DishInfo.class);
            for (DishInfo dishInfo : dishInfoList) {
                if (Utils.isNotEmpty(dishInfo)) {
                    mDaoSession.insertOrReplace(dishInfo);
                }
                Log.d(TAG, "resetData: ======== insert DishInfo ====> " + count++);
            }
        }
    }

    /**
     * 重置商家信息
     */
    private void resetBusinessInfo() {
        //商家信息
        List<BusinessInformation> businessInformationList = new Gson().fromJson(Constants.SHOPS_INFO, new TypeToken<List<BusinessInformation>>() {
        }.getType());
        if (Utils.isNotEmpty(mDaoSession)) {
            int count = 0;
            mDaoSession.deleteAll(BusinessInformation.class);
            for (BusinessInformation businessInformation : businessInformationList) {
                if (Utils.isNotEmpty(businessInformation)) {
                    mDaoSession.insertOrReplace(businessInformation);
                }
                Log.d(TAG, "resetData: ======== insert BusinessInformation ====> " + count++);
            }
        }
    }

    /**
     * 重置用户信息
     */
    private void resetUserInfo() {
        //用户信息
        List<UserInfo> userInfoList = new Gson().fromJson(Constants.USER_INFO, new TypeToken<List<UserInfo>>() {
        }.getType());
        if (Utils.isNotEmpty(mDaoSession)) {
            int count = 0;
            mDaoSession.deleteAll(UserInfo.class);
            for (UserInfo userInfo : userInfoList) {
                if (Utils.isNotEmpty(userInfo)) {
                    mDaoSession.insertOrReplace(userInfo);
                }
                Log.d(TAG, "resetData: ======== insert UserInfo ====> " + count++);
            }
        }
    }

    /**
     * 获取所有商家信息
     *
     * @return List<BusinessInformationDataBean>
     */
    public List<BusinessInformation> getBusinessInformationList() {
        return mDaoSession.loadAll(BusinessInformation.class);
    }

    public List<DishInfo> getDishInfoList() {
        return mDishInfoList;
    }

    public void setDishInfoList(List<DishInfo> dishInfoList) {
        mDishInfoList = dishInfoList;
    }

    private int dishCount = 0;

    public int getDishCount() {
        return dishCount;
    }

    public void setDishCount(int dishCount) {
        this.dishCount = dishCount;
    }
}
