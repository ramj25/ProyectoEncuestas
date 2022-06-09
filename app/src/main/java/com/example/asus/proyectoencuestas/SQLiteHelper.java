package com.example.asus.proyectoencuestas;

import android.content.Context;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper {

    String CREAR="CREATE TABLE encuesta1(nombres TEXT,apellidos TEXT,edad INTEGER,nivel INTEGER, ubicacion TEXT)";


    public SQLiteHelper(Context context, String nombreBD, SQLiteDatabase.CursorFactory factory, int version){

        super(context,nombreBD,factory,version);

    }


    public long getNumeroFilas(String nombreTabla) {
        SQLiteDatabase db = this.getReadableDatabase();
        long count = DatabaseUtils.queryNumEntries(db, nombreTabla);
        db.close();
        return count;
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(CREAR);

        System.out.println("NUEVA BASE DE DATOS CREADA");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        System.out.println("ONupgrade de la base de datos DISPARADO!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

    }
}
