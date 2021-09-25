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

import com.example.appbookshop.databinding.ActivityAddCategoryBinding;

public class AddCategoryActivity extends AppCompatActivity {
        ActivityAddCategoryBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddCategoryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Add Category  ");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        DBHelper4 dbHelper4 = new DBHelper4(this);

        binding.submitcategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isinserted = dbHelper4.insertCategory(
                        binding.newCategory.getText().toString()
                );
                if(isinserted){
                    Toast.makeText(AddCategoryActivity.this,"Data Success",Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(AddCategoryActivity.this,"Error: ",Toast.LENGTH_SHORT).show();
                }
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
                Intent intent = new Intent(AddCategoryActivity.this,UserLoginActivity.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}