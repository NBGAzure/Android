package com.example.jc491164.educationalquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn_twoXtwo, btn_threeXthree, btn_fourXfour, btn_sbmt, btn_score;

    TextView  lableName, lableWelcome;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //getting all design controls

        lableName = (TextView) findViewById(R.id.textName);
        btn_twoXtwo = (Button) findViewById(R.id.btn_2x2);
        btn_threeXthree = (Button) findViewById(R.id.btn_3x3);
        btn_fourXfour = (Button) findViewById(R.id.btn_4x4);
        btn_sbmt = (Button) findViewById(R.id.btn_submit);
        btn_score = (Button) findViewById(R.id.btn_score);
        lableWelcome = (TextView) findViewById(R.id.textWelcome);


        //setting visibility for controls
        lableWelcome.setVisibility(View.GONE);
        btn_twoXtwo.setVisibility(View.GONE);
        btn_threeXthree.setVisibility(View.GONE);
        btn_fourXfour.setVisibility(View.GONE);



        btn_sbmt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //validating if the username field is empty or not
                if(( lableName.getText()).toString().isEmpty())
                {
                    Toast.makeText(getBaseContext(), "Enter Name", Toast.LENGTH_SHORT).show();

                }else
                {
                    lableWelcome.setText("Welcome! " +( lableName.getText()).toString());

                    //setting visibility for controls
                    lableWelcome.setVisibility(View.VISIBLE);
                    lableName.setVisibility(View.GONE);
                    lableName.setVisibility(View.GONE);
                    btn_sbmt.setVisibility(View.GONE);
                    btn_twoXtwo.setVisibility(View.VISIBLE);
                    btn_threeXthree.setVisibility(View.VISIBLE);
                    btn_fourXfour.setVisibility(View.VISIBLE);
                }



            }
        });

        btn_twoXtwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SelectActivity.class);
                //passing values to corresponding activity
                intent.putExtra("level", "2");
                intent.putExtra("name",(lableName.getText()).toString());
                startActivity(intent);
            }
        });


        btn_threeXthree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SelectActivity.class);
                //passing values to corresponding activity
                intent.putExtra("name",(lableName.getText()).toString());
                intent.putExtra("level","3");
                startActivity(intent);
            }
        });


        btn_fourXfour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SelectActivity.class);
                //passing values to corresponding activity
                intent.putExtra("name",(lableName.getText()).toString());
                intent.putExtra("level","4");
                startActivity(intent);
            }
        });

        btn_score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FifthActivity.class);
                startActivity(intent);
            }
        });



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
