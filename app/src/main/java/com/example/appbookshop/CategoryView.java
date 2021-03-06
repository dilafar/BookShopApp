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

import com.example.appbookshop.Adapter.CategoryviewAdapter;
import com.example.appbookshop.Model.CategoryModel;
import com.example.appbookshop.databinding.ActivityCategoryViewBinding;

import java.util.ArrayList;

public class CategoryView extends AppCompatActivity {
        ActivityCategoryViewBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityCategoryViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DBHelper4 dbHelper4 =new DBHelper4(this);
        ArrayList<CategoryModel> list5= dbHelper4.getcategory();

        CategoryviewAdapter adapter=new CategoryviewAdapter(list5,this);
        binding.recyclerView20.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recyclerView20.setLayoutManager(layoutManager);

        Toolbar toolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Add Product  ");
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
                Intent intent = new Intent(CategoryView.this,UserLoginActivity.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}