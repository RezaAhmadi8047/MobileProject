package com.example.project;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;



public class SaveActivity extends AppCompatActivity {

    private SharedPreferences sharedPref;
    private   SharedPreferences.Editor editor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);

        Intent getintent=getIntent();
        String name=getintent.getExtras().getString("NAME");
        String family=getintent.getExtras().getString("FAMILY");
        String phone=getintent.getExtras().getString("PHONE");
        String email=getintent.getExtras().getString("EMAIL");

        TextView text_name=findViewById(R.id.text_name);
        text_name.setText(name);

        TextView text_family=findViewById(R.id.text_family);
        text_family.setText(family);

        TextView text_phone=findViewById(R.id.text_phone);
        text_phone.setText(phone);

        TextView text_email=findViewById(R.id.text_email);
        text_email.setText(email);

        Intent intent=new Intent(SaveActivity.this,ShowProfileActivity.class);


        sharedPref=getApplicationContext().getSharedPreferences("INFO_sharedpreferences", Context.MODE_PRIVATE);
        editor=sharedPref.edit();

        Button btn_save=findViewById(R.id.btn_save);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editor.putString("name_key",name);
                editor.putString("family_key",family);
                editor.putString("phone_key",phone);
                editor.putString("email_key",email);
                editor.apply();

                startActivity(intent);

            }
        });

    }

}
