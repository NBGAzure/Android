package com.example.jc491164.educationalquiz;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

public class FifthActivity extends AppCompatActivity {
    DBHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);
        dbHelper = new DBHelper(this);
        ShowRecord();


        
    }


    public void ShowRecord() {
        Cursor cursor = dbHelper.getAllPlayers();
        String data = "";


        if (cursor != null) {
            cursor.moveToFirst();
            do {

                String username = cursor.getString(cursor.getColumnIndex(DBHelper.USERNAME_COL));
                String duration = cursor.getString(cursor.getColumnIndex(DBHelper.DURATION_COL));
                String level = cursor.getString(cursor.getColumnIndex(DBHelper.LEVEL_COL));
                String date = cursor.getString(cursor.getColumnIndex(DBHelper.DATE_COL));
                String iamge_name = cursor.getString(cursor.getColumnIndex(DBHelper.IMAGE_NAME_COL));

                data +=" "+ username + " " + duration + " " + level + " " + date + " " + iamge_name + "\n";

            } while (cursor.moveToNext());
        }
        ((TextView) findViewById(R.id.txt_score)).setText(data);


    }


}