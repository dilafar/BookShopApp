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
import android.view.View;
import android.widget.Toast;

import com.example.appbookshop.Adapter.OrdersAdapter;
import com.example.appbookshop.Model.OrdersModel;
import com.example.appbookshop.databinding.ActivityOrdersBinding;


import java.util.ArrayList;

public class OrdersActivity extends AppCompatActivity {
   ActivityOrdersBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityOrdersBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        Toolbar toolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Cart  ");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        DBHelper helper = new DBHelper(this);
        ArrayList<OrdersModel> list = helper.getOrders();

        float total = helper.gettotal();
        binding.total500.setText(String.format("%.2f",total));

        OrdersAdapter adapter = new OrdersAdapter(list,this);
        binding.orderrecycleview.setAdapter(adapter);

        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        binding.orderrecycleview.setLayoutManager(layoutManager);

        binding.order500.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OrdersActivity.this,DeliveryActivity.class);
                intent.putExtra("pay",binding.total500.getText().toString());
                startActivity(intent);
            }
        });
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
                Intent intent = new Intent(OrdersActivity.this,UserLoginActivity.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}