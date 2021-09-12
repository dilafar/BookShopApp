package com.example.appbookshop.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appbookshop.DBHelper3;
import com.example.appbookshop.Model.MainModel;
import com.example.appbookshop.R;
import com.example.appbookshop.UpdateCategoryCategory2;
import com.example.appbookshop.UpdateProductView;

import java.util.ArrayList;

public class MainAdapter2  extends  RecyclerView.Adapter<MainAdapter2.viewholder>{
    ArrayList<MainModel> list2;
    Context context;

    public MainAdapter2(ArrayList<MainModel> list2, Context context) {
        this.list2 = list2;
        this.context = context;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adminproductlayout,parent,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        final MainModel model = list2.get(position);
        holder.image2.setImageResource(model.getPimage());
        holder.productName2.setText(model.getPname());
        holder.discription2.setText(model.getPdiscription());
        holder.AvQty2.setText(model.getPavqty());
        holder.price2.setText(model.getPrice());
        holder.offer2.setText(model.getOffer());

        holder.update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UpdateProductView.class);
                intent.putExtra("id",Integer.parseInt(model.getItemID()));
                context.startActivity(intent);
            }
        });

        holder.remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper3 dbHelper3 = new DBHelper3(context);
                if(dbHelper3.deleteItem(model.getItemID())>0){
                    Toast.makeText(context, "Deleted", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();

                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return list2.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        ImageView image2,update,remove;
        TextView productName2,discription2,AvQty2,price2,offer2;
        RelativeLayout parentlayout2;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            image2=itemView.findViewById(R.id.image23);
            productName2=itemView.findViewById(R.id.categoryname23);
            discription2=itemView.findViewById(R.id.image_name23);
            AvQty2=itemView.findViewById(R.id.image_name43);
            price2=itemView.findViewById(R.id.image_name53);
            offer2=itemView.findViewById(R.id.image_name63);
            parentlayout2=itemView.findViewById(R.id.parent_layout2);
            update=itemView.findViewById(R.id.updateitem);
            remove=itemView.findViewById(R.id.deleteitem);

        }
    }
}
