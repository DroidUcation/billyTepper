package com.course.exercise1;

import android.content.ContentValues;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.course.exercise1.db.exercise1Contract;

public class ViewPagerActivity extends AppCompatActivity {

    ViewPager pager;
    ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        insertData();

        setContentView(R.layout.activity_view_pager);

        pager = (ViewPager) findViewById(R.id.pager);
        adapter = new ViewPagerAdapter(this, getSupportFragmentManager());

        pager.setAdapter(adapter);

    }

    public void insertData(){
        ContentValues[] contentValueArray = new ContentValues[]{
                getFactContentValue(1, "R.strings.fragment_google1"),
                getFactContentValue(2, "R.strings.fragment_google2"),
                getFactContentValue(3, "R.strings.fragment_google3"),
                getFactContentValue(4, "R.strings.fragment_google4"),
                getFactContentValue(5, "R.strings.fragment_google5")};

        getContentResolver().bulkInsert(exercise1Contract.CONTENT_URI, contentValueArray);
    }


    private ContentValues getFactContentValue (int factNumber,String fact)
    {
        ContentValues values = new ContentValues();
        values.put(exercise1Contract.fiveFactsEntry.COLUMN_FACT_NUMBER,factNumber);
        values.put(exercise1Contract.fiveFactsEntry.COLUMN_FACT, fact);

        return values;
    }

}
