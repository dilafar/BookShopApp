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

import com.example.appbookshop.Adapter.CategoryviewAdapter2;
import com.example.appbookshop.Model.CategoryModel;
import com.example.appbookshop.databinding.ActivityCategoryView2Binding;

import java.util.ArrayList;

public class CategoryView2 extends AppCompatActivity {
    ActivityCategoryView2Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityCategoryView2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DBHelper4 dbHelper4 =new DBHelper4(this);
        ArrayList<CategoryModel> list =dbHelper4.getcategory();

        CategoryviewAdapter2 adapter2 = new CategoryviewAdapter2(list,this);
        binding.recyclerView25.setAdapter(adapter2);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recyclerView25.setLayoutManager(layoutManager);

        Toolbar toolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("View Product  ");
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
                Intent intent = new Intent(CategoryView2.this,UserLoginActivity.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}