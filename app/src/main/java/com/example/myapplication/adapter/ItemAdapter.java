package com.example.myapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.ItemClickListener;
import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.model.ItemModel;

import java.util.List;


// Bước 3.2
public class ItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<ItemModel> items;
    //MainActivity activity;
    ItemClickListener listener;

    public ItemAdapter(List<ItemModel> items) {
        this.items = items;
    }
//    public ItemAdapter(List<ItemModel> items, MainActivity activity) {
//        this.items = items;
//        this.activity = activity;
//    }
    public ItemAdapter(List<ItemModel> items, ItemClickListener listener ) {
        this.items = items;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // được gọi khi 1 viewholer mới được recyclerView tạo ra
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item,parent, false);
        return new ItemViewHoler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ItemModel item = items.get(position);

        ItemViewHoler viewHoler = (ItemViewHoler)holder;
        viewHoler.textView.setText(item.getTitle());
        viewHoler.imageView.setImageResource(item.getImangeResource());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    // bước 3.3
    class ItemViewHoler extends RecyclerView.ViewHolder{
        // khai báo widget
        TextView textView;
        ImageView imageView;



        public ItemViewHoler(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.text_view);
            imageView = itemView.findViewById(R.id.image_view);

            // xử lý sự kiện khi Items được nhấn - gọi OnItemClick trong mainActivity
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //activity.OnItemClick(getAdapterPosition());
                    listener.OnItemClick(getAdapterPosition());
                }
            });
            }
        }
}
