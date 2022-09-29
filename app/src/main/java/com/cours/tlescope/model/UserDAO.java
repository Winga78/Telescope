package com.cours.tlescope.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

public class UserDAO extends DAOBase{

    public static final String _id= "id";
    public static final String NOM= "nom";
    public static final String PRENOM= "prenom";
    public static final String EMAIL= "email";
    public static final String MDP= "mdp";
    public static final String TABLE_USER= "Utilisateurs";


    public static final String TABLE_USER_CREATE=
            " CREATE TABLE " + TABLE_USER + "(" +
                    _id + " INTEGER PRIMARY KEY AUTOINCREMENT , " +
                    NOM + " TEXT , " +
                    PRENOM + " TEXT , " +
                    EMAIL + " TEXT , " +
                    MDP + " TEXT ) ; " ;

    public static final String TABLE_DROP = "DROP TABLE IF EXISTS " + TABLE_USER + ";" ;

    public UserDAO(Context pContext) {
        super(pContext);
    }

    public void ajouter (User user ){

        ContentValues values = new ContentValues();
        values.put(UserDAO.NOM,user.getUserName());
        values.put(UserDAO.PRENOM,user.getUserPrenom());
        values.put(UserDAO.EMAIL,user.getUserMail());
        values.put(UserDAO.MDP,user.getUserMdp());
        mDb.insert(UserDAO.TABLE_USER,null,values);

    }

    public void supprimer ( long id) {
        mDb.delete(TABLE_USER,_id + " = ?" , new String[] {String.valueOf(id)} );
    }

    public void modifier ( User user){

    }

    public Cursor selectionner(User user){
        ContentValues value = new ContentValues();
        Cursor c = mDb.rawQuery(" select " + PRENOM + " from " + TABLE_USER+ " where email = ? and mdp = ? ", new String[] {user.userMail, user.userMdp} );

        return c;
    }

    public Cursor selectionnerVerif(User user){
        ContentValues value = new ContentValues();
        Cursor c = mDb.rawQuery(" select " + PRENOM + " from " + TABLE_USER+ " where email = ? ", new String[] {user.userMail} );

        return c;
    }


}
