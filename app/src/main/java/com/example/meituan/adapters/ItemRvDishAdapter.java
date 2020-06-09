package com.example.meituan.adapters;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.meituan.R;
import com.example.meituan.beans.DishInfo;

public class ItemRvDishAdapter extends RecyclerView.Adapter<ItemRvDishAdapter.InnerHolder> {

    private List<DishInfo> objects = new ArrayList<>();

    private Context context;
    private LayoutInflater layoutInflater;

    public void setObjects(List<DishInfo> objects) {
        this.objects = objects;
        notifyDataSetChanged();
    }

    public ItemRvDishAdapter(Context context) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return objects.size();
    }

    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.item_rv_dish, parent, false);
        return new InnerHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull InnerHolder holder, int position) {
        DishInfo dishInfo = objects.get(position);
        ImageView ivIcon = holder.ivIcon;
        TextView tvDishName = holder.tvDishName;
        TextView tvStarNum = holder.tvStarNum;
        TextView tvPrice = holder.tvPrice;
        ImageView ivAddBuyCar = holder.ivAddBuyCar;
        ivAddBuyCar.setOnClickListener(v -> {
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onClick(position);
            }
        });
        Glide.with(context).load(dishInfo.getDishLogo()).into(ivIcon);
        tvDishName.setText(dishInfo.getDishName());
        tvStarNum.setText(String.valueOf(dishInfo.getStarNum()));
        tvPrice.setText(String.format("价格：%s ¥", dishInfo.getDishPrice()));
    }

    public void setOnItemClickListener(onItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    private onItemClickListener mOnItemClickListener = null;
    public interface onItemClickListener{
        void onClick(int position);
    }

    public class InnerHolder extends RecyclerView.ViewHolder {
        private ImageView ivIcon;
        private TextView tvDishName;
        private TextView tvStarNum;
        private TextView tvPrice;
        private ImageView ivAddBuyCar;

        public InnerHolder(@NonNull View view) {
            super(view);
            ivIcon = view.findViewById(R.id.ivIcon);
            tvDishName = view.findViewById(R.id.tvDishName);
            tvStarNum = view.findViewById(R.id.tvStarNum);
            tvPrice = view.findViewById(R.id.tvPrice);
            ivAddBuyCar = view.findViewById(R.id.ivAddBuyCar);
        }
    }
}
