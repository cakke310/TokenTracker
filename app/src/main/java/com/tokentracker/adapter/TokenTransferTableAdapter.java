package com.tokentracker.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.tokentracker.bean.TokenTableBean;

import cn.lemon.view.adapter.BaseViewHolder;
import cn.lemon.view.adapter.RecyclerAdapter;

/**
 * Created by S on 2018/5/14.
 */

public class TokenTransferTableAdapter extends RecyclerAdapter<TokenTableBean> {

    public TokenTransferTableAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder<TokenTableBean> onCreateBaseViewHolder(ViewGroup parent, int viewType) {
        return new TokenTransferTableHolder(parent);
    }
}
