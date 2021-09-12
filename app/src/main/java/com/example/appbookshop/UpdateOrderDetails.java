package com.example.appbookshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.appbookshop.Model.OrdersModel;
import com.example.appbookshop.databinding.ActivityUpdateOrderDetailsBinding;

public class UpdateOrderDetails extends AppCompatActivity {
        ActivityUpdateOrderDetailsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityUpdateOrderDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        final DBHelper helper = new DBHelper(this);
         int id = getIntent().getIntExtra("id",0);
        Cursor cursor = helper.getOrderById(id);
        int image =cursor.getInt(2);

        binding.orderdetailsimage222.setImageResource(image);
        binding.price222.setText(String.format("%d",cursor.getInt(3)));
        binding.productname222.setText(cursor.getString(1));
        binding.offer222.setText(String.format("%d",cursor.getInt(5)));
        binding.qtybox222.setText(String.format("%d",cursor.getInt(4)));

        binding.updateorderbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isupdated =  helper.UpdateOrder(
                                binding.productname222.getText().toString(),
                                image,
                                Integer.parseInt(binding.price222.getText().toString()),
                                Integer.parseInt(binding.qtybox222.getText().toString()),
                                Integer.parseInt(binding.offer222.getText().toString()),
                                id
                        );
                if(isupdated){
                    Toast.makeText(UpdateOrderDetails.this,"Updated",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(UpdateOrderDetails.this,"Error",Toast.LENGTH_SHORT).show();

                }
            }
        });

        Toolbar toolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
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
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}