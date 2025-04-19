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

public class SecendActivity extends AppCompatActivity {

    private SharedPreferences sharedPref;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        EditText name=findViewById(R.id.name);
        EditText family=findViewById(R.id.family);
        EditText phone=findViewById(R.id.phone);
        EditText email=findViewById(R.id.email);

        Intent intent=new Intent(SecendActivity.this,SaveActivity.class);
        Intent intent1=new Intent(SecendActivity.this,ShowProfileActivity.class);


        Button btn_next = findViewById(R.id.btn_next);
        btn_next.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        intent.putExtra("NAME",name.getText().toString());
        intent.putExtra("FAMILY",family.getText().toString());
        intent.putExtra("PHONE",phone.getText().toString());
        intent.putExtra("EMAIL",email.getText().toString());
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
