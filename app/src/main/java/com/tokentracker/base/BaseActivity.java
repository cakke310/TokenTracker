package com.tokentracker.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.tokentracker.Util.ToastUitl;

import butterknife.ButterKnife;


/**
 * Created by Riven on 2018/5/9.
 */

public abstract class BaseActivity extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        initView();
    }

    public void showShortToast(String text) {
        ToastUitl.showShort(text);
    }

    public abstract int getLayoutId();

    //初始化view
    public abstract void initView();
}
