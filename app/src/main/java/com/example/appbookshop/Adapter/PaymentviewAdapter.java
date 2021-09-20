package com.example.appbookshop.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appbookshop.Model.DeliveryModel;
import com.example.appbookshop.Model.PaymentModel;
import com.example.appbookshop.R;

import java.util.ArrayList;

public class PaymentviewAdapter extends RecyclerView.Adapter<PaymentviewAdapter.viewholder>{
    ArrayList<PaymentModel> list;
    Context context;

    public PaymentviewAdapter(ArrayList<PaymentModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_payment_history_layout,parent,false);

        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        final PaymentModel model = list.get(position);
        holder.paydate.setText(model.getPaymentdate());
        holder.payid.setText(model.getPaymentID());
        holder.payamount.setText(model.getTotalpay());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        TextView paydate,payid,payamount;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            paydate=itemView.findViewById(R.id.paydate122);
            payid=itemView.findViewById(R.id.payid122);
            payamount=itemView.findViewById(R.id.payamount122);
        }
    }
}
