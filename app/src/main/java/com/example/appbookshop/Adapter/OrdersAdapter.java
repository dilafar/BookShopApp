package com.example.appbookshop.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appbookshop.DBHelper;
import com.example.appbookshop.Model.OrdersModel;
import com.example.appbookshop.OrderDetailsActivity;
import com.example.appbookshop.R;
import com.example.appbookshop.UpdateOrderDetails;

import java.util.ArrayList;

public class OrdersAdapter extends RecyclerView.Adapter<OrdersAdapter.viewHolder>{
    ArrayList<OrdersModel> list;
    Context context;

    public OrdersAdapter(ArrayList<OrdersModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.order_sample,parent,false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
            final  OrdersModel model = list.get(position);
            holder.orderimage.setImageResource(model.getOrderimage());
            holder.ordername.setText(model.getOrdername());
            holder.ordernumber.setText(model.getOrdernumber());
            holder.price.setText(model.getPrice());
            holder.qty.setText(model.getQty());
            holder.offer.setText(model.getOffer());

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(context, UpdateOrderDetails.class);
                    intent.putExtra("id",Integer.parseInt(model.getOrdernumber()));

                    context.startActivity(intent);
                }
            });

            holder.remove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DBHelper helper = new DBHelper(context);

                    new AlertDialog.Builder(context)
                            .setTitle("Delete")
                            .setIcon(R.drawable.ic_warning_24)
                            .setMessage("Are you sure you want to delete ? ")
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    if(helper.deleteOrder(model.getOrdernumber())>0){
                                        Toast.makeText(context, "Deleted", Toast.LENGTH_SHORT).show();
                                        helper.getOrders();
                                    }else{
                                        Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    }).show();



                }
            });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView orderimage,remove;
        TextView ordername,ordernumber,price ,qty,offer;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            orderimage=itemView.findViewById(R.id.orderimage);
            ordername=itemView.findViewById(R.id.orderitemname);
            ordernumber=itemView.findViewById(R.id.ordernumber);
            price=itemView.findViewById(R.id.price2);
            qty=itemView.findViewById(R.id.orderqty);
            offer=itemView.findViewById(R.id.offerid);
            remove=itemView.findViewById(R.id.remove);
        }
    }
}
