package com.example.project;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ShowProfileActivity extends AppCompatActivity {

    private SharedPreferences sharedPref;
   // private   SharedPreferences.Editor editor;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showprofile);


    sharedPref=getApplicationContext().getSharedPreferences("INFO_sharedpreferences",Context.MODE_PRIVATE);

        TextView save_name=findViewById(R.id.save_name);
        save_name.setText(sharedPref.getString("name_key","nothing"));

        TextView save_family=findViewById(R.id.save_family);
        save_family.setText(sharedPref.getString("family_key","nothing"));

        TextView save_phone=findViewById(R.id.save_phone);
        save_phone.setText(sharedPref.getString("phone_key","nothing"));

        TextView save_email=findViewById(R.id.save_email);
        save_email.setText(sharedPref.getString("email_key","nothing"));


        TextView result=findViewById(R.id.text_result);

        EditText number1=findViewById(R.id.edit_number1);
        EditText number2=findViewById(R.id.edit_number2);

        Button addition=findViewById(R.id.btn_addition);
        Button subtraction=findViewById(R.id.btn_subtraction);
        Button multiplication=findViewById(R.id.btn_multiplication);
        Button division=findViewById(R.id.btn_division);

        addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult(number1, number2, result, "+");
            }
        });
        subtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult(number1, number2, result, "-");
            }
        });
        multiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult(number1, number2, result, "*");
            }
        });
        division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult(number1, number2, result, "/");
            }
        });




    }
    private void calculateResult(EditText num1Field, EditText num2Field, TextView resultView, String operator) {
        String num1Str = num1Field.getText().toString().trim();
        String num2Str = num2Field.getText().toString().trim();

        if (num1Str.isEmpty() || num2Str.isEmpty()) {
            resultView.setText("Please enter both numbers");
            return;
        }

        try {
            double num1 = Double.parseDouble(num1Str);
            double num2 = Double.parseDouble(num2Str);
            double result;

            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 == 0) {
                        resultView.setText("Cannot divide by zero");
                        return;
                    }
                    result = num1 / num2;
                    break;
                default:
                    resultView.setText("Invalid operation");
                    return;
            }

            resultView.setText("Result: " + result);

        } catch (NumberFormatException e) {
            resultView.setText("Invalid input");
        }
    }

}
