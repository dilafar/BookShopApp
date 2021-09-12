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

import com.example.appbookshop.databinding.ActivityOrderDetailsBinding;

public class OrderDetailsActivity extends AppCompatActivity {
            ActivityOrderDetailsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityOrderDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        final DBHelper helper = new DBHelper(this);




            final int image = getIntent().getIntExtra("image", 0);
            final String productname = getIntent().getStringExtra("productname");
            final String discription = getIntent().getStringExtra("discription");
            final int price = Integer.parseInt(getIntent().getStringExtra("price"));
            final int avqty = Integer.parseInt(getIntent().getStringExtra("avqty"));
            final int offer = Integer.parseInt(getIntent().getStringExtra("offer"));


            binding.orderdetailsimage2.setImageResource(image);
            binding.price22.setText(String.format("%d", price));
            binding.productname2.setText(productname);
            binding.avqty22.setText(String.format("%d", avqty));
            binding.offer22.setText(String.format("%d", offer));


            Toolbar toolbar = findViewById(R.id.toolbar1);
            setSupportActionBar(toolbar);


            binding.insertorderbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    boolean isInserted = helper.insertOrder(
                            productname,
                            image,
                            price,
                            Integer.parseInt(binding.qtybox.getText().toString()),
                            offer
                    );
                    if (isInserted) {
                        Toast.makeText(OrderDetailsActivity.this, "Data Success", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(OrderDetailsActivity.this, "Error", Toast.LENGTH_SHORT).show();

                    }
                }
            });


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