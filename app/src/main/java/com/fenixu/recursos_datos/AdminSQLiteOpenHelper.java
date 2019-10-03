package com.fenixu.recursos_datos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper{


    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("create table materias(idMateria int primary key, titulo varchar, porcentaje int, notaActual float, notaNecesaria float, creditos int)");
        db.execSQL("create table notas(idNota int primary key, nota int, porcentaje int, idMateria int)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }
}
