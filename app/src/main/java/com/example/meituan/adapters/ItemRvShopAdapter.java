package com.example.meituan.adapters;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.meituan.R;
import com.example.meituan.beans.BusinessInformation;
import com.example.meituan.ui.ShopDetailActivity;
import com.example.meituan.utils.Constants;

public class ItemRvShopAdapter extends RecyclerView.Adapter<ItemRvShopAdapter.InnerHolder> {

    private List<BusinessInformation> objects = new ArrayList<>();

    private Context context;
    private LayoutInflater layoutInflater;

    public ItemRvShopAdapter(Context context) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    public void setObjects(List<BusinessInformation> objects) {
        this.objects = objects;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.item_rv_shop, parent, false);
        return new InnerHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull InnerHolder holder, int position) {
        BusinessInformation businessInformation = objects.get(position);
        View itemView = holder.itemView;
        ImageView ivIcon = holder.ivIcon;
        TextView tvName = holder.tvName;
        TextView tvAddress = holder.tvAddress;
        TextView tvSellNum = holder.tvSellNum;
        TextView tvStartPrice = holder.tvStartPrice;
        Glide.with(context).load(businessInformation.getLogo()).into(ivIcon);
        tvName.setText(businessInformation.getName());
        tvAddress.setText(businessInformation.getAddress());
        tvSellNum.setText(String.format("月销售 %s", businessInformation.getSellNum()));
        tvStartPrice.setText(String.format("起步价 %s ¥", businessInformation.getStartPrice()));
        itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, ShopDetailActivity.class);
            // 传递商家名称到下一个界面
            intent.putExtra(Constants.SHOP_NAME, businessInformation.getName());
            context.startActivity(intent);
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onClick(position);
            }
        });
    }

    public void setOnItemClickListener(onItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    private onItemClickListener mOnItemClickListener = null;

    public interface onItemClickListener {
        void onClick(int position);
    }

    @Override
    public int getItemCount() {
        return objects.size();
    }

    public class InnerHolder extends RecyclerView.ViewHolder {
        private ImageView ivIcon;
        private TextView tvName;
        private TextView tvAddress;
        private TextView tvSellNum;
        private TextView tvStartPrice;

        public InnerHolder(@NonNull View view) {
            super(view);
            ivIcon = (ImageView) view.findViewById(R.id.ivIcon);
            tvName = (TextView) view.findViewById(R.id.tvName);
            tvAddress = (TextView) view.findViewById(R.id.tvAddress);
            tvSellNum = (TextView) view.findViewById(R.id.tvSellNum);
            tvStartPrice = (TextView) view.findViewById(R.id.tvStartPrice);
        }
    }
}
