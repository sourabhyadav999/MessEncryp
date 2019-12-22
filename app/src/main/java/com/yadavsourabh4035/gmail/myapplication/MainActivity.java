package com.yadavsourabh4035.gmail.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private Button encrypt,decrypt,logout;
    private UserDetailDatabaseHelper userDetailDatabaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userDetailDatabaseHelper=new UserDetailDatabaseHelper(getApplicationContext());
        encrypt=findViewById(R.id.encrypt);
        decrypt=findViewById(R.id.decrypt);
        logout=findViewById(R.id.logout);
        encrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Encrypt.class));
            }
        });
        decrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Decrypt.class));
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedpreferences = Objects.requireNonNull(getApplicationContext()).getSharedPreferences("LoginCredentials", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.clear();
                editor.apply();



                userDetailDatabaseHelper.removeAll();

                System.out.println("Logged Out Successfully");
                Intent in = new Intent(getApplicationContext(),LoginScreen.class);
                startActivity(in);
            }
        });
    }
}
