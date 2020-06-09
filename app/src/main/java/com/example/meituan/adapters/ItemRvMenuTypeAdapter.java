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

import com.example.meituan.R;
import com.example.meituan.beans.MenuType;


public class ItemRvMenuTypeAdapter extends RecyclerView.Adapter<ItemRvMenuTypeAdapter.InnerHolder> {

    private List<MenuType> objects = new ArrayList<>();

    private Context context;
    private LayoutInflater layoutInflater;

    public ItemRvMenuTypeAdapter(Context context) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    public void setObjects(List<MenuType> objects) {
        this.objects = objects;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.item_rv_menu_type, parent, false);
        return new InnerHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull InnerHolder holder, int position) {
        MenuType menuType = objects.get(position);
        View itemView = holder.itemView;
        ImageView ivIcon = holder.ivIcon;
        TextView tvDescription = holder.tvDescription;
        ivIcon.setImageResource(menuType.getIcon());
        tvDescription.setText(menuType.getDescription());
        itemView.setOnClickListener(v -> {
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onClick(position);
            }
        });
    }

    public void setOnItemClickListener(onItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    private onItemClickListener mOnItemClickListener = null;
    public interface onItemClickListener{
        void onClick(int position);
    }

    @Override
    public int getItemCount() {
        return objects.size();
    }

    public class InnerHolder extends RecyclerView.ViewHolder {
        private View itemView;
        private ImageView ivIcon;
        private TextView tvDescription;
        public InnerHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            ivIcon = itemView.findViewById(R.id.ivIcon);
            tvDescription = itemView.findViewById(R.id.tvDescription);
        }
    }
}
