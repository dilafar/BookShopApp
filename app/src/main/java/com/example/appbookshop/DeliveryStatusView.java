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


        Toolbar toolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Delivery Status  ");
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
                Intent intent = new Intent(DeliveryStatusView.this,UserLoginActivity.class);
                startActivity(intent);
                break;


        }
        return super.onOptionsItemSelected(item);
    }


}