package com.example.denish.sqlite_crud_template;

/**
 * Created by denish on 4/8/18.
 */

import java.util.LinkedList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteDatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "StudentsDB";
    private static final String TABLE_NAME = "Students";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_PASSWORD = "password";
    private static final String KEY_USERID = "userid";
    private static final String[] COLUMNS = { KEY_ID, KEY_NAME, KEY_PASSWORD,
            KEY_USERID };

    public SQLiteDatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATION_TABLE = "CREATE TABLE Students ( "
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, " + "name TEXT, "
                + "password TEXT, " + "userid TEXT )";

        db.execSQL(CREATION_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // you can implement here migration process
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        this.onCreate(db);
    }

    public void deleteOne(Student student) {
        // Get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, "id = ?", new String[] { String.valueOf(student.getId()) });
        db.close();
    }

    public Student getPlayer(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, // a. table
                COLUMNS, // b. column names
                " id = ?", // c. selections
                new String[] { String.valueOf(id) }, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit

        if (cursor != null)
            cursor.moveToFirst();

        Student student = new Student();
        student.setId(Integer.parseInt(cursor.getString(0)));
        student.setName(cursor.getString(1));
        student.setPassword(cursor.getString(2));
        student.setUserid(cursor.getString(3));

        return student;
    }

    public List<Student> allPlayers() {

        List<Student> students = new LinkedList<Student>();
        String query = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Student student = null;

        if (cursor.moveToFirst()) {
            do {
                student = new Student();
                student.setId(Integer.parseInt(cursor.getString(0)));
                student.setName(cursor.getString(1));
                student.setPassword(cursor.getString(2));
                student.setUserid(cursor.getString(3));
                students.add(student);
            } while (cursor.moveToNext());
        }

        return students;
    }

    public void addPlayer(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, student.getName());
        values.put(KEY_PASSWORD, student.getPassword());
        values.put(KEY_USERID, student.getUserid());
        // insert
        db.insert(TABLE_NAME,null, values);
        db.close();
    }

    public int updatePlayer(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, student.getName());
        values.put(KEY_PASSWORD, student.getPassword());
        values.put(KEY_USERID, student.getUserid());

        int i = db.update(TABLE_NAME, // table
                values, // column/value
                "id = ?", // selections
                new String[] { String.valueOf(student.getId()) });

        db.close();

        return i;
    }

}
