package com.example.kuizo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbAdapter extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "KuizoDB";
    private static final String TABLE_USERS = "users";
    private static final String Col_Username = "username";
    private static final String Col_Password = "password";
    private static final String Col_NBQuestionsAnswered = "NbQuestions";
    private static final String Col_NBCorrectAnswers = "NbAnswers";


    public DbAdapter(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table users (username varchar(10) Primary key ,password varchar(10),NbQuestions Int ,NbAnswers Int);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        onCreate(db);
    }

    void addUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Col_Username, user.getUsername());
        values.put(Col_Password, user.getPassword());
        values.put(Col_NBQuestionsAnswered, user.getNbAnsweredQuestions());
        values.put(Col_NBCorrectAnswers,user.getNbCorrectAnswers());
        db.insert(TABLE_USERS, null, values);
        db.close();
    }

   User getUser(String id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_USERS, new String[] { Col_Username,
                        Col_Password,Col_NBQuestionsAnswered,Col_NBCorrectAnswers}, Col_Username + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        User user = new User(cursor.getString(0),
                cursor.getString(1), Integer.parseInt(cursor.getString(2)),Integer.parseInt(cursor.getString(3)));
        // return contact
        return user;
    }

    Boolean checkUserHasAccount(String user , String pass)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from users where username = '"+user+"' and password = '"+pass+"' ;",null);
        if(cursor.getCount()>0)
        {
            return true;
        }
        else
            return false;
    }


    Boolean checkUserExists(String user)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from users where username = '"+user+"';",null);
        if(cursor.getCount()>0)
        {
            return true;
        }
        else
            return false;
    }

    void updateStats(int score , int nbqs , String user)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues data=new ContentValues();
        data.put(Col_NBCorrectAnswers,score);
        data.put(Col_NBQuestionsAnswered,nbqs);
        db.update(TABLE_USERS, data, "username=" +"'"+user+"'", null);
    }




}
