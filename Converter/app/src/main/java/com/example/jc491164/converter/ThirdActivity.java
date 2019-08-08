package com.example.jc491164.converter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ThirdActivity extends AppCompatActivity {

    // variable declaration
    EditText eText_amount, eText_discount, eText_result;
    Button button_calculate;
    Double amount, discount, result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        button_calculate = (Button) findViewById(R.id.button_calculate);

        button_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                eText_amount = (EditText) findViewById(R.id.editText_amount);
                amount = Double.parseDouble(eText_amount.getText().toString());
                eText_discount = (EditText) findViewById(R.id.editText_discount);
                discount = Double.parseDouble(eText_discount.getText().toString());

                result = amount -((((double)discount)/100)* amount);


                eText_result = (EditText) findViewById(R.id.editText_result);
                eText_result.setText(Double.toString(result));

            }
        });






    }

}
