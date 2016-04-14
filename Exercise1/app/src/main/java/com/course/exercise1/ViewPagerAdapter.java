package com.course.exercise1;

/**
 * Created by dell on 06/04/2016.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentManager;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    int [] image = {R.drawable.google1,R.drawable.google2,R.drawable.google3,R.drawable.google4,R.drawable.google5};
    String[] text = {"R.strings.fragment_google1",
            "r.strings.fragment_google2",
            "r.string.fragment_google3",
            "r.string.fragment_google4",
            "r.string.fragmet.google5"
    };

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

@Override
    public Fragment getItem(int position) {
        return ViewPagerFragment.newInstance(position,image[position],text[position]);
    }

@Override
    public int getCount(){
        return image.length;
    }


}
