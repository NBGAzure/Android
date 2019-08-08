package com.example.jc491164.converter;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SecondActivity extends AppCompatActivity {

    // variable declaration
    final String API_URL = "https://v3.exchangerate-api.com/bulk/2b2627216c2ea592c50fe1b0/";
    Spinner spinn_from, spinn_to;
    TextView text_from, text_to;
    Button btn_convert;
    double text_from_value, text_to_value;
    double result;

    // array of currency codes
    String[] viaLocales = { "JPY", "CNY","AUD", "INR", "SDG", "RON", "MKD", "MXN", "CAD",
            "ZAR",  "NOK", "ILS", "ISK", "SYP", "LYD", "UYU", "YER", "CSD",
            "EEK", "THB", "IDR", "LBP", "AED", "BOB", "QAR", "BHD", "HNL", "HRK",
            "COP", "ALL", "DKK", "MYR", "SEK", "RSD", "BGN", "DOP", "KRW", "LVL",
            "VEF", "CZK", "TND", "KWD", "VND", "JOD", "NZD", "PAB", "CLP", "PEN",
            "GBP", "DZD", "CHF", "RUB", "UAH", "ARS", "SAR", "EGP", "PYG",
            "TWD", "TRY", "BAM", "OMR", "SGD", "MAD", "BYR", "NIO", "HKD", "LTL",
            "SKK", "GTQ", "BRL", "EUR", "HUF", "IQD", "CRC", "PHP", "SVC", "PLN",
            "USD" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.i("msg","Here");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        text_from = (TextView) findViewById(R.id.editText_amount);


        text_from = (TextView) findViewById(R.id.editText_amount);


        setSpinner();
        btn_convert = (Button) findViewById(R.id.button_currency);
        btn_convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (text_from.getText().toString().isEmpty() || Double.parseDouble(text_from.getText().toString()) == 0 )
                {
                    Toast.makeText(getApplicationContext(), "Please enter some value", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    getRates();
                }
            }
        });






    }

    public boolean validate()
    {
        String txt = text_from.getText().toString();
        if(txt.isEmpty())
        {
            Toast.makeText(SecondActivity.this,
                    "Your Message", Toast.LENGTH_LONG).show();
            return false;

        }
        else
        {

            return true;
        }


    }

    public void setSpinner()
    {

        spinn_from = (Spinner) findViewById(R.id.spinner_from);
        spinn_to = (Spinner) findViewById(R.id.spinner_to);

        // store currency codes into arrayadapter and setting it to spinner
        ArrayAdapter currency_array = new ArrayAdapter(this,android.R.layout.simple_spinner_item, viaLocales);

        currency_array.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinn_from.setAdapter(currency_array);
        spinn_to.setAdapter(currency_array);
    }
    public void getRates()
    {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {

                final String temp = getRate();

                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        Log.i("JSON: ", temp);
                        try
                        {
                            JSONObject jsonObject = new JSONObject(temp);
                            JSONObject rateObj = jsonObject.getJSONObject("rates");
                            String textNew = spinn_to.getSelectedItem().toString();

                            //getting current currency rate for selected currency to convert to
                            text_to_value = rateObj.getDouble(textNew);

                            // getting value to convert from
                            text_from = (TextView) findViewById(R.id.editText_amount);
                            text_from_value = Double.parseDouble(text_from.getText().toString());

                            // calculating total for desired conversion
                            text_to = (TextView) findViewById(R.id.editText_discount);
                            result = text_to_value * text_from_value;
                            text_to.setText(Double.toString(result));


                        }
                        catch (org.json.JSONException e)
                        {
                            e.printStackTrace();
                        }
                    }
                });

            }
        };
        new Thread(runnable).start();
    }
    String getRate()
    {
        try
        {
            String text = spinn_from.getSelectedItem().toString();
            URL url = new URL(API_URL+text);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            final StringBuilder builder = new StringBuilder();
            try
            {
                BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                while (true)
                {
                    String line = reader.readLine();
                    if(line == null) break;
                    builder.append(line);

                }
                reader.close();
                return builder.toString();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            finally {
                urlConnection.disconnect();
            }

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;

    }



}
