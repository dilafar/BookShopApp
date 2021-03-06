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

import com.example.appbookshop.Adapter.MainAdapter2;
import com.example.appbookshop.Model.MainModel;
import com.example.appbookshop.databinding.ActivityAdminProductViewBinding;

import java.util.ArrayList;

public class AdminProductView extends AppCompatActivity {
        ActivityAdminProductViewBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityAdminProductViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        DBHelper3 dbHelper= new DBHelper3(this);
        ArrayList<MainModel> list2 = dbHelper.getItems();



        MainAdapter2 adapter2 = new MainAdapter2(list2,this);
        binding.recyclerView2.setAdapter(adapter2);
        LinearLayoutManager layoutManager =new LinearLayoutManager(this);
        binding.recyclerView2.setLayoutManager(layoutManager);

        binding.addFloat100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminProductView.this,CategoryView.class);
                startActivity(intent);
            }
        });


        Toolbar toolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("All Product  ");
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
                Intent intent = new Intent(AdminProductView.this,UserLoginActivity.class);
                startActivity(intent);
                break;


        }
        return super.onOptionsItemSelected(item);
    }
}