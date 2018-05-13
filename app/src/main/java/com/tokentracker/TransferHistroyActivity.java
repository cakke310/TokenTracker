package com.tokentracker;

import android.content.Intent;
import android.support.v4.util.ArrayMap;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.tokentracker.adapter.TokenTransferAdapter;
import com.tokentracker.api.Api;
import com.tokentracker.api.HostType;
import com.tokentracker.base.BaseActivity;
import com.tokentracker.base.rxjava.MyRxSubscriber;
import com.tokentracker.base.rxjava.RxSchedulers;
import com.tokentracker.bean.TokenBean;
import com.tokentracker.bean.TokenTransferBean;

import java.math.BigDecimal;

import butterknife.BindView;
import butterknife.OnClick;
import cn.lemon.view.RefreshRecyclerView;
import cn.lemon.view.adapter.Action;

public class TransferHistroyActivity extends BaseActivity {
    @BindView(R.id.recycler_view)
    RefreshRecyclerView recycler_view;
    private TokenTransferAdapter tokenTransferAdapter;

    private static final int CURRENT_PAGE = 1;
    private int mCurrentPage = CURRENT_PAGE;

    @BindView(R.id.myactionbar_head_back_layout)
    LinearLayout myactionbar_head_back_layout;
    @BindView(R.id.myactionbar_titles_tv)
    TextView myactionbar_titles_tv;

    @OnClick(R.id.myactionbar_head_back_layout)
    public void click(){
        TransferHistroyActivity.this.finish();
    }

    private boolean isFirst = true;

    @Override
    public int getLayoutId() {
        return R.layout.activity_transfer_history;
    }

    @Override
    public void initView() {
        Intent intent =getIntent();
        final String address = intent.getStringExtra("tokenAddress");

        Log.e("444",address);
        String subAddress = address.substring(0,5);
        myactionbar_titles_tv.setText("钱包地址: "+subAddress);

        getTokenTransferHistory(address,false);
        tokenTransferAdapter = new TokenTransferAdapter(this,subAddress);
        tokenTransferAdapter.clear();
        recycler_view.setSwipeRefreshColors(0xFF437845,0xFFE44F98,0xFF2FAC21);
        recycler_view.setLayoutManager(new LinearLayoutManager(this));
        recycler_view.setAdapter(tokenTransferAdapter);
        recycler_view.addRefreshAction(new Action() {
            @Override
            public void onAction() {
                // TODO：刷新数据
                mCurrentPage = CURRENT_PAGE;
                getTokenTransferHistory(address,true);

            }
        });

        recycler_view.setLoadMoreAction(new Action() {
            @Override
            public void onAction() {
                // TODO：加载更多
                ++mCurrentPage;

                getTokenTransferHistory(address,false);

            }
        });
        recycler_view.setLoadMoreErrorAction(new Action() {
            @Override
            public void onAction() {
                // TODO：加载更多错误，点击重新加载
            }
        });
    }


    private void getTokenTransferHistory(final String address,final boolean isRefresh) {
        ArrayMap<String, String> map = new ArrayMap<>();
        map.put("module", "account");
        map.put("action", "tokentx");
        map.put("contractaddress", "0x86fa049857e0209aa7d9e616f7eb3b3b78ecfdb0");
        map.put("address", address);
        map.put("page", ""+mCurrentPage);
        map.put("offset", "15");
        map.put("sort", "desc");
        map.put("apikey", Constants.API_KEY);

        Api.getDefault(HostType.EOS_URL).requestTokenTransferHistory(Api.getCacheControl(), map)
                .compose(RxSchedulers.<TokenTransferBean>io_main())
                .subscribe(new MyRxSubscriber<TokenTransferBean>(getApplicationContext(), "提交中", false) {

                    @Override
                    protected void _onNext(TokenTransferBean tokenTransferBean) {



                        if(isFirst){
                            recycler_view.getRecyclerView().scrollToPosition(0);
                            isFirst = false;
                        }
                        if(isRefresh){
                            tokenTransferAdapter.clear();
                            tokenTransferAdapter.addAll(tokenTransferBean.getResult());

                            recycler_view.dismissSwipeRefresh();
                            recycler_view.getRecyclerView().scrollToPosition(0);
                        }else {
                            tokenTransferAdapter.addAll(tokenTransferBean.getResult());
                            if(tokenTransferBean.getResult().size()<15){
                                recycler_view.showNoMore();
                            }


                        }
                    }

                    @Override
                    public void onCompleted() {
                        super.onCompleted();
                    }

                    @Override
                    protected void _onError(String message) {
                        Toast.makeText(TransferHistroyActivity.this,message,Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
