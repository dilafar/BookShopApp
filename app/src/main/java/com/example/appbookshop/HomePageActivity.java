package com.example.appbookshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.GridLayout;
import android.widget.Toast;

import com.example.appbookshop.Adapter.MainAdapter;
import com.example.appbookshop.Adapter.MainAdapter3;
import com.example.appbookshop.Model.MainModel;
import com.example.appbookshop.databinding.ActivityHomePageBinding;

import java.util.ArrayList;

public class HomePageActivity extends AppCompatActivity {

    ActivityHomePageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomePageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DBHelper3 dbHelper= new DBHelper3(this);

        ArrayList<MainModel> list2 = dbHelper.getItems();

        MainAdapter3 adapter = new MainAdapter3(list2,this);
        binding.recyclerView400.setAdapter(adapter);

        GridLayoutManager layoutManager = new GridLayoutManager(this,3);
        binding.recyclerView400.setLayoutManager(layoutManager);

        Toolbar toolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle(" Home ");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.Logout:
                Toast.makeText(this,"Logout",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(HomePageActivity.this,UserLoginActivity.class);
                startActivity(intent);
                break;

            case R.id.orders:
                startActivity(new Intent(HomePageActivity.this,OrdersActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}