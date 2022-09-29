package com.cours.tlescope.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public abstract class DAOBase {
    protected final static int VERSION = 1;
    protected final static String NOM = "database.db";

    protected SQLiteDatabase mDb = null ;
    protected DatabaseHandler mHandler = null;

    public DAOBase(Context pContext){
        this.mHandler = new DatabaseHandler(pContext,NOM,null,VERSION);
    }

    public SQLiteDatabase open(){
        mDb = mHandler.getWritableDatabase();
        return mDb;
    }
    public SQLiteDatabase open1(){
        mDb= mHandler.getReadableDatabase();
        return mDb;
    }

    public void close (){
        mDb.close();
    }

    public  SQLiteDatabase getmDb(){
        return  mDb;
    }
}
