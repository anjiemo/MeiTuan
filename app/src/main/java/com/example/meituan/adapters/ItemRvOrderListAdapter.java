package com.example.meituan.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.meituan.R;
import com.example.meituan.beans.DishInfo;

import java.util.ArrayList;
import java.util.List;

public class ItemRvOrderListAdapter extends RecyclerView.Adapter<ItemRvOrderListAdapter.InnerHolder> {

    private List<DishInfo> objects = new ArrayList<>();
    private Context context;
    private LayoutInflater layoutInflater;

    public void setObjects(List<DishInfo> objects) {
        for (DishInfo dishInfo : objects) {
            //只有数量不为0时才添加到集合中
            if (dishInfo.getOrderNum() != 0) {
                this.objects.add(dishInfo);
            }
        }
        notifyDataSetChanged();
    }

    public void resetObjects() {
        this.objects = new ArrayList<>();
        notifyDataSetChanged();
    }

    public List<DishInfo> getObjects() {
        return objects;
    }

    public ItemRvOrderListAdapter(Context context) {
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
        View itemView = layoutInflater.inflate(R.layout.item_rv_order_list, parent, false);
        return new InnerHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull InnerHolder holder, int position) {
        DishInfo dishInfo = objects.get(position);
        ImageView ivIcon = holder.ivIcon;
        TextView tvDishName = holder.tvDishName;
        TextView tvDishNum = holder.tvDishNum;
        Glide.with(context).load(dishInfo.getDishLogo()).into(ivIcon);
        tvDishName.setText(String.format("%s %1s元/份", dishInfo.getDishName(), dishInfo.getDishPrice()));
        tvDishNum.setText(String.valueOf(dishInfo.getOrderNum()));
        ImageView ivLess = holder.ivLess;
        ImageView ivAdd = holder.ivAdd;
        ivLess.setOnClickListener(v -> {
            //判断减少之后数量是否大于0，如果小于等于0则移除该item
            int newOrderNum = dishInfo.getOrderNum() - 1;
            if (newOrderNum > 0) {
                dishInfo.setOrderNum(newOrderNum);
            } else {
                objects.remove(position);
            }
            notifyDataSetChanged();
        });
        ivAdd.setOnClickListener(v -> {
            //增加则直接增加即可
            dishInfo.setOrderNum(dishInfo.getOrderNum() + 1);
            notifyDataSetChanged();
        });
    }

    public class InnerHolder extends RecyclerView.ViewHolder {
        private ImageView ivIcon;
        private TextView tvDishName;
        private ImageView ivLess;
        private TextView tvDishNum;
        private ImageView ivAdd;

        public InnerHolder(@NonNull View view) {
            super(view);
            ivIcon = view.findViewById(R.id.ivIcon);
            tvDishName = view.findViewById(R.id.tvDishName);
            ivLess = view.findViewById(R.id.ivLess);
            tvDishNum = view.findViewById(R.id.tvDishNum);
            ivAdd = view.findViewById(R.id.ivAdd);
        }
    }
}
