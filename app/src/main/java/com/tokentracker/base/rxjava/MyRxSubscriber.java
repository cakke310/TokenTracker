package com.tokentracker.base.rxjava;

import android.content.Context;

import com.tokentracker.R;
import com.tokentracker.Util.MyDialogLoading;
import com.tokentracker.Util.NetWorkUtils;
import com.tokentracker.base.BaseApplication;

import rx.Subscriber;

/**
 * Created by Administrator on 2017/11/7.
 */

public abstract class MyRxSubscriber<T> extends Subscriber<T> {

    private Context mContext;
    private String msg;
    private boolean showDialog = true;
    public MyDialogLoading dialogLoading;

    /**
     * 是否显示浮动dialog
     */
    public void showDialog() {
        this.showDialog = true;
    }

    public void hideDialog() {
        this.showDialog = true;
    }

    public MyRxSubscriber(Context context, String msg, boolean showDialog) {
        this.mContext = context;
        this.msg = msg;
        this.showDialog = showDialog;
        dialogLoading = new MyDialogLoading(context);
        dialogLoading.setDialogLabel(msg);
    }
    public MyRxSubscriber(Context context,boolean showDialog) {
        this.mContext = context;
        this.msg = msg;
        this.showDialog = showDialog;
        dialogLoading = new MyDialogLoading(context);
        dialogLoading.setDialogLabel(msg);
    }

    public MyRxSubscriber(Context context, String msg) {
        this.mContext = context;
        this.msg = msg;
        dialogLoading = new MyDialogLoading(context);
        dialogLoading.setDialogLabel(msg);
    }

    public MyRxSubscriber(Context context) {
        this.mContext = context;
        this.msg = "加载中";
        this.showDialog = true;
        dialogLoading = new MyDialogLoading(context);
        dialogLoading.setDialogLabel(msg);
    }


    @Override
    public void onCompleted() {
        if (showDialog && dialogLoading != null) {
            dialogLoading.dismiss();
        }

    }

    @Override
    public void onStart() {
        super.onStart();
        if (showDialog && dialogLoading != null) {
            try {
                //显示dialog
                dialogLoading.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void onError(Throwable e) {
        if (showDialog)
            dialogLoading.dismiss();
        e.printStackTrace();
        //无网络
        if (!NetWorkUtils.isNetConnected(BaseApplication.getAppContext())) {
            _onError(BaseApplication.getAppContext().getString(R.string.no_net));
        }
        else if (e instanceof ServerException) { //自定义服务器错误
            _onError(e.getMessage());
        }
        else { //其它
            _onError(BaseApplication.getAppContext().getString(R.string.net_error));
        }

    }



    @Override
    public void onNext(T t) {
        _onNext(t);
    }

    //子类中实现
    protected abstract void _onNext(T t);

    //子类中实现
    protected abstract void _onError(String message);

}
