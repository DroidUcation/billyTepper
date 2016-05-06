package com.course.exercise1.db;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by dell on 04/05/2016.
 */
public class exercise1Contract {

    public static final String AUTHORITY = "com.course.exercise1.db.exercise1Provider";
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + fiveFactsEntry.Table_Name);

    public static class fiveFactsEntry implements BaseColumns
    {
        public static final String Table_Name  = "fiveFacts";
        public static final String COLUMN_FACT_NUMBER = "factNum";
        public  static final String COLUMN_FACT = "factTxt";

    }
}
