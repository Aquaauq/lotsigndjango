package com.example.navigationview.ui.login;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
//数据创建
public class DatabaseHelper extends SQLiteOpenHelper {

    final static String DATABASENAME="test.db";

    public DatabaseHelper(Context context){
        super(context,DATABASENAME,null,1);
        // TODO Auto-generated constructor stub
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        //创建test表
        String sql = "CREATE TABLE test" + "(" + "isbn  TEXT NOT NULL,"
                + "date  TEXT," + "mood  TEXT," + "content  TEXT," + "picture  BLOB,"
                + "PRIMARY KEY (isbn)" + ");";
        db.execSQL(sql);
        //test表
        String add1 = "INSERT INTO test VALUES ('今日快乐', '2023-4-1', '开心',  '今天很开心', NULL);";
        String add2 = "INSERT INTO test VALUES ('今日伤心', '2023-4-2', '难过', '今天很难过', NULL);";
        String add3 = "INSERT INTO test VALUES ('今日一般', '2023-4-3', '一般', '今天很一般', NULL);";
        db.execSQL(add1);
        db.execSQL(add2);
        db.execSQL(add3);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub

    }

}