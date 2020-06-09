package com.example.meituan.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.example.meituan.beans.UserInfo;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "USER_INFO".
*/
public class UserInfoDao extends AbstractDao<UserInfo, String> {

    public static final String TABLENAME = "USER_INFO";

    /**
     * Properties of entity UserInfo.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property UserId = new Property(0, String.class, "userId", true, "USER_ID");
        public final static Property Password = new Property(1, String.class, "password", false, "PASSWORD");
    }


    public UserInfoDao(DaoConfig config) {
        super(config);
    }
    
    public UserInfoDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"USER_INFO\" (" + //
                "\"USER_ID\" TEXT PRIMARY KEY NOT NULL ," + // 0: userId
                "\"PASSWORD\" TEXT);"); // 1: password
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"USER_INFO\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, UserInfo entity) {
        stmt.clearBindings();
 
        String userId = entity.getUserId();
        if (userId != null) {
            stmt.bindString(1, userId);
        }
 
        String password = entity.getPassword();
        if (password != null) {
            stmt.bindString(2, password);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, UserInfo entity) {
        stmt.clearBindings();
 
        String userId = entity.getUserId();
        if (userId != null) {
            stmt.bindString(1, userId);
        }
 
        String password = entity.getPassword();
        if (password != null) {
            stmt.bindString(2, password);
        }
    }

    @Override
    public String readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0);
    }    

    @Override
    public UserInfo readEntity(Cursor cursor, int offset) {
        UserInfo entity = new UserInfo( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // userId
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1) // password
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, UserInfo entity, int offset) {
        entity.setUserId(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setPassword(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
     }
    
    @Override
    protected final String updateKeyAfterInsert(UserInfo entity, long rowId) {
        return entity.getUserId();
    }
    
    @Override
    public String getKey(UserInfo entity) {
        if(entity != null) {
            return entity.getUserId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(UserInfo entity) {
        return entity.getUserId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}