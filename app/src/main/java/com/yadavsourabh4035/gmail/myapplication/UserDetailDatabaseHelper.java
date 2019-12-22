package com.yadavsourabh4035.gmail.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import java.util.ArrayList;
import java.util.List;

import static com.yadavsourabh4035.gmail.myapplication.UserDetailTable.TABLE_NAME;

/* This is a local db for storing the user details(id,name,email,phone) at the time of signup */

public class UserDetailDatabaseHelper extends SQLiteOpenHelper {

	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "userdetails_db";

	public UserDetailDatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(UserDetailTable.CREATE_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int i, int i1) {
		db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
		onCreate(db);
	}

	/* This method is used for inserting the details of user (id,name,email,phone) into local db */

	public void insertUserDetails( String key, String email){
		SQLiteDatabase db=this.getWritableDatabase();
		ContentValues values=new ContentValues();
		values.put(UserDetailTable.COLUMN_KEY, key);

		values.put(UserDetailTable.COLUMN_EMAIL,email);


		db.insert(TABLE_NAME, null, values);
	}

	/* This method returns all details of user from from local database */

	public List<UserDetailTable> getUserDetails(){
		List<UserDetailTable> userDetails=new ArrayList<>();

		String selectQuery= "SELECT * FROM " + TABLE_NAME;

		SQLiteDatabase db=this.getWritableDatabase();
		Cursor cursor=db.rawQuery(selectQuery, null);

		if(cursor.moveToFirst()){
			do{
				UserDetailTable userDetailTable=new UserDetailTable();
				userDetailTable.setKey(cursor.getString(cursor.getColumnIndex(UserDetailTable.COLUMN_KEY)));


				userDetailTable.setEmail(cursor.getString(cursor.getColumnIndex(UserDetailTable.COLUMN_EMAIL)));


				userDetails.add(userDetailTable);

			}while (cursor.moveToNext());
		}
		db.close();
		cursor.close();
		return userDetails;
	}

	/* This method checks for if user exists in local database or not if it exists then returns true otherwise false */

	public boolean checkIfRecordExist(int id)
	{
		SQLiteDatabase db=this.getWritableDatabase();
		Cursor cursor = null;
		String sql ="SELECT id FROM "+TABLE_NAME+" WHERE id="+id;
		cursor= db.rawQuery(sql,null);

		if(cursor.getCount()>0){
			//PID Found
			return true;
		}
		cursor.close();
		return false;
	}


	public void removeAll(){
		SQLiteDatabase db=this.getWritableDatabase();
		db.execSQL("delete from " + TABLE_NAME);
	}


}