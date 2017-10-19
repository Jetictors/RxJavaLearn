package com.example.jetictors.rxjavalearn.home.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.jetictors.rxjavalearn.R;
import com.example.jetictors.rxjavalearn.base.BaseActivity;
import com.example.jetictors.rxjavalearn.home.fragment.AboutUsFragment;
import com.example.jetictors.rxjavalearn.home.fragment.ProjectIllustrateFragment;
import com.example.jetictors.rxjavalearn.home.fragment.ReactiveXFragment;
import com.example.jetictors.rxjavalearn.home.fragment.RxBindingFragment;
import com.example.jetictors.rxjavalearn.home.fragment.RxBusFragment;
import com.example.jetictors.rxjavalearn.home.fragment.RxJavaFragment;
import com.example.jetictors.rxjavalearn.home.fragment.RxLifecycleFragment;
import com.example.jetictors.rxjavalearn.home.fragment.RxPremissionsFragment;
import com.example.jetictors.rxjavalearn.widgets.CircleTransform;
import com.example.jetictors.rxjavalearn.widgets.CommonItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 描述：首页
 * 时间：2017/10/11  13:26
 * 作者：Jetictors
 * 版本  1.0.1
 */
public class MainActivity extends BaseActivity {

    @BindView(R.id.menu_iv_header)
    ImageView menuIvHeader;
    @BindView(R.id.menu_rv)
    RecyclerView menuRv;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @BindView(R.id.toolbar_iv_back)
    ImageView toolbarIvBack;
    @BindView(R.id.toolbar_tv_title)
    TextView toolbarTvTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private BaseQuickAdapter<String, BaseViewHolder> mMenuAdapter;
    private List<String> mMenuData;
    private FragmentManager mFragmentManager;
    private FragmentTransaction mTransaction;

    private String mHeaderUrl = "https://avatars1.githubusercontent.com/u/29166696?v=4&s=400&u=4fc9af785a16bf2a9472257eae537513167ec29f";

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        initToolbar();
        initRecyclerView();

        mFragmentManager = getSupportFragmentManager();
    }

    private void initToolbar() {
        setSupportActionBar(toolbar);
        toolbarIvBack.setImageResource(R.mipmap.ic_menu);
        toolbarTvTitle.setText(getString(R.string.menu_item_1));
    }

    private void initRecyclerView() {
        menuRv.setLayoutManager(new LinearLayoutManager(this));
        menuRv.addItemDecoration(new CommonItemDecoration(this).setShowLastLine(true));
        mMenuAdapter = new BaseQuickAdapter<String, BaseViewHolder>(R.layout.item_menu) {
            @Override
            protected void convert(BaseViewHolder helper, String item) {
                helper.setText(R.id.item_tv_title, item);
                setIcon(helper.getView(R.id.item_iv_icon), helper.getLayoutPosition());
            }
        };
        menuRv.setAdapter(mMenuAdapter);

        if (mMenuAdapter != null) {
            mMenuAdapter.setOnItemClickListener((adapter, view, position) -> {
                launcher(position);
            });
        }
    }

    /**
     * 跳转fragment
     * @param position
     */
    private void launcher(int position) {
        switch (position) {
            case 0:
                setFragment(R.string.menu_item_1,ReactiveXFragment.getInstance());
                break;
            case 1:
                setFragment(R.string.menu_item_2, RxJavaFragment.getInstance());
                break;
            case 2:
                setFragment(R.string.menu_item_3, RxBusFragment.getInstance());
                break;
            case 3:
                setFragment(R.string.menu_item_4, RxBindingFragment.getInstance());
                break;
            case 4:
                setFragment(R.string.menu_item_5, RxPremissionsFragment.getInstance());
                break;
            case 5:
                setFragment(R.string.menu_item_6, RxLifecycleFragment.getInstance());
                break;
            case 6:
                setFragment(R.string.menu_item_7, ProjectIllustrateFragment.getInstance());
                break;
            case 7:
                setFragment(R.string.menu_item_8, AboutUsFragment.getInstance());
                break;
            default:
                break;
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
                .into(menuIvHeader);

        getMenuData();
    }

    public void getMenuData() {
        mMenuData = new ArrayList<>();

        String mStrMenu[] = new String[]{
                getString(R.string.menu_item_1), getString(R.string.menu_item_2),
                getString(R.string.menu_item_3), getString(R.string.menu_item_4),
                getString(R.string.menu_item_5), getString(R.string.menu_item_6),
                getString(R.string.menu_item_7), getString(R.string.menu_item_8),
        };

        for (int i = 0; i < mStrMenu.length; i++) {
            mMenuData.add(i, mStrMenu[i]);
        }

        mMenuAdapter.setNewData(mMenuData);

    }

    private void setIcon(ImageView ivIcon, int position) {
        if (null == ivIcon) {
            return;
        }

        switch (position) {
            case 0:
                ivIcon.setImageResource(R.mipmap.ic_menu_1);
                break;
            case 1:
                ivIcon.setImageResource(R.mipmap.ic_menu_2);
                break;
            case 2:
                ivIcon.setImageResource(R.mipmap.ic_menu_3);
                break;
            case 3:
                ivIcon.setImageResource(R.mipmap.ic_menu_4);
                break;
            case 4:
                ivIcon.setImageResource(R.mipmap.ic_menu_5);
                break;
            case 5:
                ivIcon.setImageResource(R.mipmap.ic_menu_6);
                break;
            case 6:
                ivIcon.setImageResource(R.mipmap.ic_about);
                break;
            case 7:
                ivIcon.setImageResource(R.mipmap.ic_us);
                break;
            default:
                ivIcon.setImageResource(R.mipmap.ic_launcher_round);
                break;
        }
    }

    private void setFragment(int titleId, Fragment fragment){
        mTransaction = mFragmentManager.beginTransaction();
        toolbarTvTitle.setText(getString(titleId));
        mTransaction.replace(R.id.main_content, fragment);
        mTransaction.commit();
        drawerLayout.closeDrawer(Gravity.LEFT);
    }

    @OnClick(
        R.id.toolbar_ll_left
    )
    public void eventClick(){
        if (drawerLayout.isDrawerOpen(Gravity.LEFT)){
            drawerLayout.closeDrawer(Gravity.LEFT);
            return;
        }

        drawerLayout.openDrawer(Gravity.LEFT);
    }
}
