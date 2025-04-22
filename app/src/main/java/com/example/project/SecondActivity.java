package com.example.project;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private SharedPreferences sharedPref;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        EditText name=findViewById(R.id.name);
        EditText family=findViewById(R.id.family);
        EditText phone=findViewById(R.id.phone);
        EditText email=findViewById(R.id.email);


        Intent intent=new Intent(SecondActivity.this,SaveActivity.class);
        Intent intent1=new Intent(SecondActivity.this,ShowProfileActivity.class);


        Button btn_next = findViewById(R.id.btn_next);
        btn_next.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        UserProfile user=new UserProfile(
                name.getText().toString()
                ,family.getText().toString()
                ,phone.getText().toString(),
                email.getText().toString());

        intent.putExtra("User_key",user);
        startActivity(intent);
    }
});

        sharedPref=getApplicationContext().getSharedPreferences("INFO_sharedpreferences", Context.MODE_PRIVATE);

        Button btn_log=findViewById(R.id.btn_log);
        btn_log.setText("continue with "+sharedPref.getString("name_key","nothing"));

        btn_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(intent1);
            }
        });



    }
}
