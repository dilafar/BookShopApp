package com.example.appbookshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

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

        String pname = getIntent().getStringExtra("puname");

        ArrayList<PaymentModel> list = dbHelper8.getData(pname);


        PaymentviewAdapter adapter = new PaymentviewAdapter(list,this);
        binding.recyclerView45.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recyclerView45.setLayoutManager(layoutManager);

        Toolbar toolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Payment History  ");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.Logout:
                Toast.makeText(this,"Logout",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ViewPaymentHistoryActivity.this,UserLoginActivity.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}