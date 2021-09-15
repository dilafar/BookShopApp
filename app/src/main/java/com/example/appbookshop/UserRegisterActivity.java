package com.example.appbookshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.appbookshop.databinding.ActivityUserRegisterBinding;

public class UserRegisterActivity extends AppCompatActivity {
        ActivityUserRegisterBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityUserRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        DBHelper6 dbHelper6 = new DBHelper6(this);
        binding.register13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserRegisterActivity.this,UserLoginActivity.class);
                startActivity(intent);
            }
        });

        binding.login22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uname = binding.fullName.getText().toString();
                String email = binding.Email.getText().toString();
                String cnumber = binding.cnumber.getText().toString();
                String password = binding.uPassword2.getText().toString();
                String cpassword = binding.confirmpassword.getText().toString();
                Boolean res = dbHelper6.checkuser(uname,password);
                if(password.equals(cpassword)){
                    if(res==true){
                        Toast.makeText(UserRegisterActivity.this, "enter other uname", Toast.LENGTH_SHORT).show();

                    }else{
                        long val = dbHelper6.adduser(uname,email,cnumber,password);
                        if(val>0){
                            Toast.makeText(UserRegisterActivity.this, "Registered", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(UserRegisterActivity.this,UserLoginActivity.class);
                            startActivity(intent);

                        }else{
                            Toast.makeText(UserRegisterActivity.this,"Error",Toast.LENGTH_SHORT).show();
                        }
                    }


                }else{
                    Toast.makeText(UserRegisterActivity.this, "Password not match", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}