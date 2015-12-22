package com.example.resepmakanan;

import java.util.ArrayList;
import java.util.List;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;



public class DatabaseHelperAustralia extends SQLiteAssetHelper
{
	private static final String		DB_NAME		= "ciaubella";
	private static final int		DB_VER		= 1;

	private static final String		TB_DATA		= "australia";
	public static final String		COL_ID		= "kd_australia";
	public static final String		COL_NAMA	= "nama";
	public static final String		COL_RESEP	= "resep";
	public static final String		COL_CARA	= "cara";
	private static DatabaseHelperAustralia	dbInstance;
	private static SQLiteDatabase	db;

	private DatabaseHelperAustralia(Context context)
	{
		super(context, DB_NAME, null, DB_VER);
	}

	public static DatabaseHelperAustralia getInstance(Context context)
	{
		if (dbInstance == null)
		{
			dbInstance = new DatabaseHelperAustralia(context);
			db = dbInstance.getWritableDatabase();
		}
		return dbInstance;
	}

	@Override
	public synchronized void close()
	{
		super.close();
		if (dbInstance != null)
		{
			dbInstance.close();
		}
	}

	public List<TableResep> getAllResep()
	{
		List<TableResep> lisResep = new ArrayList<TableResep>();

		Cursor cursor = db.query(TB_DATA, new String[] { COL_ID, COL_ID,
				COL_ID, COL_NAMA, COL_RESEP, COL_CARA }, null, null, null, null, COL_ID);
		if (cursor.getCount() >= 1)
		{
			cursor.moveToFirst();

			do
			{
				TableResep kamus = new TableResep();
				kamus.setkd_benua(cursor.getString(cursor
						.getColumnIndexOrThrow(COL_ID)));
				kamus.setnama(cursor.getString(cursor
						.getColumnIndexOrThrow(COL_NAMA)));
				kamus.setcara(cursor.getString(cursor
						.getColumnIndexOrThrow(COL_CARA)));
				kamus.setResep(cursor.getString(cursor
						.getColumnIndexOrThrow(COL_RESEP)));
				lisResep.add(kamus);

			} while (cursor.moveToNext());
		}
		return lisResep;

	}

	public Cursor getBukuByJudul(String query)
	{
		Cursor cursor = null;

		if (TextUtils.isEmpty(query))
		{
			cursor = db.query(TB_DATA, new String[] { COL_ID, COL_NAMA, COL_CARA,
					COL_RESEP}, null, null, null, null, null, "10");
		} else
		{
			cursor = db.query(TB_DATA, new String[] { COL_ID, COL_NAMA, COL_CARA,
					COL_RESEP }, COL_NAMA + " like '" + query + "%'",
					null, null, null, null);
		}
		return cursor;
	}
}
