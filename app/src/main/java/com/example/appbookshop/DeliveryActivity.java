package com.example.appbookshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.appbookshop.Adapter.DeliveryAdapter;
import com.example.appbookshop.Model.DeliveryModel;
import com.example.appbookshop.databinding.ActivityDeliveryBinding;

import java.util.ArrayList;

public class DeliveryActivity extends AppCompatActivity {
        ActivityDeliveryBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDeliveryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DBHelper7 dbHelper7 = new DBHelper7(this);

         String pay = getIntent().getStringExtra("pay");
         binding.totalpay10.setText(pay);

        binding.pay500.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               boolean isinserted =  dbHelper7.insertdelivery(
                 binding.loginname10.getText().toString(),
                 binding.totalpay10.getText().toString(),
                 "pending",
                 binding.userphone10.getText().toString(),
                 binding.useraddress10.getText().toString()
                );
               if(isinserted){
                   Toast.makeText(DeliveryActivity.this,"Success",Toast.LENGTH_SHORT).show();
                   Intent intent = new Intent(DeliveryActivity.this,PaymentActivity.class);
                   intent.putExtra("lname",binding.loginname10.getText().toString());
                   intent.putExtra("pay",binding.totalpay10.getText().toString());
                   startActivity(intent);
               }else{
                   Toast.makeText(DeliveryActivity.this,"Fail",Toast.LENGTH_SHORT).show();

               }
            }
        });



        Toolbar toolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Delivery  ");
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
                Intent intent = new Intent(DeliveryActivity.this,UserLoginActivity.class);
                startActivity(intent);
                break;


        }
        return super.onOptionsItemSelected(item);
    }
}