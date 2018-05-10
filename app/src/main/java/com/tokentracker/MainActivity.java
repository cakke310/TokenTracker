package com.tokentracker;

import android.support.v4.util.ArrayMap;
import android.util.Log;
import android.widget.TextView;

import com.tokentracker.api.Api;
import com.tokentracker.api.HostType;
import com.tokentracker.base.BaseActivity;
import com.tokentracker.base.rxjava.MyRxSubscriber;
import com.tokentracker.base.rxjava.RxSchedulers;
import com.tokentracker.bean.TokenBean;

import java.math.BigDecimal;

import butterknife.BindView;


public class MainActivity extends BaseActivity {
    @BindView(R.id.tv_token2)
    TextView tv_token2;
    @BindView(R.id.tv_token3)
    TextView tv_token3;
    @BindView(R.id.tv_token4)
    TextView tv_token4;
    @BindView(R.id.tv_token5)
    TextView tv_token5;
    @BindView(R.id.tv_token6)
    TextView tv_token6;
    @BindView(R.id.tv_token7)
    TextView tv_token7;
    @BindView(R.id.tv_token8)
    TextView tv_token8;
    @BindView(R.id.tv_token9)
    TextView tv_token9;
    @BindView(R.id.tv_token10)
    TextView tv_token10;
    @BindView(R.id.tv_token11)
    TextView tv_token11;
    @BindView(R.id.tv_token12)
    TextView tv_token12;
    @BindView(R.id.tv_token13)
    TextView tv_token13;
    @BindView(R.id.tv_token14)
    TextView tv_token14;
    @BindView(R.id.tv_token15)
    TextView tv_token15;
    @BindView(R.id.tv_token16)
    TextView tv_token16;
    @BindView(R.id.tv_token17)
    TextView tv_token17;
    @BindView(R.id.tv_token18)
    TextView tv_token18;
    @BindView(R.id.tv_token19)
    TextView tv_token19;
    @BindView(R.id.tv_token20)
    TextView tv_token20;

    @BindView(R.id.tv_range2)
    TextView tv_range2;

    private static final int DEF_DIV_SCALE = 10;

    String[] EOS_ADDRESS_BALANCE = {Constants.EOS_ADDRESS_2_balance,Constants.EOS_ADDRESS_3_balance,Constants.EOS_ADDRESS_4_balance,Constants.EOS_ADDRESS_5_balance,Constants.EOS_ADDRESS_6_balance,Constants.EOS_ADDRESS_7_balance,Constants.EOS_ADDRESS_8_balance,Constants.EOS_ADDRESS_9_balance,Constants.EOS_ADDRESS_10_balance,Constants.EOS_ADDRESS_11_balance,Constants.EOS_ADDRESS_12_balance,Constants.EOS_ADDRESS_13_balance,Constants.EOS_ADDRESS_14_balance,Constants.EOS_ADDRESS_15_balance,Constants.EOS_ADDRESS_16_balance,Constants.EOS_ADDRESS_17_balance,Constants.EOS_ADDRESS_18_balance,Constants.EOS_ADDRESS_19_balance,Constants.EOS_ADDRESS_20_balance};

    String[] EOS_ADDRESS = {Constants.EOS_ADDRESS_2,Constants.EOS_ADDRESS_3,Constants.EOS_ADDRESS_4,Constants.EOS_ADDRESS_5,Constants.EOS_ADDRESS_6,Constants.EOS_ADDRESS_7,Constants.EOS_ADDRESS_8,Constants.EOS_ADDRESS_9,Constants.EOS_ADDRESS_10,Constants.EOS_ADDRESS_11,Constants.EOS_ADDRESS_12,Constants.EOS_ADDRESS_13,Constants.EOS_ADDRESS_14,Constants.EOS_ADDRESS_15,Constants.EOS_ADDRESS_16,Constants.EOS_ADDRESS_17,Constants.EOS_ADDRESS_18,Constants.EOS_ADDRESS_19,Constants.EOS_ADDRESS_20};
    String[] NUMBER ={"2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20"};
    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        TextView textArray[]={tv_token2,tv_token3,tv_token4,tv_token5,tv_token6,tv_token7,tv_token8,tv_token9,tv_token10,tv_token11,tv_token12,tv_token13,tv_token14,tv_token15,tv_token16,tv_token17,tv_token18,tv_token19,tv_token20};

        for(int i=0;i<NUMBER.length;i++){
            getTokenBalance(EOS_ADDRESS[i],textArray[i],NUMBER[i],EOS_ADDRESS_BALANCE[i],tv_range2);
//            getTokenBalance(EOS_ADDRESS[i],tv_token20,NUMBER[i]);
//            Log.e("2222",EOS_ADDRESS[i]+"----"+NUMBER[i]);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

//        getTokenBalance(Constants.EOS_ADDRESS_2,tv_token2,"2");
//        getTokenBalance(Constants.EOS_ADDRESS_3,tv_token3,"3");
//        getTokenBalance(Constants.EOS_ADDRESS_4,tv_token4,"4");
//        getTokenBalance(Constants.EOS_ADDRESS_5,tv_token5,"5");
//        getTokenBalance(Constants.EOS_ADDRESS_6,tv_token6,"6");
//        getTokenBalance(Constants.EOS_ADDRESS_7,tv_token7,"7");
//        getTokenBalance(Constants.EOS_ADDRESS_8,tv_token8,"8");
//        getTokenBalance(Constants.EOS_ADDRESS_9,tv_token9,"9");
//        getTokenBalance(Constants.EOS_ADDRESS_10,tv_token10,"10");
//        getTokenBalance(Constants.EOS_ADDRESS_11,tv_token11,"11");
//        getTokenBalance(Constants.EOS_ADDRESS_12,tv_token12,"12");
//        getTokenBalance(Constants.EOS_ADDRESS_13,tv_token13,"13");
//        getTokenBalance(Constants.EOS_ADDRESS_14,tv_token14,"14");
//        getTokenBalance(Constants.EOS_ADDRESS_15,tv_token15,"15");
//        getTokenBalance(Constants.EOS_ADDRESS_16,tv_token16,"16");
//        getTokenBalance(Constants.EOS_ADDRESS_17,tv_token17,"17");
//        getTokenBalance(Constants.EOS_ADDRESS_18,tv_token18,"18");
//        getTokenBalance(Constants.EOS_ADDRESS_19,tv_token19,"19");
//        getTokenBalance(Constants.EOS_ADDRESS_20,tv_token20,"20");
    }

    private void getTokenBalance(final String address, final TextView tv, final String number, final String balance_previous, final TextView tv_range2) {
        ArrayMap<String, String> map = new ArrayMap<>();
        map.put("module", "account");
        map.put("action", "tokenbalance");
        map.put("contractaddress", "0x86fa049857e0209aa7d9e616f7eb3b3b78ecfdb0");
        map.put("address", address);
        map.put("tag", "latest");
        map.put("apikey", Constants.API_KEY);

        Api.getDefault(HostType.EOS_URL).requestTokenAmount(Api.getCacheControl(), map)
                .compose(RxSchedulers.<TokenBean>io_main())
                .subscribe(new MyRxSubscriber<TokenBean>(getApplicationContext(), "提交中", false) {

                    @Override
                    protected void _onNext(TokenBean billInfoBean) {
//                        Log.e("222",billInfoBean.getResult());
                        String tokenBalance = billInfoBean.getResult();
                        String tokenSubString = tokenBalance.substring(0,tokenBalance.length()-18);

//                        BigDecimal pre = new BigDecimal(balance_previous);
                        BigDecimal pre = new BigDecimal(balance_previous);
                        BigDecimal now = new BigDecimal(tokenSubString);

                        BigDecimal x = pre.subtract(now);
                        BigDecimal y = x.divide(pre,2,BigDecimal.ROUND_HALF_UP);
                        BigDecimal z = y.multiply(BigDecimal.valueOf(100));
//                        BigDecimal y = x.divide(pre);
                        Log.e("333",pre+"---"+now);
                        Log.e("333","---|"+x);
                        Log.e("333","---|"+y);
                        Log.e("333","---|"+z);
//                        Log.e("333","---"+tokenSubString);




                        String subAddress = address.substring(0,5);

                        tv.setText(subAddress+"地址拥有EOS: "+tokenSubString);

                        tv_range2.setText("变动: "+z+"%");
                    }

                    @Override
                    public void onCompleted() {
                        super.onCompleted();
                    }

                    @Override
                    protected void _onError(String message) {
                        Log.e("222",message);
                    }
                });
    }
}
