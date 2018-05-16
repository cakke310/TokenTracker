package com.tokentracker.base;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

import com.tokentracker.db.TableOperate;

/**
 * APPLICATION
 */
public class BaseApplication extends Application {

    private static BaseApplication baseApplication;
    public static TableOperate tableOperate;

    @Override
    public void onCreate() {
        super.onCreate();
        baseApplication = this;
        tableOperate = new TableOperate();
    }

    //Application其实就是Context
    public static Context getAppContext() {
        return baseApplication;
    }

    //getAppResources
    public static Resources getAppResources() {
        return baseApplication.getResources();
    }
}



