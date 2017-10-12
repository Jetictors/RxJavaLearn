package com.example.jetictors.rxjavalearn.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jetictors.rxjavalearn.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：侧边栏列表的适配器
 * 时间：2017/10/12  17:12
 * 作者：Jetictors
 * 版本  1.0.1
 */
public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {

    private List<String> mData;
    private Context mContext;
    private OnItemClickListener mListener;

    public MenuAdapter(Context mContext, List<String> mData) {
        this.mData = mData;
        this.mContext = mContext;
    }

    public MenuAdapter(Context mContext){
        this.mContext = mContext;

        mData = new ArrayList<>();
    }

    public void setData(List<String> newData){
        mData.clear();
        mData.addAll(newData);
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater mInflater = LayoutInflater.from(mContext);

        View view = mInflater.inflate(R.layout.item_menu,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTvTitle.setText(mData.get(position));

        setIcon(holder.mIvIcon,position);

        holder.itemView.setOnClickListener(view -> {
            if (null != mListener){
                mListener.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (mData != null && mData.size() > 0){
            return mData.size();
        }

        return 0;
    }

    private void setIcon(ImageView ivIcon,int position){
        switch (position){
            case 0:
                ivIcon.setImageResource(R.mipmap.ic_launcher_round);
                break;
            case 1:
                ivIcon.setImageResource(R.mipmap.ic_back);
                break;
            case 2:
                ivIcon.setImageResource(R.mipmap.ic_back);
                break;
            case 3:
                ivIcon.setImageResource(R.mipmap.ic_back);
                break;
            case 4:
                ivIcon.setImageResource(R.mipmap.ic_back);
                break;
            case 5:
                ivIcon.setImageResource(R.mipmap.ic_launcher_round);
                break;
            case 6:
                ivIcon.setImageResource(R.mipmap.ic_launcher_round);
                break;
            default:
                break;
        }
    }

    public void setOnItemClickListener(OnItemClickListener mListener){
        this.mListener = mListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView mIvIcon;
        private TextView mTvTitle;

        public ViewHolder(View itemView) {
            super(itemView);

            mIvIcon = itemView.findViewById(R.id.item_iv_icon);
            mTvTitle = itemView.findViewById(R.id.item_tv_title);
        }
    }

    public interface OnItemClickListener{

        /**
         * item 点击事件
         * @param position
         */
        void onItemClick(int position);
    }
}
