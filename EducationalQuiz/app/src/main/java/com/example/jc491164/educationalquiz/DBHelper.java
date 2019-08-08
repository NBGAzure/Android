package com.example.jc491164.educationalquiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



/**
 * Created by jc491164 on 25/01/2019.
 */

public class DBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 5;
    private static final String DATABASE_NAME ="vicky_puzzle.db";
    static final String TABLE_NAME = "users";
    static final String ID_COL = "_id";
    static final String USERNAME_COL = "username";
    static final String LEVEL_COL = "level";
    static final String DURATION_COL = "score";
    static final String DATE_COL = "date";
    static final String IMAGE_NAME_COL = "image";


    public DBHelper(Context context){
        super(context,DATABASE_NAME, null, DATABASE_VERSION );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_table = "create table " + TABLE_NAME
                + "("
                + ID_COL + " integer primary key autoincrement,"
                + USERNAME_COL + " text default 'unknown',"
                + DURATION_COL + " integer default 0,"
                + LEVEL_COL + " integer default 1," //Level = 1 or 2 or 3 only
                + DATE_COL + " timestamp default CURRENT_TIMESTAMP,"
                + IMAGE_NAME_COL + " text default 'c'"
                + ")";
        db.execSQL(create_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " +  TABLE_NAME);
        onCreate(db);
    }

    public boolean insertPlayer(String usr, int duration, int level, String image_name){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(USERNAME_COL, usr);
        values.put(DURATION_COL, duration);
        values.put(LEVEL_COL, level);
        values.put(IMAGE_NAME_COL, image_name);

        db.insert(TABLE_NAME, null, values);
        return true;
    }

    public Cursor getPlayer(String usr){
        SQLiteDatabase db = this.getReadableDatabase();
        String sqlStr = "select * from " + TABLE_NAME + " where "
                + USERNAME_COL + " = " + "'" + usr + "'"
                + " order by "
                + ID_COL + " DESC";
        Cursor cursor = db.rawQuery(sqlStr, null);
        return cursor;
    }

    public boolean updatePlayer(String usr, int score){
        SQLiteDatabase db = this.getWritableDatabase();
        if(getPlayer(usr) == null){
            return false;
        }
        ContentValues values = new ContentValues();
        values.put(DURATION_COL, score);
        db.update(TABLE_NAME, values, USERNAME_COL + " = ?", new String[]{usr});
        return true;
    }



    public Cursor getAllPlayers() {
        SQLiteDatabase db = this.getReadableDatabase();

//        String deleteRows = "delete from " + TABLE_NAME;
//        db.execSQL(deleteRows);

        String sqlstr = "select * from " + TABLE_NAME
                + " order by " + DURATION_COL + " ASC,"
                + USERNAME_COL + " ASC";
        return db.rawQuery(sqlstr, null);
    }
}
