package com.course.exercise1.db;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.support.annotation.Nullable;

/**
 * Created by dell on 04/05/2016.
 */
public class exercise1Provider extends ContentProvider{

    private excercise1DatabaseHelper eDataHelper;

    private SQLiteDatabase db;

    private static final UriMatcher sURIMatcher = getUriMatcher();

    private static final int fact = 1;

    @Override
    public boolean onCreate() {
        eDataHelper = new excercise1DatabaseHelper(getContext());
        return true;
   }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
            SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
            queryBuilder.setTables(exercise1Contract.fiveFactsEntry.Table_Name);

            int uriType = sURIMatcher.match(uri);
            switch (uriType) {
                case fact:
                    queryBuilder.appendWhere(exercise1Contract.fiveFactsEntry.COLUMN_FACT_NUMBER + "=" + uri.getLastPathSegment());                    break;
                default:
                    throw new IllegalArgumentException("Unknown URI" + uri);
            }


            Cursor cursor = queryBuilder.query(eDataHelper.getReadableDatabase(), projection, selection, selectionArgs, null, null, sortOrder);
            cursor.setNotificationUri(getContext().getContentResolver(), uri);
            return cursor;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        int uriType = sURIMatcher.match(uri);

        db = eDataHelper.getWritableDatabase();

        long id = 0;

        switch (uriType) {
            case fact:
                id = db.insert(exercise1Contract.fiveFactsEntry.Table_Name, null, values);
                break;
            default:
                throw new IllegalArgumentException("Unknown URI" + uri);
        }

        getContext().getContentResolver().notifyChange(uri, null);

        return ContentUris.withAppendedId(uri, id);
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }

    private static UriMatcher getUriMatcher() {
        final UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);
        final String authority = exercise1Contract.AUTHORITY;

        sURIMatcher.addURI(authority, exercise1Contract.fiveFactsEntry.Table_Name, fact);
        sURIMatcher.addURI(authority, exercise1Contract.fiveFactsEntry.Table_Name + "/*", fact);
        return sURIMatcher;
    }




}
