package com.example.vishal.sqliterevisionexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, ContractEntry.DATABASE_NAME, null, ContractEntry.VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ContractEntry.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ContractEntry.TABLE_NAME);
        onCreate(db);
        onUpgrade(db,oldVersion,newVersion);
    }

    public Long insert(String name,String phone_number,String salary,String address){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(ContractEntry.EMPLOYEE_NAME,name);
        contentValues.put(ContractEntry.EMPLOYEE_PHONE_NUMBER,phone_number);
        contentValues.put(ContractEntry.EMPLOYEE_SALARY,salary);
        contentValues.put(ContractEntry.EMPLOYEE_ADDRESS,address);

        Long ret = db.insert(ContractEntry.TABLE_NAME,null,contentValues);
        db.close();
        return ret;
    }

    public ArrayList<ContactClass> fetch(){
        SQLiteDatabase db = this.getReadableDatabase();

        String SQLSELECT = "SELECT * FROM " + ContractEntry.TABLE_NAME;
        ArrayList<ContactClass> contactList = new ArrayList<>();
        ContactClass obj = new ContactClass();
        Cursor cursor ;;
        String res = "";
        cursor = db.rawQuery(SQLSELECT,null);
        while (cursor.moveToNext()){
            obj.setId(cursor.getColumnIndex(ContractEntry.ID));

            contactList.add(obj);
        }
        return contactList;
    }

    public void update(String name,String phone, String salary, String address,  int id){
        SQLiteDatabase db = this.getWritableDatabase();

        String sqlUpdate = "UPDATE " + ContractEntry.TABLE_NAME + " SET " + ContractEntry.EMPLOYEE_NAME + " =?, "
                                     + ContractEntry.EMPLOYEE_PHONE_NUMBER + " =?, " + ContractEntry.EMPLOYEE_SALARY + " =?, "
                                     + ContractEntry.EMPLOYEE_ADDRESS + " =?, WHERE " + ContractEntry.ID + "=" + id;
        db.execSQL(sqlUpdate,new String[]{name,phone,salary,address});
    }

    public void delete(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "DELETE FROM " + ContractEntry.TABLE_NAME + " WHERE " + ContractEntry.ID + "= " + id;
        db.execSQL(sql);
    }
}
