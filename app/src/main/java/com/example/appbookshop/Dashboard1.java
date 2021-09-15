package com.example.appbookshop;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;

import com.example.appbookshop.databinding.ActivityDashboard1Binding;

public class Dashboard1 extends AppCompatActivity {
    ActivityDashboard1Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDashboard1Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        DBHelper6 dbHelper6=new DBHelper6(this);




        String name=getIntent().getStringExtra("name");

        Cursor cursor = dbHelper6.getData(name);

       // binding.IDtest.setText(cursor.getString(1));
        //binding.nameTest.setText(String.format("%d",cursor.getInt(0)));

    }
}