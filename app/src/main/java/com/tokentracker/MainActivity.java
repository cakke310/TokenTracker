package com.tokentracker;

import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.tokentracker.api.Api;
import com.tokentracker.api.HostType;
import com.tokentracker.base.rxjava.MyRxSubscriber;
import com.tokentracker.base.rxjava.RxSchedulers;
import com.tokentracker.bean.TokenBean;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayMap<String, String> map = new ArrayMap<>();
        map.put("module", "account");
        map.put("action", "tokenbalance");
        map.put("contractaddress", "0x86fa049857e0209aa7d9e616f7eb3b3b78ecfdb0");
        map.put("address", "0xd0a6e6c54dbc68db5db3a091b171a77407ff7ccf");
        map.put("tag", "latest");
        map.put("apikey", "9SP9C81ZBS37XIYYWXIDJITU9NYEQJP4A9");

        Api.getDefault(HostType.EOS_URL).requestTokenAmount(Api.getCacheControl(), map)
                .compose(RxSchedulers.<TokenBean>io_main())
                .subscribe(new MyRxSubscriber<TokenBean>(getApplicationContext(), "提交中", true) {

                    @Override
                    protected void _onNext(TokenBean billInfoBean) {
                        Log.e("222",billInfoBean.getResult());
                    }

                    @Override
                    protected void _onError(String message) {
                        Log.e("222",message);
                    }
                });
    }
}
