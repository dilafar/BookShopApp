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

public class MainAdapter3 extends RecyclerView.Adapter<MainAdapter3.viewholder>{

    ArrayList<MainModel> list3;
    Context context;

    public MainAdapter3(ArrayList<MainModel> list3, Context context) {
        this.list3 = list3;
        this.context = context;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_layout,parent,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        final MainModel model = list3.get(position);
        holder.image2.setImageResource(model.getPimage());
        holder.productName2.setText(model.getPname());
        holder.discription2.setText(model.getPdiscription());
        holder.price2.setText(model.getPrice());
        holder.AvQty2.setText(model.getPavqty());
        holder.offer2.setText(model.getOffer());

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
        return list3.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        ImageView image2;
        TextView productName2,discription2,AvQty2,price2,offer2;
        RelativeLayout parentlayout2;
        public viewholder(@NonNull View itemView) {
            super(itemView);

            image2=itemView.findViewById(R.id.image220);
            productName2 = itemView.findViewById(R.id.pdname400);
            discription2 = itemView.findViewById(R.id.pdiscription400);
            AvQty2 = itemView.findViewById(R.id.pavqty400);
            price2 = itemView.findViewById(R.id.pprice400);
            offer2= itemView.findViewById(R.id.poffer400);


        }
    }
}
