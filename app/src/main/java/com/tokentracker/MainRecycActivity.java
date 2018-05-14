package com.tokentracker;

import android.support.v4.util.ArrayMap;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.tokentracker.adapter.MainAdapter;
import com.tokentracker.api.Api;
import com.tokentracker.api.HostType;
import com.tokentracker.base.BaseActivity;
import com.tokentracker.base.rxjava.MyRxSubscriber;
import com.tokentracker.base.rxjava.RxSchedulers;
import com.tokentracker.bean.TokenBean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;


public class MainRecycActivity extends BaseActivity {

    @BindView(R.id.tv_time)
    TextView tv_time;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.SwipeRefreshLayout)
    SwipeRefreshLayout SwipeRefreshLayout;

    private List<TokenBean> mDatas = new ArrayList<>();
    private MainAdapter mMainAdapter;
    private int count = 0;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main_recyc;
    }

    @Override
    public void initView() {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        mMainAdapter = new MainAdapter(this);
        recyclerView.setAdapter(mMainAdapter);
        mMainAdapter.setData(mDatas);
        SwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                count = 0;
                mDatas.clear();
                getData(count);
                SwipeRefreshLayout.setRefreshing(false);
            }
        });
        getData(count);
        Log.d("TAG", "initView: " + mDatas.size());
    }

    private void getData(int count) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");// HH:mm:ss
        Date date = new Date(System.currentTimeMillis());
        tv_time.setText("当前时间: " + simpleDateFormat.format(date));

        if (count <= Constants.EOS_ADDRESS.length) {
            getTokenBalance(Constants.EOS_ADDRESS[count]);
        }
    }

    private void getTokenBalance(String address) {
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
                        count++;
                        mDatas.add(billInfoBean);
                        mMainAdapter.notifyDataSetChanged();
                        getData(count);
                    }

                    @Override
                    public void onCompleted() {
                        super.onCompleted();
                    }

                    @Override
                    protected void _onError(String message) {
                        Log.e("222", message);
                    }
                });
    }


}
