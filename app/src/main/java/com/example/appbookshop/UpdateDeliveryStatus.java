package com.example.appbookshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.appbookshop.databinding.ActivityUpdateDeliveryStatusBinding;

public class UpdateDeliveryStatus extends AppCompatActivity {
        ActivityUpdateDeliveryStatusBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityUpdateDeliveryStatusBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DBHelper7 dbHelper7=new DBHelper7(this);

        int id2 = getIntent().getIntExtra("id2",0);
        binding.did990.setText(String.format("%d",id2));

        RadioButton r1 = findViewById(R.id.radioButton990);
        RadioButton r2 = findViewById(R.id.radioButton2990);
        String radio;



        if(r1.isChecked()){
            radio = r1.getText().toString();
        }else{
            radio = r2.getText().toString();
        }

        binding.update990.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isupdated = dbHelper7.Updatedeliverystatus(
                        radio,
                        id2
                );
                if(isupdated){
                    Toast.makeText(UpdateDeliveryStatus.this, "Updated", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(UpdateDeliveryStatus.this, "Fail", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}