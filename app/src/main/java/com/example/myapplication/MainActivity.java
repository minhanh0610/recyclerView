package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.myapplication.adapter.ItemAdapter;
import com.example.myapplication.adapter.multiLayoutItemAdater;
import com.example.myapplication.model.ItemModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ItemClickListener{

    List<ItemModel> items;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        items = new ArrayList<>();

        for(int i = 1; i<= 9; i+=2){
            items.add(new ItemModel("item " + new String(String.valueOf(i)), R.drawable.gmail));
        }

        for(int i = 2; i<= 10; i+=2){
            items.add(new ItemModel("item " + new String(String.valueOf(i)), R.drawable.gmail, false));
        }


        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        // các item trong ds có size như nhau nên set fixed size là true;
        recyclerView.setHasFixedSize(true);

        // thiết lập layout manager
        // từ trên xuống dưới
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        // từ trái qua phải theo chiều ngang
        //RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        // dùng gridLayout
        //RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);

        recyclerView.setLayoutManager(layoutManager);

        //tạo adapter
       adapter = new ItemAdapter(items,this);
        //adapter = new multiLayoutItemAdater(items);
        recyclerView.setAdapter(adapter);

        // thiet lap itemAnimator
//        recyclerView.setItemAnimator(new DefaultItemAnimator());
//
//        findViewById(R.id.btn_add).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                items.add(new ItemModel("new items", R.drawable.gmail));
//                adapter.notifyItemInserted(items.size() - 1);
//            }
//        });
//
//        findViewById(R.id.btn_remove).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                items.remove(0);
//                adapter.notifyItemRemoved(0);
//            }
//        });
//        findViewById(R.id.btn_change).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                items.get(0).setTitle("change item 1");
//                adapter.notifyItemChanged(0);
//            }
//        });
   }
    @Override
    public void OnItemClick(int position){
        Log.v("tag", items.get(position).getTitle() + " is selected");

    }
}