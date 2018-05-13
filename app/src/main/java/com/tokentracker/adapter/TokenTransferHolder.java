package com.tokentracker.adapter;

import android.util.Log;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tokentracker.R;
import com.tokentracker.bean.TokenTransferBean;

import java.text.SimpleDateFormat;
import java.util.Date;

import cn.lemon.view.adapter.BaseViewHolder;


public class TokenTransferHolder extends BaseViewHolder<TokenTransferBean.Result> {

    private TextView tv_from;
    private TextView tv_to;
    private TextView tv_time;
    private TextView tv_balance;
    private TextView tv_status;
    private String ownerAddress = "";

    public TokenTransferHolder(ViewGroup parent, String address) {
        super(parent, R.layout.holder_token_transfer);
        ownerAddress= address;
    }

    @Override
    public void setData(final TokenTransferBean.Result object) {
        super.setData(object);
        String subFromAddress = object.getFrom().substring(0,5);
        tv_from.setText("From: "+subFromAddress);
        String subToAddress = object.getTo().substring(0,5);
        tv_to.setText("To: "+subToAddress);

        String value = object.getValue();
        String subValue ="";
        if(!"0".equals(value)){
            subValue = value.substring(0,value.length()-18);
        }else {
            subValue = "0";
        }

//        String valueSub = object.getValue().substring(0,object.getValue().length()-18);
        tv_balance.setText("数量: "+subValue);

        tv_time.setText(transForDate(Integer.valueOf(object.getTimeStamp())));

        if(ownerAddress.equals(subFromAddress)){
            //out
            tv_status.setText("OUT");
            tv_status.setBackgroundResource(R.drawable.biankuang_out);
        }else {
            //in
            tv_status.setText("IN");
            tv_status.setBackgroundResource(R.drawable.biankuang_in);
        }
    }

    @Override
    public void onInitializeView() {
        super.onInitializeView();
        tv_from = findViewById(R.id.tv_from);
        tv_to = findViewById(R.id.tv_to);
        tv_time = findViewById(R.id.tv_time);
        tv_balance = findViewById(R.id.tv_balance);
        tv_status = findViewById(R.id.tv_status);
    }

    @Override
    public void onItemViewClick(TokenTransferBean.Result object) {
        super.onItemViewClick(object);
        //点击事件
    }

    public static String transForDate(Integer ms){
        String str = "";
        if(ms!=null){
            long msl=(long)ms*1000;
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            if(ms!=null){
                try {
                    str=sdf.format(msl);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return str;
    }


}
