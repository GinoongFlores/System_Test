package com.example.system_test;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AccountDatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "account.db";
    public static final String TABLE_NAME = "account_table";
    public static final String COL_0 = "ID";
    public static final String COL_1 = "NAME";
    public static final String COL_2 = "EMAIL";
    public static final String COL_3 = "PASSWORD";

    SQLiteDatabase db = this.getWritableDatabase();
    ContentValues contentValues = new ContentValues();

    public AccountDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null,  1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABlE "  + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, EMAIL TEXT, PASSWORD TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    // insertData()
    public boolean insertData(String name) {
        contentValues.put(COL_1, name);
        long result = db.insert(TABLE_NAME, null, contentValues);
        return result != -1;
    }

    // signUp()
    public boolean signUp(String name, String email,String password) {
        contentValues.put(COL_1, name);
        contentValues.put(COL_2, email);
        contentValues.put(COL_3, password);
        long result = db.insert(TABLE_NAME, null, contentValues);
        return result != -1;
//        if(result == -1){
//            return false;
//        }else{
//            return true;
//        }
    }

    // updateData()
    public  boolean updateData(String id, String name) {
        contentValues.put(COL_2, name);
        db.update(TABLE_NAME, contentValues, "ID = ? ", new String[] {id});
        return true;
    }

    // deleteData()
    public  Integer deleteData(String id) {
        return db.delete(TABLE_NAME, "ID = ? ", new String[] {id});
    }

    // getData()
    public Cursor getData() {
        Cursor res = db.rawQuery(" select * from " + TABLE_NAME, null);
        return res;
    }

    // searchDat()
    public Cursor searchData(String name) {
        Cursor res = db.rawQuery(" select * from " + TABLE_NAME + " WHERE NAME = ? ",  new String[] {name});
        return res;
    }

    // checkUser()
    public boolean checkUser(String username, String password) {
        Cursor res = db.query(TABLE_NAME, new String[] {COL_1, COL_2, COL_3}, COL_2 + " = ? and " + COL_3 + " = ?",
                new String[] {username, password}, null, null, null);

        int count = res.getCount();
        res.close();
        db.close();

        if (count > 0)
            return true;
        else
            return  false;



    }

    /**
     Dialog builder = new Dialog(context);
     builder.requestWindowFeature(Window.FEATURE_NO_TITLE);
     builder.setContentView(layout);
     builder.setCancelable(true);
     builder.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.COLOR.TRANSPARENT));
     tvResult = builder.findViewById(R.id.tvResult);
     builder.show();
     */

}



