package com.cours.tlescope.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {
        public static final String _id = "id";
        public static final String NOM_USER= "nom";
        public static final String PRENOM_USER= "prenom";
        public static final String EMAIL_USER= "email";
        public static final String MDP_USER= "mdp";

        public static final String TABLE_USER_NAME= "Utilisateurs";
        public static final String TABLE_USER_CREATE=
                " CREATE TABLE " + TABLE_USER_NAME + "(" +
                        _id + " INTEGER PRIMARY KEY AUTOINCREMENT , " +
                        NOM_USER + " TEXT , " +
                        PRENOM_USER + " TEXT , " +
                        EMAIL_USER + " TEXT , " +
                        MDP_USER + " TEXT ) ; " ;

        public DatabaseHandler (Context context , String name, SQLiteDatabase.CursorFactory factory , int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(TABLE_USER_CREATE);
        }

        public static final String USER_TABLE_DROP= "DROP TABLE IF EXISTS " + TABLE_USER_NAME + ";" ;
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL(USER_TABLE_DROP);
            onCreate(db);
        }
}
