package com.example.appbookshop.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appbookshop.Model.MainModel;
import com.example.appbookshop.OrderDetailsActivity;
import com.example.appbookshop.R;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.viewholder>{
    ArrayList<MainModel> list;
    Context context;

    public MainAdapter(ArrayList<MainModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout2,parent,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
            final MainModel model = list.get(position);
            holder.image.setImageResource(model.getPimage());
            holder.productName.setText(model.getPname());
            holder.discription.setText(model.getPdiscription());
            holder.price.setText(model.getPrice());
            holder.AvQty.setText(model.getPavqty());
            holder.offer.setText(model.getOffer());

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, OrderDetailsActivity.class);
                    intent.putExtra("image",model.getPimage());
                    intent.putExtra("productname",model.getPname());
                    intent.putExtra("discription",model.getPdiscription());
                    intent.putExtra("price",model.getPrice());
                    intent.putExtra("avqty",model.getPavqty());
                    intent.putExtra("offer",model.getOffer());

                    context.startActivity(intent);
                }
            });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView productName,discription,AvQty,price,offer;
        RelativeLayout parentlayout;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.image22);
            productName=itemView.findViewById(R.id.categoryname20);
            discription=itemView.findViewById(R.id.image_name2);
            AvQty=itemView.findViewById(R.id.image_name4);
            price=itemView.findViewById(R.id.image_name5);
            offer=itemView.findViewById(R.id.image_name6);
            parentlayout=itemView.findViewById(R.id.parent_layout);
        }
    }
}
