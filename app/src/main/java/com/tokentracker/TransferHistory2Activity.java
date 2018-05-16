package com.tokentracker;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tokentracker.adapter.TokenTransferTableAdapter;
import com.tokentracker.base.BaseActivity;
import com.tokentracker.base.BaseApplication;
import com.tokentracker.bean.TokenTableBean;
import com.tokentracker.db.TableConfig;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;
import cn.lemon.view.RefreshRecyclerView;
import cn.lemon.view.adapter.Action;

/**
 * Created by Riven on 2018/5/16.
 */

public class TransferHistory2Activity extends BaseActivity {
    @BindView(R.id.myactionbar_head_back_layout)
    LinearLayout myactionbar_head_back_layout;
    @BindView(R.id.myactionbar_titles_tv)
    TextView myactionbar_titles_tv;
    @BindView(R.id.recycler_view)
    RefreshRecyclerView recycler_view;
    public ArrayList<TokenTableBean> list;

    @OnClick(R.id.myactionbar_head_back_layout)
    public void click(){
        TransferHistory2Activity.this.finish();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_transfer_history_two;
    }

    @Override
    public void initView() {
        TokenTransferTableAdapter tokenTransferTableAdapter = new TokenTransferTableAdapter(this);
        Intent intent =getIntent();
        final String address = intent.getStringExtra("tokenAddress");

        String subAddress = address.substring(0,5);
        myactionbar_titles_tv.setText("钱包地址: "+subAddress);

        list = BaseApplication.tableOperate.query(TableConfig.TABLE_Token, TableConfig.Customer.TOKEN_ADDRESS, subAddress);

        for(int i = 0; i< list.size(); i++){
            int i1 = Integer.parseInt(list.get(i).getTokenBalance());
            if(i<list.size()-1){
                int i2 = Integer.parseInt(list.get(i+1).getTokenBalance());
                list.get(i+1).setTokenChange(i1-i2+"");
            }

        }



        tokenTransferTableAdapter.addAll(list);
        recycler_view.setLayoutManager(new LinearLayoutManager(this));
        recycler_view.setAdapter(tokenTransferTableAdapter);
        recycler_view.dismissSwipeRefresh();
        recycler_view.addRefreshAction(new Action() {
            @Override
            public void onAction() {

            }
        });

        recycler_view.setLoadMoreAction(new Action() {
            @Override
            public void onAction() {
                recycler_view.dismissSwipeRefresh();
            }
        });
        recycler_view.setLoadMoreErrorAction(new Action() {
            @Override
            public void onAction() {
                // TODO：加载更多错误，点击重新加载
            }
        });

    }
}
