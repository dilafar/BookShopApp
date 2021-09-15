package com.example.appbookshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.appbookshop.databinding.ActivityDashboard2Binding;

public class Dashboard2 extends AppCompatActivity {
    ActivityDashboard2Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDashboard2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String name=getIntent().getStringExtra("name");

        binding.dashbtn13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard2.this,ViewuserAccountActivity.class);
                intent.putExtra("uname",name);
                startActivity(intent);
            }
        });

    }
}