package com.course.exercise1;

/**
 * Created by dell on 06/04/2016.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentManager;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    int [] image = {R.drawable.google1,R.drawable.google2,R.drawable.google3,R.drawable.google4,R.drawable.google5};

    String[] text = {"1.The originally name was Gogle and accidently turned into Google",
            "2.Google spends more than 100,000,000$ a year for food for their employes",
            "3.Google workers are allowed to bring their dogs to work, and are given food and water",
            "4.Google sends hot air balloons with Antennas to countries without Internet Antennas such as Africa",
            "5.Even though you have seen this logo a thousand times a day you still have no idea what the color of the second G in Google without going back to page 1... :)"
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
