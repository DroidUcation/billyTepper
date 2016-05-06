package com.course.exercise1;

/**
 * Created by dell on 06/04/2016.
 */

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentManager;
import android.widget.TextView;

import com.course.exercise1.db.exercise1Contract;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    int [] image = {R.drawable.google1,R.drawable.google2,R.drawable.google3,R.drawable.google4,R.drawable.google5};


    //this array is not in use, get the text from db
//    String[] text = {"R.strings.fragment_google1",
//            "r.strings.fragment_google2",
//            "r.string.fragment_google3",
//            "r.string.fragment_google4",
//            "r.string.fragmet.google5"
//    };

    Context context;
    public ViewPagerAdapter(Context mContext,FragmentManager fm) {
        super(fm);
        this.context = mContext;
    }

@Override
    public Fragment getItem(int position) {
        String factTxt = getFactTextFromDb(position);
        return ViewPagerFragment.newInstance(position,image[position],factTxt);
    }

    public String getFactTextFromDb(int fact){
        Uri uri = Uri.withAppendedPath(exercise1Contract.CONTENT_URI,"fact");
        Cursor cursor = context.getContentResolver().query(uri, null, null, null, null);
        if(cursor.moveToFirst())
            return cursor.getString(2);
        return "";
    }



@Override
    public int getCount(){
        return image.length;
    }


}
