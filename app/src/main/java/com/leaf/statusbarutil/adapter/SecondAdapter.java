package com.leaf.statusbarutil.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.leaf.statusbarutil.R;

import java.util.List;

/**
 * @author：created by apple on 2019-11-26
 * email: 15622113269@163.com
 * Desc:
 */
public class SecondAdapter extends RecyclerView.Adapter<SecondAdapter.ViewHolder> {

    private List<Integer> mImgList;
    private Context mContext;

    public SecondAdapter(Context context, List<Integer> img) {
        this.mContext = context;
        this.mImgList = img;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_second, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.ivIcon.setImageResource(mImgList.get(i));
    }

    @Override
    public int getItemCount() {
        return mImgList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivIcon;

        ViewHolder(View itemView) {
            super(itemView);
            ivIcon = itemView.findViewById(R.id.iv_item_icon);
        }
    }
}
