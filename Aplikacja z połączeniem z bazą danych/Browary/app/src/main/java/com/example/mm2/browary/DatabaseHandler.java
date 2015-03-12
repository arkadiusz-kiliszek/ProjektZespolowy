package com.example.mm2.browary;

import java.util.ArrayList;
import java.util.List;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;
/**
 * Created by Adrian on 2015-03-11.
 */
public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "Baza";

    private static final String TABLE_BROWAREK = "Browarek";

    public static final String KEY_ID = "id";
    public static final String NAME = "nazwa";
    public static final String PRICE = "cena";
    public static final String EKS = "ekstrakt";
    public static final String VOL = "woltarz";
    public static final String CNT = "kraj";
    public static final String STAR = "ocena";
    public static final String CODE = "kod";

    private static final String DATABASE_CREATE=
            "create table if not exists Browarek (id integer primary key " +
                    "autoincrement, nazwa VARCHAR not null,cena FLOAT NOT NULL, ekstrakt VARCHAR, woltarz VARCHAR, kraj VARCHAR," +
                    "ocena FLOAT,kod VARCHAR);";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BROWAREK);
        onCreate(db);
    }


    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */

    void addBrowarek(Browarek browarek) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(NAME, browarek.get_nazwa());
        values.put(PRICE, browarek.get_cena());
        values.put(EKS, browarek.get_ekstrakt());
        values.put(VOL, browarek.get_woltarz());
        values.put(CNT, browarek.get_kraj());
        values.put(STAR, browarek.get_ocena());
        values.put(CODE, browarek.get_kod());



        // Inserting Row
        db.insert(TABLE_BROWAREK, null, values);
        db.close(); // Closing database connection
    }

    // Getting single contact
    Browarek getBrowarek(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_BROWAREK, new String[] { KEY_ID,
                        NAME, PRICE, EKS, VOL, CNT, STAR, CODE }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Browarek browarek = new Browarek(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1),
                Float.parseFloat(cursor.getString(2)),
                cursor.getString(3),
                cursor.getString(4),
                cursor.getString(5),
                Float.parseFloat(cursor.getString(6)),
                cursor.getString(7));

        return browarek;
    }

    // Getting All Browarek
    public List<Browarek> getAllBrowarek() {
        List<Browarek> browarekList = new ArrayList<Browarek>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_BROWAREK;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Browarek browarek = new Browarek();
                browarek.set_id(Integer.parseInt(cursor.getString(0)));
                browarek.set_nazwa(cursor.getString(1));
                browarek.set_cena(Float.parseFloat(cursor.getString(2)));
                browarek.set_ekstrakt(cursor.getString(3));
                browarek.set_woltarz(cursor.getString(4));
                browarek.set_kraj(cursor.getString(5));
                browarek.set_ocena(Float.parseFloat(cursor.getString(6)));
                browarek.set_kod(cursor.getString(7));
                // Adding contact to list
                browarekList.add(browarek);
            } while (cursor.moveToNext());
        }

        // return contact list
        return browarekList;
    }

    // Updating single browarek
    public int updateBrowarek(Browarek browarek) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(NAME, browarek.get_nazwa());
        values.put(PRICE, browarek.get_cena());
        values.put(EKS, browarek.get_ekstrakt());
        values.put(VOL, browarek.get_woltarz());
        values.put(CNT, browarek.get_kraj());
        values.put(STAR, browarek.get_ocena());
        values.put(CODE, browarek.get_kod());

        // updating row
        return db.update(TABLE_BROWAREK, values, KEY_ID + " = ?",
                new String[] { String.valueOf(browarek.get_id()) });
    }

    // Deleting single contact
    public void deleteBrowarek(Browarek browarek) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_BROWAREK, KEY_ID + " = ?",
                new String[] { String.valueOf(browarek.get_id()) });
        db.close();
    }


    // Getting broarek Count
    public int getBrowarekCount() {
        String countQuery = "SELECT  * FROM " + TABLE_BROWAREK;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }
}
