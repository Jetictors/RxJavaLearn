package com.example.jetictors.rxjavalearn.home.activity;

import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.jetictors.rxjavalearn.R;
import com.example.jetictors.rxjavalearn.base.BaseActivity;
import com.example.jetictors.rxjavalearn.home.adapter.MenuAdapter;
import com.example.jetictors.rxjavalearn.widgets.CircleTransform;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：首页
 * 时间：2017/10/11  13:26
 * 作者：Jetictors
 * 版本  1.0.1
 */
public class MainActivity extends BaseActivity{

    private ImageView mIvHeader;
    private RecyclerView mRv;
    private TextView mTvName;
    private TextView mTvProjectAddress;
    private MenuAdapter mAdapter;
    private List<String> mMenuData;
    private List<Fragment> mFragmentList;

    private String mHeaderUrl = "https://avatars1.githubusercontent.com/u/29166696?v=4&s=400&u=4fc9af785a16bf2a9472257eae537513167ec29f";

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        mIvHeader = $(R.id.menu_iv_header);
        mRv = $(R.id.menu_rv);
        mTvProjectAddress = $(R.id.menu_tv_project_address);
        mTvName = $(R.id.menu_tv_name);

        mTvName.setText("作者：  Jetictors");
        mTvProjectAddress.setText("https://github.com/Jetictors/RxJavaLearn");

        initRecyclerView();
    }

    private void initRecyclerView() {
        mRv.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new MenuAdapter(this);
        mRv.setAdapter(mAdapter);
        mRv.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

        if (mAdapter != null){
            mAdapter.setOnItemClickListener(position -> {
                Toast.makeText(this,mMenuData.get(position),Toast.LENGTH_LONG).show();
            });
        }
    }

    @Override
    public void initData() {

        // 加载头像
        Glide.with(this)
                .load(mHeaderUrl)
                .asBitmap()
                .error(R.mipmap.ic_launcher_round)
                .placeholder(R.mipmap.ic_launcher_round)
                .transform(new CircleTransform(this))
                .into(mIvHeader);

        getMenuData();

        getFragmentList();
    }

    public void getMenuData() {
        mMenuData = new ArrayList<>();

        String mStrMenu[] = new String[]{"xxx","xxx","xxx","xxx","xxx","xxx",};

        for (int i = 0 ; i < mStrMenu.length ; i++){
            mMenuData.add(i,mStrMenu[i]);
        }

        mAdapter.setData(mMenuData);
    }

    public void getFragmentList() {
        mFragmentList = new ArrayList<>();
    }
}
