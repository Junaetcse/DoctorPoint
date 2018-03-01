package com.example.junae.doctorpointnew.favorite_doctor;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by junae on 12/4/2017.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "doctordb";
    public static final String TABLE_NAME= "doctorTable";
    public static final String ID = "id";
    public static final String KEY_ID = "idm";
    public static final String KEY_Name = "name";
    public static final String KEY_Qualification= "qualification";
    public static final String KEY_Designation = "designation";
    public static final String KEY_Organization = "organization";
    public static final String KEY_Chamber = "chamber";
    public static final String KEY_Visiting_Hours= "visiting_Hours";
    public static final String KEY_Location= "location";
    public static final String KEY_Phone = "phone";
    public static final String KEY_Email = "email";
 Context context;
    String sq = "CREATE TABLE " + TABLE_NAME + " (" + ID + " INTEGER PRIMARY KEY, " + KEY_ID + " TEXT, " + KEY_Name + " TEXT, " + KEY_Qualification + " TEXT, " + KEY_Designation + " TEXT, " + KEY_Organization + " TEXT, " + KEY_Chamber + " TEXT," +
            " " + KEY_Visiting_Hours + " TEXT, " + KEY_Location + " TEXT, " + KEY_Phone + " TEXT, " + KEY_Email + " TEXT)";



    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(sq);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void insertInformation(String id, String name, String qualification, String designation, String expertise, String organization, String chamber,
                                  String visiting_Hours, String location, String phone, String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id", id);
        values.put("name", name);
        values.put("qualification", qualification);
        values.put("designation", designation);
        values.put("organization", expertise);
        values.put("chamber", organization);
        values.put("visiting_Hours", chamber);
        values.put("location", visiting_Hours);
        values.put("id", location);
        values.put("phone", phone);
        values.put("email", email);


        db.insert(TABLE_NAME, null, values);
        db.close();
    }



    public List<SqliteModel> getInformations() {
        List<SqliteModel> modelList = new ArrayList<SqliteModel>();

        String query = "select * from " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {

            do {
                SqliteModel model = new SqliteModel();
                model.setId(cursor.getString(1));
               model.setName(cursor.getString(2));
                model.setQualification(cursor.getString(3));
                model.setDesignation(cursor.getString(4));
                model.setExpertise(cursor.getString(5));
                model.setOrganization(cursor.getString(6));
                model.setChamber(cursor.getString(7));
                model.setVisiting_Hours(cursor.getString(8));
                model.setLocation(cursor.getString(9));
                model.setPhone(cursor.getString(10));
                model.setEmail(cursor.getString(11));


                modelList.add(model);
            } while (cursor.moveToNext());
        }
        return modelList;
    }








}
