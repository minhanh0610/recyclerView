package com.example.myapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.model.ItemModel;

import java.util.List;

public class multiLayoutItemAdater extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<ItemModel> items;
    // phải tạp constructer
    public multiLayoutItemAdater(List<ItemModel> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType == 0) {
            View view = LayoutInflater.from(parent.getContext() ).inflate(R.layout.layout_item_left, parent, false);
            return new LeftViewHolder(view);
        }
        else{
            View view = LayoutInflater.from(parent.getContext() ).inflate(R.layout.layout_item_right, parent, false);
            return new RightViewHolder(view);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ItemModel item = items.get(position);
        if(items.get(position).isLeft()){
            ItemAdapter.ItemViewHoler viewHoler = (ItemAdapter.ItemViewHoler)holder;
            viewHoler.textView.setText(item.getTitle());
            viewHoler.imageView.setImageResource(item.getImangeResource());

        }
        else{
            ItemAdapter.ItemViewHoler viewHoler = (ItemAdapter.ItemViewHoler)holder;
            viewHoler.textView.setText(item.getTitle());
            viewHoler.imageView.setImageResource(item.getImangeResource());

        }

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    // cho biet 1 item co kieu view xác định là gì - sd tham số viewType trong OnCreateViewHolder
    public int getItemViewType(int position) {
        if(items.get(position).isLeft()) return 0;
        else return 1;

    }

    class LeftViewHolder extends RecyclerView.ViewHolder{

        TextView textView;
        ImageView imageView;

        public LeftViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_view);
            imageView = itemView.findViewById(R.id.image_view);
        }
    }

    class RightViewHolder extends RecyclerView.ViewHolder{

        TextView textView;
        ImageView imageView;

        public RightViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_view);
            imageView = itemView.findViewById(R.id.image_view);
        }
    }
}
