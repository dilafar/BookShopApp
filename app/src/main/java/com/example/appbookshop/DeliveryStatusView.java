package com.example.appbookshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.appbookshop.Adapter.DeliveryAdapter;
import com.example.appbookshop.Model.DeliveryModel;
import com.example.appbookshop.databinding.ActivityDeliveryStatusViewBinding;

import java.util.ArrayList;

public class DeliveryStatusView extends AppCompatActivity {
    ActivityDeliveryStatusViewBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDeliveryStatusViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DBHelper7 dbHelper7 = new DBHelper7(this);

        ArrayList<DeliveryModel> list = dbHelper7.getdeliveries();

        DeliveryAdapter adapter = new DeliveryAdapter(list,this);
        binding.recyclerView40.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recyclerView40.setLayoutManager(layoutManager);
    }
}