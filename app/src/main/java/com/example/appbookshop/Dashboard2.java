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

import com.example.appbookshop.databinding.ActivityDashboard2Binding;

public class Dashboard2 extends AppCompatActivity {
    ActivityDashboard2Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDashboard2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String name=getIntent().getStringExtra("name");

        binding.dashbtn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard2.this,HomePageActivity.class);
                startActivity(intent);
            }
        });

        binding.dashbtn13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard2.this,ViewuserAccountActivity.class);
                intent.putExtra("uname",name);
                startActivity(intent);
            }
        });

        binding.dashbtn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard2.this,CategoryView2.class);
                startActivity(intent);
            }
        });

        binding.dashbtn14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard2.this,OrdersActivity.class);
                startActivity(intent);
            }
        });

        binding.dashbtn15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard2.this,ViewPaymentHistoryActivity.class);
                intent.putExtra("puname",name);
                startActivity(intent);
            }
        });

        Toolbar toolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Blackwells  ");

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
                Intent intent = new Intent(Dashboard2.this,UserLoginActivity.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}