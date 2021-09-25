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

import com.example.appbookshop.DBHelper7;
import com.example.appbookshop.Model.DeliveryModel;
import com.example.appbookshop.R;
import com.example.appbookshop.UpdateDeliveryStatus;
import com.example.appbookshop.UpdateProductView;

import java.util.ArrayList;

public class DeliveryAdapter extends RecyclerView.Adapter<DeliveryAdapter.viewholder>{

    ArrayList<DeliveryModel> list;
    Context context;

    public DeliveryAdapter(ArrayList<DeliveryModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.delivery_status_view_layout,parent,false);

        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
         final DeliveryModel model = list.get(position);
         holder.deliveryID.setText(model.getDeliveryID());
         holder.name.setText(model.getName());
         holder.total.setText(model.getTotalpay());
         holder.status.setText(model.getStatus());

         holder.delete.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 DBHelper7 dbHelper7 = new DBHelper7(context);

                 new AlertDialog.Builder(context)
                         .setTitle("Delete")
                         .setIcon(R.drawable.ic_warning_24)
                         .setMessage("Are you sure you want to delete ? ")
                         .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                             @Override
                             public void onClick(DialogInterface dialogInterface, int i) {
                                 if(dbHelper7.deletedelivery(model.getDeliveryID())>0){
                                     Toast.makeText(context, "Deleted", Toast.LENGTH_SHORT).show();
                                     dbHelper7.getdeliveries();
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

         holder.update.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent = new Intent(context, UpdateDeliveryStatus.class);
                 intent.putExtra("id2",Integer.parseInt(model.getDeliveryID()));
                 context.startActivity(intent);
             }
         });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        ImageView delete,update;
        TextView deliveryID,name,total,status;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            delete=itemView.findViewById(R.id.ddelete277);
            update=itemView.findViewById(R.id.dupdate277);
            deliveryID=itemView.findViewById(R.id.paydate);
            name = itemView.findViewById(R.id.payid33);
            total = itemView.findViewById(R.id.dtotal27);
            status = itemView.findViewById(R.id.payamount33);
        }
    }
}
