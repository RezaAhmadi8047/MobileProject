package com.example.project;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
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

        UserProfile user = getIntent().getParcelableExtra("User_key");

        Intent intent=new Intent(SaveActivity.this,ShowProfileActivity.class);
        Intent back=new Intent(SaveActivity.this, SecondActivity.class);

        sharedPref=getApplicationContext().getSharedPreferences("INFO_sharedpreferences", Context.MODE_PRIVATE);
        editor=sharedPref.edit();

        Button btn_save=findViewById(R.id.btn_save);

        TextView text_name=findViewById(R.id.text_name);
        TextView text_family=findViewById(R.id.text_family);
        TextView text_phone=findViewById(R.id.text_phone);
        TextView text_email=findViewById(R.id.text_email);

        String name, family,phone,email;

        if (user != null) {
            // استفاده از اطلاعات
             name = user.getValueName();
             family = user.getValueFamily();
             phone = user.getValuePhone();
             email = user.getValueEmail();

             text_name.setText(name);
             text_family.setText(family);
             text_phone.setText(phone);
             text_email.setText(email);

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

}
