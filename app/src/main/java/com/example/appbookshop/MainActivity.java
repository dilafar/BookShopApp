package com.example.appbookshop;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.appbookshop.Adapter.MainAdapter;
import com.example.appbookshop.Model.MainModel;
import com.example.appbookshop.databinding.ActivityMainBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Toolbar toolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);




        DBHelper3 dbHelper= new DBHelper3(this);

        String cname=getIntent().getStringExtra("cname");


        ArrayList<MainModel> list = dbHelper.getData(cname);

        getSupportActionBar().setTitle(cname);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        MainAdapter adapter = new MainAdapter(list,this);
        binding.recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recyclerView.setLayoutManager(layoutManager);

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
                Intent intent = new Intent(MainActivity.this,UserLoginActivity.class);
                startActivity(intent);
                break;

            case R.id.orders:
                 startActivity(new Intent(MainActivity.this,OrdersActivity.class));
                 break;
        }
        return super.onOptionsItemSelected(item);
    }
}