package com.example.appbookshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.appbookshop.Adapter.PaymentviewAdapter;
import com.example.appbookshop.Model.PaymentModel;
import com.example.appbookshop.databinding.ActivityViewPaymentHistoryBinding;

import java.util.ArrayList;

public class ViewPaymentHistoryActivity extends AppCompatActivity {
    ActivityViewPaymentHistoryBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityViewPaymentHistoryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        DBHelper8 dbHelper8 = new DBHelper8(this);

        ArrayList<PaymentModel> list = dbHelper8.getpaymenthistory();

        PaymentviewAdapter adapter = new PaymentviewAdapter(list,this);
        binding.recyclerView45.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recyclerView45.setLayoutManager(layoutManager);

    }
}