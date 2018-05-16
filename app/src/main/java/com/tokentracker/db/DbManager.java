package com.tokentracker.db;

import android.database.sqlite.SQLiteDatabase;

import com.tokentracker.base.BaseApplication;

/**
 * Created by Riven on 2018/5/15.
 */

public class DbManager {
    private static DbManager manager;
    private MySQLiteOpenHelper mySQLiteOpenHelper;
    private SQLiteDatabase db;

    /**
     * 私有化构造器
     */
    private DbManager() {
        //创建数据库
        mySQLiteOpenHelper = MySQLiteOpenHelper.getInstance(BaseApplication.getAppContext());
        if (db == null) {
            db = mySQLiteOpenHelper.getWritableDatabase();
        }
    }

    /**
     * 单例DbManager类
     *
     * @return 返回DbManager对象
     */
    public static DbManager newInstances() {
        if (manager == null) {
            manager = new DbManager();
        }
        return manager;
    }

    /**
     * 获取数据库的对象
     *
     * @return 返回SQLiteDatabase数据库的对象
     */
    public SQLiteDatabase getDataBase() {
        return db;
    }
}
