package com.example.lenovo.lecture12;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.lenovo.lecture12.db.StudentTable;

/**
 * Created by lenovo on 7/12/2016.
 */
public class MyDbOpener extends SQLiteOpenHelper {

    public static final String DB_NAME="mydatabase";//create database seperate file h2bd file based db storage server db storage
    public static final int VERSION=1;
    private static MyDbOpener mMyDbOpener=null;

    public static SQLiteDatabase openReadable(Context c){
        if(mMyDbOpener==null){
            mMyDbOpener=new MyDbOpener(c);
        }
        return mMyDbOpener.getReadableDatabase();
    }
    public static SQLiteDatabase openWritable(Context c){
        if(mMyDbOpener==null){
            mMyDbOpener=new MyDbOpener(c);
        }
        return mMyDbOpener.getWritableDatabase();
    }
    public MyDbOpener(Context context){//, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DB_NAME, null, VERSION);
    }

//    public MyDbOpener(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
//        super(context, name, factory, version, errorHandler);
//        errorHandler.onCorruption();
//    } error fixing

    @Override
    public void onCreate(SQLiteDatabase db) {
        //StudentTable.Columns.ID
        db.execSQL(StudentTable.TABLE_CREATE_CMD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
