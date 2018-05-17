package com.tokentracker;

import android.content.Intent;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.tokentracker.api.Api;
import com.tokentracker.api.HostType;
import com.tokentracker.base.BaseActivity;
import com.tokentracker.base.BaseApplication;
import com.tokentracker.base.rxjava.MyRxSubscriber;
import com.tokentracker.base.rxjava.RxSchedulers;
import com.tokentracker.bean.TokenBean;
import com.tokentracker.bean.TokenTableBean;
import com.tokentracker.db.TableConfig;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.OnClick;


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
    @BindView(R.id.tv_token32)
    TextView tv_token32;
    @BindView(R.id.tv_token33)
    TextView tv_token33;
    @BindView(R.id.tv_token34)
    TextView tv_token34;
    @BindView(R.id.tv_token35)
    TextView tv_token35;
    @BindView(R.id.tv_token36)
    TextView tv_token36;
    @BindView(R.id.tv_token37)
    TextView tv_token37;
    @BindView(R.id.tv_token38)
    TextView tv_token38;
    @BindView(R.id.tv_token39)
    TextView tv_token39;
    @BindView(R.id.tv_token40)
    TextView tv_token40;
    @BindView(R.id.tv_token41)
    TextView tv_token41;
    @BindView(R.id.tv_token42)
    TextView tv_token42;
    @BindView(R.id.tv_token43)
    TextView tv_token43;
    @BindView(R.id.tv_token44)
    TextView tv_token44;
    @BindView(R.id.tv_token45)
    TextView tv_token45;
    @BindView(R.id.tv_token46)
    TextView tv_token46;
    @BindView(R.id.tv_token47)
    TextView tv_token47;
    @BindView(R.id.tv_token48)
    TextView tv_token48;
    @BindView(R.id.tv_token49)
    TextView tv_token49;
    @BindView(R.id.tv_token50)
    TextView tv_token50;


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
    @BindView(R.id.tv_range32)
    TextView tv_range32;
    @BindView(R.id.tv_range33)
    TextView tv_range33;
    @BindView(R.id.tv_range34)
    TextView tv_range34;
    @BindView(R.id.tv_range35)
    TextView tv_range35;
    @BindView(R.id.tv_range36)
    TextView tv_range36;
    @BindView(R.id.tv_range37)
    TextView tv_range37;
    @BindView(R.id.tv_range38)
    TextView tv_range38;
    @BindView(R.id.tv_range39)
    TextView tv_range39;
    @BindView(R.id.tv_range40)
    TextView tv_range40;
    @BindView(R.id.tv_range41)
    TextView tv_range41;
    @BindView(R.id.tv_range42)
    TextView tv_range42;
    @BindView(R.id.tv_range43)
    TextView tv_range43;
    @BindView(R.id.tv_range44)
    TextView tv_range44;
    @BindView(R.id.tv_range45)
    TextView tv_range45;
    @BindView(R.id.tv_range46)
    TextView tv_range46;
    @BindView(R.id.tv_range47)
    TextView tv_range47;
    @BindView(R.id.tv_range48)
    TextView tv_range48;
    @BindView(R.id.tv_range49)
    TextView tv_range49;
    @BindView(R.id.tv_range50)
    TextView tv_range50;


    @BindView(R.id.tv_time)
    TextView tv_time;

    private String tokenSubString;
    public TextView[] textArray;
    public TextView[] textRangeArray;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        textArray = new TextView[]{tv_token2,tv_token3,tv_token4,tv_token5,tv_token6,tv_token7,tv_token8,tv_token9,tv_token10,
                                    tv_token11,tv_token12,tv_token13,tv_token14,tv_token15,tv_token16,tv_token17,tv_token18,tv_token19,tv_token20,
                                    tv_token21,tv_token22,tv_token23,tv_token24,tv_token25,tv_token26,tv_token27,tv_token28,tv_token29,tv_token30,
                                    tv_token31,tv_token32,tv_token33,tv_token34,tv_token35,tv_token36,tv_token37,tv_token38,tv_token39,tv_token40,
                                    tv_token41,tv_token42,tv_token43,tv_token44,tv_token45,tv_token46,tv_token47,tv_token48,tv_token49,tv_token50};
        textRangeArray = new TextView[]{tv_range2,tv_range3,tv_range4,tv_range5,tv_range6,tv_range7,tv_range8,tv_range9,tv_range10,
                                        tv_range11,tv_range12,tv_range13,tv_range14,tv_range15,tv_range16,tv_range17,tv_range18,tv_range19,tv_range20,
                                        tv_range21,tv_range22,tv_range23,tv_range24,tv_range25,tv_range26,tv_range27,tv_range28,tv_range29,tv_range30,
                                        tv_range31,tv_range32,tv_range33,tv_range34,tv_range35,tv_range36,tv_range37,tv_range38,tv_range39,tv_range40,
                                        tv_range41,tv_range42,tv_range43,tv_range44,tv_range45,tv_range46,tv_range47,tv_range48,tv_range49,tv_range50};


        for(int i=0;i<Constants.EOS_ADDRESS.length;i++){
            getTokenBalance(Constants.EOS_ADDRESS[i], textArray[i],Constants.NUMBER[i],Constants.EOS_ADDRESS_BALANCE[i], textRangeArray[i], false);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");// HH:mm:ss
        Date date = new Date(System.currentTimeMillis());
        tv_time.setText("当前时间: "+simpleDateFormat.format(date));

    }

    private void getTokenBalance(final String address, final TextView tv, final String number, final String balance_previous, final TextView tv_range2, final boolean isRecord) {
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
                                Intent intent = new Intent(MainActivity.this,TransferHistory2Activity.class);
                                intent.putExtra("tokenAddress", address);
                                startActivity(intent);
                            }
                        });

                        tv_range2.setText("变动: "+x);

                        if(isRecord){
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");// HH:mm:ss
                            Date date = new Date(System.currentTimeMillis());
                            TokenTableBean tokenTableBean = new TokenTableBean(subAddress,"" + simpleDateFormat.format(date),tokenSubString,"");
                            BaseApplication.tableOperate.insert(TableConfig.TABLE_Token,tokenTableBean);

                        }
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

    @OnClick(R.id.tv_time)
    public void click(TextView tv_time){
        for(int i=0;i<Constants.EOS_ADDRESS.length;i++){
            getTokenBalance(Constants.EOS_ADDRESS[i],textArray[i],Constants.NUMBER[i],Constants.EOS_ADDRESS_BALANCE[i],textRangeArray[i],true);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");// HH:mm:ss
        Date date = new Date(System.currentTimeMillis());
        tv_time.setText("当前时间: "+simpleDateFormat.format(date)+"  插入数据完成");
    }
}
