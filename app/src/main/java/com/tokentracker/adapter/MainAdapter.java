package com.tokentracker.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tokentracker.Constants;
import com.tokentracker.R;
import com.tokentracker.TransferHistroyActivity;
import com.tokentracker.bean.TokenBean;

import java.math.BigDecimal;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by S on 2018/5/14.
 */

public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;

    private List<TokenBean> mDatas;

    public void setData(List<TokenBean> mDatas) {
        this.mDatas = mDatas;
    }

    public MainAdapter(Context context) {
        this.mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MainHolder(LayoutInflater.from(mContext).inflate(R.layout.item_main, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        if (null != mDatas && mDatas.size() > 0) {
            MainHolder mainHolder = (MainHolder) holder;
            String tokenSubString;
            TokenBean billInfoBean = mDatas.get(position);
            String tokenBalance = billInfoBean.getResult();
            if (!"0".equals(tokenBalance)) {
                tokenSubString = tokenBalance.substring(0, tokenBalance.length() - 18);
            } else {
                tokenSubString = "0";
            }

            BigDecimal pre = new BigDecimal(Constants.EOS_ADDRESS_BALANCE[position]);
            BigDecimal now = new BigDecimal(tokenSubString);

            BigDecimal x = now.subtract(pre);

            switch (x.compareTo(BigDecimal.valueOf(0))) {
                case 0:
                    mainHolder.tvRange.setTextColor(mContext.getResources().getColor(R.color.black));
                    break;
                case -1:
                    mainHolder.tvRange.setTextColor(mContext.getResources().getColor(R.color.green));
                    break;
                case 1:
                    mainHolder.tvRange.setTextColor(mContext.getResources().getColor(R.color.red));
                    break;

            }
            String subAddress = Constants.EOS_ADDRESS[position].substring(0, 5);
            mainHolder.tvToken.setText(Constants.NUMBER[position] + ": " + subAddress + "地址拥有EOS: " + tokenSubString);
            mainHolder.tvRange.setText("变动: " + x);
            mainHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext, TransferHistroyActivity.class);
                    intent.putExtra("tokenAddress", Constants.EOS_ADDRESS[position]);
                    mContext.startActivity(intent);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return null != mDatas && mDatas.size() > 0 ? mDatas.size() : 0;
    }

    public class MainHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_token)
        TextView tvToken;
        @BindView(R.id.tv_range)
        TextView tvRange;

        public MainHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
