package com.tokentracker.adapter;

import android.view.ViewGroup;
import android.widget.TextView;

import com.tokentracker.R;
import com.tokentracker.bean.TokenTableBean;

import java.text.SimpleDateFormat;

import cn.lemon.view.adapter.BaseViewHolder;


public class TokenTransferTableHolder extends BaseViewHolder<TokenTableBean> {

    private TextView tv_token;
    private TextView tv_range;
    private TextView tv_date;

    public TokenTransferTableHolder(ViewGroup parent) {
        super(parent, R.layout.holder_token_transfer_table);
    }

    @Override
    public void setData(final TokenTableBean object) {
        super.setData(object);

        tv_token.setText(object.getTokenAddress());
        tv_range.setText("EOS数量: "+object.getTokenBalance());
        tv_date.setText(object.getTokenDate());

    }

    @Override
    public void onInitializeView() {
        super.onInitializeView();
        tv_token = findViewById(R.id.tv_token);
        tv_range = findViewById(R.id.tv_range);
        tv_date = findViewById(R.id.tv_date);
    }

    @Override
    public void onItemViewClick(TokenTableBean object) {
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
