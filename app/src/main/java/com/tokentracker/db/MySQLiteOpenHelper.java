package com.tokentracker.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Riven on 2018/5/15.
 */

public class MySQLiteOpenHelper extends SQLiteOpenHelper {
    private static  MySQLiteOpenHelper helper;
    private static final String DATABASE_NAME = "token.db";//数据库名字
    private static final String CREATE_TABLE = "create table Token ("
            + "id integer primary key autoincrement,"
            + "address text, "
            + "author text, "
            + "price real)";//数据库里的表


    //构造器,传入四个参数Context对象，数据库名字name，操作数据库的Cursor对象，版本号version。
    private MySQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //为了简化构造器的使用，我们自定义一个构造器
    private MySQLiteOpenHelper(Context context, String name) {
        this(context, name, null, 1);//传入Context和数据库的名称，调用上面那个构造器
    }
    //将自定义的数据库创建类单例。
    public static  synchronized  MySQLiteOpenHelper getInstance(Context context) {
        if(helper==null){
            helper = new MySQLiteOpenHelper(context, "TokenDb");//数据库名称为create_db。
        }
        return  helper;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("create table if not exists "+TableConfig.TABLE_Token+"("
                +TableConfig.Customer.TOKEN_ID+" integer not null primary key autoincrement,"
                +TableConfig.Customer.TOKEN_ADDRESS+ " verchar(20),"
                +TableConfig.Customer.TOKEN_DATE+ " verchar(20),"
                +TableConfig.Customer.TOKEN_BALANCE+ " verchar(20))"
                );

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
