package com.example.lenovo.lecture12;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.lenovo.lecture12.db.StudentTable;
import com.example.lenovo.lecture12.models.Students;

public class MainActivity extends AppCompatActivity {
public static final String TAG="mainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//MyDbOpener dbOpener=new MyDbOpener(this);
//
//        SQLiteDatabase myDb=new MyDbOpener(this).getWritableDatabase();

        SQLiteDatabase myDb=MyDbOpener.openWritable(this);
       // myDb.execSQL("INSERT INTO students");
        Students students=new Students(10,"john",5,11);
        ContentValues values=new ContentValues();
        values.put(StudentTable.Columns.ID,students.getId());
        values.put(StudentTable.Columns.NAME,students.getName());
        values.put(StudentTable.Columns.AGE,students.getAge());
        values.put(StudentTable.Columns.CLASS,students.getStudentClass());

        myDb.insert(StudentTable.TABLE_NAME,null,values);
        //inset into table--empty row
        //no empty row in SQLite
        String[] projection={
                StudentTable.Columns.ID,
                StudentTable.Columns.NAME
        };
        Cursor c=myDb.query(
                StudentTable.TABLE_NAME,
                projection,
                null, null, null, null,
                null

        );
        String selection=StudentTable.Columns.ID+"=?";
//        String[] args={String.valueOf(StudentTable.Columns.ID)};
        String[] args={"2"};
        myDb.delete(StudentTable.TABLE_NAME,selection,args);

        Log.d(TAG, "ONcREATE:cursor count" + c.getCount());
        while (c.moveToNext()) {
            int stuId = c.getInt(c.getColumnIndex(StudentTable.Columns.ID));//getcolindexorthrow--method
            String stuName = c.getString(c.getColumnIndex(StudentTable.Columns.NAME));
            Log.d(TAG, "STUDENT" + stuId + "\t" + stuName);
        }
    }
//retrofit //gson

}
