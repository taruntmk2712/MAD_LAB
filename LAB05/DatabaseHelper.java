package com.example.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="department.db";
    public static final String TABLE_NAME="student_table";
    public static final String COL_1="ID";
    public static final String COL_2="NAME";
    public static final String COL_3="MARKS";
    SQLiteDatabase db;;
    public DatabaseHelper(Context context) {
        super(context,DATABASE_NAME , null, 1);
        db=this.getWritableDatabase();
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+ TABLE_NAME+""+"(ID INTEGER PRIMARY KEY AUTOINCREMENT,"+"NAME TEXT, MARKS INTEGER)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }
    public void insert_record(String name,int marks)
    {
        String query ="INSERT INTO student_table VALUES(null,'"+name+"',"+marks+");";
        db.execSQL(query);
    }
    public StringBuffer display_all_records(){
        StringBuffer buffer=new StringBuffer();
        Cursor c=db.rawQuery("SELECT * FROM student_table",null);
        if(c.getCount()==0){
            buffer.append("Error No records found");
            return buffer;
        }
        while(c.moveToNext()){
            buffer.append("ID: "+c.getString(0)+"\n");
            buffer.append("Name: "+c.getString(1)+"\n");
            buffer.append("Marks: "+c.getString(2)+"\n\n");
        }
        return buffer;
    }
    public void delete_record(String name)
    {
        String query="DELETE FROM student_table WHERE Name='"+name+"';";
        db.execSQL(query);
    }
    public void update_record(String name,int marks)
    {
        String query="UPDATE student_table SET Marks="+marks+" WHERE Name='"+name+"';";
        db.execSQL(query);
    }
}
