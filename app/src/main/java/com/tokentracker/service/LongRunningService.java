package com.tokentracker.service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Looper;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import android.util.Log;

import com.tokentracker.Constants;
import com.tokentracker.api.Api;
import com.tokentracker.api.HostType;
import com.tokentracker.base.BaseApplication;
import com.tokentracker.base.rxjava.MyRxSubscriber;
import com.tokentracker.base.rxjava.RxSchedulers;
import com.tokentracker.bean.TokenBean;
import com.tokentracker.bean.TokenTableBean;
import com.tokentracker.db.TableConfig;
import com.tokentracker.receiver.AlarmReceiver;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LongRunningService extends Service {
    String[] EOS_ADDRESS = {Constants.EOS_ADDRESS_2,Constants.EOS_ADDRESS_3,Constants.EOS_ADDRESS_4,Constants.EOS_ADDRESS_5,Constants.EOS_ADDRESS_6,Constants.EOS_ADDRESS_7,Constants.EOS_ADDRESS_8,Constants.EOS_ADDRESS_9,Constants.EOS_ADDRESS_10,Constants.EOS_ADDRESS_11,Constants.EOS_ADDRESS_12,Constants.EOS_ADDRESS_13,Constants.EOS_ADDRESS_14,Constants.EOS_ADDRESS_15,Constants.EOS_ADDRESS_16,Constants.EOS_ADDRESS_17,Constants.EOS_ADDRESS_18,Constants.EOS_ADDRESS_19,Constants.EOS_ADDRESS_20,Constants.EOS_ADDRESS_21,Constants.EOS_ADDRESS_22,Constants.EOS_ADDRESS_23,Constants.EOS_ADDRESS_24,Constants.EOS_ADDRESS_25,Constants.EOS_ADDRESS_26,Constants.EOS_ADDRESS_27,Constants.EOS_ADDRESS_28,Constants.EOS_ADDRESS_29,Constants.EOS_ADDRESS_30,Constants.EOS_ADDRESS_31};
    String[] EOS_ADDRESS_BALANCE = {Constants.EOS_ADDRESS_2_balance,Constants.EOS_ADDRESS_3_balance,Constants.EOS_ADDRESS_4_balance,Constants.EOS_ADDRESS_5_balance,Constants.EOS_ADDRESS_6_balance,Constants.EOS_ADDRESS_7_balance,Constants.EOS_ADDRESS_8_balance,Constants.EOS_ADDRESS_9_balance,Constants.EOS_ADDRESS_10_balance,Constants.EOS_ADDRESS_11_balance,Constants.EOS_ADDRESS_12_balance,Constants.EOS_ADDRESS_13_balance,Constants.EOS_ADDRESS_14_balance,Constants.EOS_ADDRESS_15_balance,Constants.EOS_ADDRESS_16_balance,Constants.EOS_ADDRESS_17_balance,Constants.EOS_ADDRESS_18_balance,Constants.EOS_ADDRESS_19_balance,Constants.EOS_ADDRESS_20_balance,Constants.EOS_ADDRESS_21_balance,Constants.EOS_ADDRESS_22_balance,Constants.EOS_ADDRESS_23_balance,Constants.EOS_ADDRESS_24_balance,Constants.EOS_ADDRESS_25_balance,Constants.EOS_ADDRESS_26_balance,Constants.EOS_ADDRESS_27_balance,Constants.EOS_ADDRESS_28_balance,Constants.EOS_ADDRESS_29_balance,Constants.EOS_ADDRESS_30_balance,Constants.EOS_ADDRESS_31_balance};
    private String tokenSubString;


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //这里开辟一条线程,用来执行具体的逻辑操作:
        new Thread(new Runnable() {
            @Override
            public void run() {
                Looper.prepare();
                for(int i=0;i<EOS_ADDRESS.length;i++){
                    getTokenBalance(EOS_ADDRESS[i],EOS_ADDRESS_BALANCE[i]);
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Looper.loop();
            }
        }).start();
        AlarmManager manager = (AlarmManager) getSystemService(ALARM_SERVICE);
        //这里是定时的,这里设置的是每隔两秒打印一次时间=-=,自己改
//        int anHour = 60 * 60 * 1000;
        int anHour = 2*60*60 * 1000;
        long triggerAtTime = SystemClock.elapsedRealtime() + anHour;
        Intent i = new Intent(this,AlarmReceiver.class);
        PendingIntent pi = PendingIntent.getBroadcast(this, 0, i, 0);
        manager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, triggerAtTime, pi);
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    private void getTokenBalance(final String address, final String balance_previous) {
        ArrayMap<String, String> map = new ArrayMap<>();
        map.put("module", "account");
        map.put("action", "tokenbalance");
        map.put("contractaddress", "0x86fa049857e0209aa7d9e616f7eb3b3b78ecfdb0");
        map.put("address", address);
        map.put("tag", "latest");
        map.put("apikey", Constants.API_KEY);

        Api.getDefault(HostType.EOS_URL).requestTokenAmount(Api.getCacheControl(), map)
                .compose(RxSchedulers.<TokenBean>io_main())
                .subscribe(new MyRxSubscriber<TokenBean>(getApplicationContext(), "loading", false) {

                    @Override
                    protected void _onNext(TokenBean billInfoBean) {
                        Log.e("定时",billInfoBean.getResult());
                        String tokenBalance = billInfoBean.getResult();
                        if(!"0".equals(tokenBalance)){
                            tokenSubString = tokenBalance.substring(0,tokenBalance.length()-18);
                        }else {
                            tokenSubString = "0";
                        }
                        BigDecimal pre = new BigDecimal(balance_previous);
                        BigDecimal now = new BigDecimal(tokenSubString);

                        BigDecimal x = now.subtract(pre);


                        String subAddress = address.substring(0,5);

                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");// HH:mm:ss
                        Date date = new Date(System.currentTimeMillis());
                        TokenTableBean tokenTableBean = new TokenTableBean(subAddress,"" + simpleDateFormat.format(date),tokenSubString,"");
                        BaseApplication.tableOperate.insert(TableConfig.TABLE_Token,tokenTableBean);
                    }

                    @Override
                    public void onCompleted() {
                        super.onCompleted();
                    }

                    @Override
                    protected void _onError(String message) {
                        Log.e("定时_onError",message);
                    }
                });
    }
}
