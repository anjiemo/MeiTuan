package com.example.meituan.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.example.meituan.beans.DishInfo;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "DISH_INFO".
*/
public class DishInfoDao extends AbstractDao<DishInfo, String> {

    public static final String TABLENAME = "DISH_INFO";

    /**
     * Properties of entity DishInfo.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property DishName = new Property(0, String.class, "dishName", true, "DISH_NAME");
        public final static Property DishLogo = new Property(1, String.class, "dishLogo", false, "DISH_LOGO");
        public final static Property StarNum = new Property(2, int.class, "starNum", false, "STAR_NUM");
        public final static Property DishPrice = new Property(3, double.class, "dishPrice", false, "DISH_PRICE");
        public final static Property OrderNum = new Property(4, int.class, "orderNum", false, "ORDER_NUM");
    }


    public DishInfoDao(DaoConfig config) {
        super(config);
    }
    
    public DishInfoDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"DISH_INFO\" (" + //
                "\"DISH_NAME\" TEXT PRIMARY KEY NOT NULL ," + // 0: dishName
                "\"DISH_LOGO\" TEXT," + // 1: dishLogo
                "\"STAR_NUM\" INTEGER NOT NULL ," + // 2: starNum
                "\"DISH_PRICE\" REAL NOT NULL ," + // 3: dishPrice
                "\"ORDER_NUM\" INTEGER NOT NULL );"); // 4: orderNum
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"DISH_INFO\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, DishInfo entity) {
        stmt.clearBindings();
 
        String dishName = entity.getDishName();
        if (dishName != null) {
            stmt.bindString(1, dishName);
        }
 
        String dishLogo = entity.getDishLogo();
        if (dishLogo != null) {
            stmt.bindString(2, dishLogo);
        }
        stmt.bindLong(3, entity.getStarNum());
        stmt.bindDouble(4, entity.getDishPrice());
        stmt.bindLong(5, entity.getOrderNum());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, DishInfo entity) {
        stmt.clearBindings();
 
        String dishName = entity.getDishName();
        if (dishName != null) {
            stmt.bindString(1, dishName);
        }
 
        String dishLogo = entity.getDishLogo();
        if (dishLogo != null) {
            stmt.bindString(2, dishLogo);
        }
        stmt.bindLong(3, entity.getStarNum());
        stmt.bindDouble(4, entity.getDishPrice());
        stmt.bindLong(5, entity.getOrderNum());
    }

    @Override
    public String readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0);
    }    

    @Override
    public DishInfo readEntity(Cursor cursor, int offset) {
        DishInfo entity = new DishInfo( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // dishName
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // dishLogo
            cursor.getInt(offset + 2), // starNum
            cursor.getDouble(offset + 3), // dishPrice
            cursor.getInt(offset + 4) // orderNum
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, DishInfo entity, int offset) {
        entity.setDishName(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setDishLogo(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setStarNum(cursor.getInt(offset + 2));
        entity.setDishPrice(cursor.getDouble(offset + 3));
        entity.setOrderNum(cursor.getInt(offset + 4));
     }
    
    @Override
    protected final String updateKeyAfterInsert(DishInfo entity, long rowId) {
        return entity.getDishName();
    }
    
    @Override
    public String getKey(DishInfo entity) {
        if(entity != null) {
            return entity.getDishName();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(DishInfo entity) {
        return entity.getDishName() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
