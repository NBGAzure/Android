package com.example.jc491164.converter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    // variable declaration
    Button btn_currency, btn_discount, setting_btn;
    String color_codes[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);





        color_codes = getResources().getStringArray(R.array.color_codes);

        // display currency button
        btn_currency = (Button) findViewById(R.id.button_currency);
        btn_currency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });


        // display discount calculator button
        btn_discount = (Button) findViewById(R.id.button_discount);
        btn_discount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
                startActivity(intent);
            }
        });

        // display seeting button
        setting_btn = (Button) findViewById(R.id.button_settings);
        setting_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), FourthActivity.class);
                startActivityForResult(intent,1);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        ConstraintLayout layout1;

        layout1 = (ConstraintLayout) findViewById(R.id.main_constraint_layout);

        if(requestCode == 1)
        {

            if (resultCode == Activity.RESULT_OK)
            {
                Bundle bundle = data.getExtras();
                if(bundle != null)
                {
                    int index = (int)bundle.get("index");
                    Log.i("code", color_codes[index]);
                    int color_code = Integer.parseInt(color_codes[index], 16);
                    Log.i("color code", Integer.toString(color_code));
                    layout1.setBackgroundColor(0xff000000 + color_code);

                }
            }

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
