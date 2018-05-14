package com.tokentracker;

import android.content.Intent;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.tokentracker.api.Api;
import com.tokentracker.api.HostType;
import com.tokentracker.base.BaseActivity;
import com.tokentracker.base.rxjava.MyRxSubscriber;
import com.tokentracker.base.rxjava.RxSchedulers;
import com.tokentracker.bean.TokenBean;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    @BindView(R.id.tv_token21)
    TextView tv_token21;
    @BindView(R.id.tv_token22)
    TextView tv_token22;
    @BindView(R.id.tv_token23)
    TextView tv_token23;
    @BindView(R.id.tv_token24)
    TextView tv_token24;
    @BindView(R.id.tv_token25)
    TextView tv_token25;
    @BindView(R.id.tv_token26)
    TextView tv_token26;
    @BindView(R.id.tv_token27)
    TextView tv_token27;
    @BindView(R.id.tv_token28)
    TextView tv_token28;
    @BindView(R.id.tv_token29)
    TextView tv_token29;
    @BindView(R.id.tv_token30)
    TextView tv_token30;
    @BindView(R.id.tv_token31)
    TextView tv_token31;

    @BindView(R.id.tv_range2)
    TextView tv_range2;
    @BindView(R.id.tv_range3)
    TextView tv_range3;
    @BindView(R.id.tv_range4)
    TextView tv_range4;
    @BindView(R.id.tv_range5)
    TextView tv_range5;
    @BindView(R.id.tv_range6)
    TextView tv_range6;
    @BindView(R.id.tv_range7)
    TextView tv_range7;
    @BindView(R.id.tv_range8)
    TextView tv_range8;
    @BindView(R.id.tv_range9)
    TextView tv_range9;
    @BindView(R.id.tv_range10)
    TextView tv_range10;
    @BindView(R.id.tv_range11)
    TextView tv_range11;
    @BindView(R.id.tv_range12)
    TextView tv_range12;
    @BindView(R.id.tv_range13)
    TextView tv_range13;
    @BindView(R.id.tv_range14)
    TextView tv_range14;
    @BindView(R.id.tv_range15)
    TextView tv_range15;
    @BindView(R.id.tv_range16)
    TextView tv_range16;
    @BindView(R.id.tv_range17)
    TextView tv_range17;
    @BindView(R.id.tv_range18)
    TextView tv_range18;
    @BindView(R.id.tv_range19)
    TextView tv_range19;
    @BindView(R.id.tv_range20)
    TextView tv_range20;
    @BindView(R.id.tv_range21)
    TextView tv_range21;
    @BindView(R.id.tv_range22)
    TextView tv_range22;
    @BindView(R.id.tv_range23)
    TextView tv_range23;
    @BindView(R.id.tv_range24)
    TextView tv_range24;
    @BindView(R.id.tv_range25)
    TextView tv_range25;
    @BindView(R.id.tv_range26)
    TextView tv_range26;
    @BindView(R.id.tv_range27)
    TextView tv_range27;
    @BindView(R.id.tv_range28)
    TextView tv_range28;
    @BindView(R.id.tv_range29)
    TextView tv_range29;
    @BindView(R.id.tv_range30)
    TextView tv_range30;
    @BindView(R.id.tv_range31)
    TextView tv_range31;
    @BindView(R.id.tv_time)
    TextView tv_time;

    private static final int DEF_DIV_SCALE = 10;

    String[] EOS_ADDRESS_BALANCE = {Constants.EOS_ADDRESS_2_balance,Constants.EOS_ADDRESS_3_balance,Constants.EOS_ADDRESS_4_balance,Constants.EOS_ADDRESS_5_balance,Constants.EOS_ADDRESS_6_balance,Constants.EOS_ADDRESS_7_balance,Constants.EOS_ADDRESS_8_balance,Constants.EOS_ADDRESS_9_balance,Constants.EOS_ADDRESS_10_balance,Constants.EOS_ADDRESS_11_balance,Constants.EOS_ADDRESS_12_balance,Constants.EOS_ADDRESS_13_balance,Constants.EOS_ADDRESS_14_balance,Constants.EOS_ADDRESS_15_balance,Constants.EOS_ADDRESS_16_balance,Constants.EOS_ADDRESS_17_balance,Constants.EOS_ADDRESS_18_balance,Constants.EOS_ADDRESS_19_balance,Constants.EOS_ADDRESS_20_balance,Constants.EOS_ADDRESS_21_balance,Constants.EOS_ADDRESS_22_balance,Constants.EOS_ADDRESS_23_balance,Constants.EOS_ADDRESS_24_balance,Constants.EOS_ADDRESS_25_balance,Constants.EOS_ADDRESS_26_balance,Constants.EOS_ADDRESS_27_balance,Constants.EOS_ADDRESS_28_balance,Constants.EOS_ADDRESS_29_balance,Constants.EOS_ADDRESS_30_balance,Constants.EOS_ADDRESS_31_balance};

    String[] EOS_ADDRESS = {Constants.EOS_ADDRESS_2,Constants.EOS_ADDRESS_3,Constants.EOS_ADDRESS_4,Constants.EOS_ADDRESS_5,Constants.EOS_ADDRESS_6,Constants.EOS_ADDRESS_7,Constants.EOS_ADDRESS_8,Constants.EOS_ADDRESS_9,Constants.EOS_ADDRESS_10,Constants.EOS_ADDRESS_11,Constants.EOS_ADDRESS_12,Constants.EOS_ADDRESS_13,Constants.EOS_ADDRESS_14,Constants.EOS_ADDRESS_15,Constants.EOS_ADDRESS_16,Constants.EOS_ADDRESS_17,Constants.EOS_ADDRESS_18,Constants.EOS_ADDRESS_19,Constants.EOS_ADDRESS_20,Constants.EOS_ADDRESS_21,Constants.EOS_ADDRESS_22,Constants.EOS_ADDRESS_23,Constants.EOS_ADDRESS_24,Constants.EOS_ADDRESS_25,Constants.EOS_ADDRESS_26,Constants.EOS_ADDRESS_27,Constants.EOS_ADDRESS_28,Constants.EOS_ADDRESS_29,Constants.EOS_ADDRESS_30,Constants.EOS_ADDRESS_31};
    String[] NUMBER ={"2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
    private String tokenSubString;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        TextView textArray[]={tv_token2,tv_token3,tv_token4,tv_token5,tv_token6,tv_token7,tv_token8,tv_token9,tv_token10,tv_token11,tv_token12,tv_token13,tv_token14,tv_token15,tv_token16,tv_token17,tv_token18,tv_token19,tv_token20,tv_token21,tv_token22,tv_token23,tv_token24,tv_token25,tv_token26,tv_token27,tv_token28,tv_token29,tv_token30,tv_token31};
        TextView textRangeArray[]={tv_range2,tv_range3,tv_range4,tv_range5,tv_range6,tv_range7,tv_range8,tv_range9,tv_range10,tv_range11,tv_range12,tv_range13,tv_range14,tv_range15,tv_range16,tv_range17,tv_range18,tv_range19,tv_range20,tv_range21,tv_range22,tv_range23,tv_range24,tv_range25,tv_range26,tv_range27,tv_range28,tv_range29,tv_range30,tv_range31};

        for(int i=0;i<EOS_ADDRESS.length;i++){
            getTokenBalance(EOS_ADDRESS[i],textArray[i],NUMBER[i],EOS_ADDRESS_BALANCE[i],textRangeArray[i]);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");// HH:mm:ss
        Date date = new Date(System.currentTimeMillis());
        tv_time.setText("当前时间: "+simpleDateFormat.format(date));

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
                .subscribe(new MyRxSubscriber<TokenBean>(getApplicationContext(), "loading", false) {

                    @Override
                    protected void _onNext(TokenBean billInfoBean) {
//                        Log.e("222",billInfoBean.getResult());
                        String tokenBalance = billInfoBean.getResult();
//                        String tokenSubString = tokenBalance.substring(0,tokenBalance.length()-18);
                        if(!"0".equals(tokenBalance)){
                            tokenSubString = tokenBalance.substring(0,tokenBalance.length()-18);
                        }else {
                            tokenSubString = "0";
                        }


                        BigDecimal pre = new BigDecimal(balance_previous);
                        BigDecimal now = new BigDecimal(tokenSubString);

                        BigDecimal x = now.subtract(pre);

                        switch (x.compareTo(BigDecimal.valueOf(0))){
                            case 0:
                                tv_range2.setTextColor(getResources().getColor(R.color.black));
                                break;
                            case -1:
                                tv_range2.setTextColor(getResources().getColor(R.color.green));
                                break;
                            case 1:
                                tv_range2.setTextColor(getResources().getColor(R.color.red));
                                break;

                        }


                        String subAddress = address.substring(0,5);

                        tv.setText(number+": "+subAddress+"地址拥有EOS: "+tokenSubString);
                        tv.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(MainActivity.this,TransferHistroyActivity.class);
                                intent.putExtra("tokenAddress", address);
                                startActivity(intent);
                            }
                        });

                        tv_range2.setText("变动: "+x);
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

//    @OnClick(R.id.tv_time)
//    public void click(TextView tv_time){
//        Intent intent = new Intent(this,TransferHistroyActivity.class);
//        intent.putExtra("tokenAddress", Constants.EOS_ADDRESS_2);
//        startActivity(intent);
//    }
}
