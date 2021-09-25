package com.example.appbookshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.appbookshop.databinding.ActivityDashboard1Binding;

public class Dashboard1 extends AppCompatActivity {
    ActivityDashboard1Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDashboard1Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        DBHelper6 dbHelper6=new DBHelper6(this);

        binding.dashbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard1.this,HomePageActivity.class);
                startActivity(intent);
            }
        });

        binding.dashbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard1.this,CategoryView2.class);
                startActivity(intent);
            }
        });

        binding.dashbtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard1.this,CategoryView.class);
                startActivity(intent);
            }
        });

        binding.dashbtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard1.this,CategoryActivity.class);
                startActivity(intent);
            }
        });

        binding.dashbtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard1.this,DeliveryStatusView.class);
                startActivity(intent);
            }
        });




        String name=getIntent().getStringExtra("name");

        Cursor cursor = dbHelper6.getData(name);

       // binding.IDtest.setText(cursor.getString(1));
        //binding.nameTest.setText(String.format("%d",cursor.getInt(0)));

        Toolbar toolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Admin Dashboard  ");

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
                Intent intent = new Intent(Dashboard1.this,UserLoginActivity.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}