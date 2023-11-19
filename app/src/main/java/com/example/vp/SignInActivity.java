package com.example.vp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class SignInActivity extends AppCompatActivity {
    private DatabaseHelper mDBHelper;
    private SQLiteDatabase mDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDBHelper = new DatabaseHelper(this);
        try {
            mDBHelper.updateDataBase();
        } catch (IOException mIOException) {
            throw new Error("UnableToUpdateDatabase");
        }
        mDb = mDBHelper.getWritableDatabase();
        ArrayList<HashMap<String, Object>> clients = new ArrayList<HashMap<String, Object>>();
        HashMap<String, Object> client;
        Cursor cursor = mDb.rawQuery("SELECT * FROM users", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            client = new HashMap<String, Object>();

            // Заполняем клиента
            client.put("name",  cursor.getString(0));
            client.put("login",  cursor.getString(1));
            client.put("password",  cursor.getString(2));
            client.put("isadmin",  cursor.getString(3));

            // Закидываем клиента в список клиентов
            clients.add(client);

            // Переходим к следующему клиенту
            cursor.moveToNext();
        }
        cursor.close();

        setContentView(R.layout.activity_sign_in);
    }
}