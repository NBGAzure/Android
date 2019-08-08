package com.example.jc491164.educationalquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectActivity extends AppCompatActivity {
    Bundle bundle;
    Button b1,b2,b3;
    String level;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        bundle = getIntent().getExtras();
        level = bundle.getString("level");
        selectImage(level);
    }

    public void selectImage(String level)
    {
        b1 =(Button) findViewById(R.id.btn0);
        b2 =(Button) findViewById(R.id.btn1);
        b3 =(Button) findViewById(R.id.btn2);

        //selecting image buttons based on user selection of game level
        if(level.equals("2"))
        {
            b1.setBackgroundResource(R.drawable.e);
            b2.setBackgroundResource(R.drawable.ee);
            b3.setBackgroundResource(R.drawable.eee);

            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(SelectActivity.this, SecondActivity.class);
                    //passing values to corresponding activity
                    intent.putExtra("name",bundle.getString("name"));
                    intent.putExtra("selectedImage","e");

                    startActivity(intent);
                }
            });

            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(SelectActivity.this, SecondActivity.class);
                    //passing values to corresponding activity
                    intent.putExtra("name",bundle.getString("name"));
                    intent.putExtra("selectedImage","ee");
                    startActivity(intent);
                }
            });

            b3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(SelectActivity.this, SecondActivity.class);
                    //passing values to corresponding activity
                    intent.putExtra("name",bundle.getString("name"));
                    intent.putExtra("selectedImage","eee");
                    startActivity(intent);
                }
            });
        }
        else if(level.equals("3"))
        {
            b1.setBackgroundResource(R.drawable.d);
            b2.setBackgroundResource(R.drawable.dd);
            b3.setBackgroundResource(R.drawable.ddd);

            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(SelectActivity.this, ThirdActivity.class);
                    //passing values to corresponding activity
                    intent.putExtra("name",bundle.getString("name"));
                    intent.putExtra("selectedImage","d");

                    startActivity(intent);
                }
            });

            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(SelectActivity.this, ThirdActivity.class);
                    //passing values to corresponding activity
                    intent.putExtra("name",bundle.getString("name"));
                    intent.putExtra("selectedImage","dd");
                    startActivity(intent);
                }
            });

            b3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(SelectActivity.this, ThirdActivity.class);
                    //passing values to corresponding activity
                    intent.putExtra("name",bundle.getString("name"));
                    intent.putExtra("selectedImage","ddd");
                    startActivity(intent);
                }
            });

        }
        else if(level.equals("4"))
        {
            b1.setBackgroundResource(R.drawable.c);
            b2.setBackgroundResource(R.drawable.cc);
            b3.setBackgroundResource(R.drawable.ccc);

            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(SelectActivity.this, FourthActivity.class);
                    intent.putExtra("name",bundle.getString("name"));
                    intent.putExtra("selectedImage","c");

                    startActivity(intent);
                }
            });

            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(SelectActivity.this, FourthActivity.class);
                    intent.putExtra("name",bundle.getString("name"));
                    intent.putExtra("selectedImage","cc");
                    startActivity(intent);
                }
            });

            b3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(SelectActivity.this, FourthActivity.class);
                    intent.putExtra("name",bundle.getString("name"));
                    intent.putExtra("selectedImage","ccc");
                    startActivity(intent);
                }
            });

        }
    }
}
