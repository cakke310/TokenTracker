package com.tokentracker.base.rxjava;

import android.content.Context;

import com.tokentracker.R;
import com.tokentracker.Util.DialogLoading;
import com.tokentracker.Util.NetWorkUtils;
import com.tokentracker.base.BaseApplication;

import rx.Subscriber;


/**
 * des:订阅封装  封装dialog和有无网络到RxSubscriber
 * return subscriber
 */

/********************
 * 使用例子
 ********************/
    /*_apiService.login(mobile, verifyCode)
        .//省略
        .subscribe(new RxSubscriber<User user>(mContext,false) {
    @Override
    public void _onNext(User user) {
        // 处理user
        }

    @Override
    public void _onError(String msg) {
        ToastUtil.showShort(mActivity, msg);
    });*/
public abstract class RxSubscriber<T> extends Subscriber<T> {

    private Context mContext;
    private String msg;
    private boolean showDialog = true;
    public DialogLoading dialogLoading;

    /**
     * 是否显示浮动dialog
     */
    public void showDialog() {
        this.showDialog = true;
    }

    public void hideDialog() {
        this.showDialog = true;
    }

    public RxSubscriber(Context context, String msg, boolean showDialog) {
        this.mContext = context;
        this.msg = msg;
        this.showDialog = showDialog;
        dialogLoading = new DialogLoading(context);
        dialogLoading.setDialogLabel(msg);
    }

    public RxSubscriber(Context context) {

        this(context, BaseApplication.getAppContext().getString(R.string.loading), true);
    }

    public RxSubscriber(Context context, boolean showDialog) {
        this(context, BaseApplication.getAppContext().getString(R.string.loading), showDialog);
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
    public void onNext(T t) {
        _onNext(t);
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

    //子类中实现
    protected abstract void _onNext(T t);

    //子类中实现
    protected abstract void _onError(String message);

}
