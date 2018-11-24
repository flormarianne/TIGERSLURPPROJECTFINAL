package ph.edu.ust.jatallas.project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "DatabaseHelper";

    private static final String table1 = "Users";
    private static final String c1t1 = "ID";
    private static final String c2t1 = "Name";
    private static final String c3t1 = "Location";
    private static final String c4t1 = "PriceRange";

    public DatabaseHelper(Context context) {
        super(context, table1, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + table1 + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                c2t1 + " TEXT " + " , " + c3t1 + " TEXT " + " , " + c4t1 + " TEXT );";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + table1);
        onCreate(db);
    }

    // insert
    public boolean addData(String name, String location, String range) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(c2t1, name);
        contentValues.put(c3t1, location);
        contentValues.put(c4t1, range);

        Log.d(TAG, "addData: Adding " + name + " to " + table1);
        Log.d(TAG, "addData: Adding " + location + " to " + table1);
        Log.d(TAG, "addData: Adding " + range + " to " + table1);

        Long result = db.insert(table1, null, contentValues);

        //if data is inserted incorrectly, return 1
        if (result == -1)
            return false;
        else
            return true;
    }

    // select
    public Cursor getData(String username) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT " + c3t1 + ", " + c4t1 + " FROM " + table1 +
                " WHERE " + c3t1 + " = '" + username + "'";
        Cursor data = db.rawQuery(query, null);
        return data;
    }



}

