package com.example.app_1;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBhelper {

    myDbHelper myhelper;
    public DBhelper(Context context)
    {
        myhelper = new myDbHelper(context);
    }

    public long insertData(String name, String pass)
    {
        if(this.checkExists(name, pass)==0) {
            SQLiteDatabase dbb = myhelper.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(myDbHelper.NAME, name);
            contentValues.put(myDbHelper.MyPASSWORD, pass);
            return dbb.insertOrThrow(myDbHelper.TABLE_NAME, null, contentValues);
        }
        else
            return -1;
    }

    public String getData()
    {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String[] columns = {myDbHelper.UID,myDbHelper.NAME,myDbHelper.MyPASSWORD};
        Cursor cursor =db.query(myDbHelper.TABLE_NAME,columns,null,null,null,null,null);
        StringBuffer buffer= new StringBuffer();
        while (cursor.moveToNext())
        {
            int cid =cursor.getInt(cursor.getColumnIndex(myDbHelper.UID));
            String name =cursor.getString(cursor.getColumnIndex(myDbHelper.NAME));
            String  password =cursor.getString(cursor.getColumnIndex(myDbHelper.MyPASSWORD));
            buffer.append( name + "\t" + password +" \n");
        }
        return buffer.toString();
    }

    public  int delete(String uname)
    {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String[] whereArgs ={uname};

        return db.delete(myDbHelper.TABLE_NAME ,myDbHelper.NAME+" = ?",whereArgs);
    }

    public int updateName(String oldName , String newName)
    {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(myDbHelper.NAME,newName);
        String[] whereArgs= {oldName};
        return db.update(myDbHelper.TABLE_NAME,contentValues, myDbHelper.NAME+" = ?",whereArgs );
    }
    public int checkExists( String name, String pass) {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String[] columns = {myDbHelper.NAME,myDbHelper.MyPASSWORD};
        String whereClause = myDbHelper.NAME + " = ? AND " + myDbHelper.MyPASSWORD + "= ?";
        String[] whereArgs = new String[] {name,pass};
        
        Cursor cursor =db.query(myDbHelper.TABLE_NAME,columns,whereClause,whereArgs,null,null,null);
//        Cursor resultSet = db.rawQuery("SELECT COUNT(*) FROM myTable WHERE Name='" + name + "' and Password='" + pass + "';",null);
        return cursor.getCount();

    }

    static class myDbHelper extends SQLiteOpenHelper
    {
        private static final String DATABASE_NAME = "myDatabase";    // Database Name
        private static final String TABLE_NAME = "myTable";   // Table Name
        private static final int DATABASE_Version = 1;    // Database Version
        private static final String UID="_id";     // Column I (Primary Key)
        private static final String NAME = "Name";    //Column II
        private static final String MyPASSWORD= "Password";    // Column III
        private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+
                " ("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+NAME+" VARCHAR(255) ,"+ MyPASSWORD+" VARCHAR(225));";
        private static final String CHECK_EXISTS = "SELECT COUNT(*) FROM myTable WHERE ";
        private static final String DROP_TABLE ="DROP TABLE IF EXISTS "+TABLE_NAME;
        private Context context;

        public myDbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_Version);
            this.context=context;
        }

        public void onCreate(SQLiteDatabase db) {

            try {
                db.execSQL(CREATE_TABLE);
            } catch (Exception e) {
                Message.message(context,""+e);
            }
        }


        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            try {
                Message.message(context,"OnUpgrade");
                db.execSQL(DROP_TABLE);
                onCreate(db);
            }catch (Exception e) {
                Message.message(context,""+e);
            }
        }
    }
}
