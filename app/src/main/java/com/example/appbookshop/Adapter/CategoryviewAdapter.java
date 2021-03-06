package com.example.appbookshop.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appbookshop.AddProducts2;
import com.example.appbookshop.Model.CategoryModel;
import com.example.appbookshop.R;

import java.util.ArrayList;

public class CategoryviewAdapter extends RecyclerView.Adapter<CategoryviewAdapter.viewholder>{

    ArrayList<CategoryModel> list3;
    Context context;

    public CategoryviewAdapter(ArrayList<CategoryModel> list3, Context context) {
        this.list3 = list3;
        this.context = context;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.categoryviewlayout,parent,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
                final CategoryModel model=list3.get(position);
                holder.categoryname10.setText(model.getCategoryname());

                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(context, AddProducts2.class);
                        intent.putExtra("cname2",model.getCategoryname());
                        context.startActivity(intent);
                    }
                });
    }

    @Override
    public int getItemCount() {
        return list3.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        TextView categoryname10;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            categoryname10=itemView.findViewById(R.id.categoryname10);
        }
    }
}
