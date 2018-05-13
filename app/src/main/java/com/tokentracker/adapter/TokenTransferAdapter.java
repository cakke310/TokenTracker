package com.tokentracker.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.tokentracker.bean.TokenTransferBean;

import cn.lemon.view.adapter.BaseViewHolder;
import cn.lemon.view.adapter.RecyclerAdapter;


public class TokenTransferAdapter extends RecyclerAdapter<TokenTransferBean.Result> {
    private String address= "";

    public TokenTransferAdapter(Context context, String subAddress) {
        super(context);
        address = subAddress;
    }

    @Override
    public BaseViewHolder<TokenTransferBean.Result> onCreateBaseViewHolder(ViewGroup parent, int viewType) {
        return new TokenTransferHolder(parent,address);
    }
}