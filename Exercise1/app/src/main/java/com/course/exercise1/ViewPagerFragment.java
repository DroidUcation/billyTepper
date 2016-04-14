package com.course.exercise1;

import android.media.Image;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by dell on 06/04/2016.
 */
public class ViewPagerFragment extends Fragment {

    public ViewPagerFragment(){

    };

     public static final String imagePosition = "imagePosition";


    public static ViewPagerFragment newInstance(int position,int imageId,String text)
    {
        ViewPagerFragment myFragment = new ViewPagerFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("imagePosition",position);
        bundle.putInt("imageId",imageId);
        bundle.putString("txtTitle",text);
        myFragment.setArguments(bundle);

        return  myFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_layout, container, false);

        int imageId = getArguments().getInt("imageId");
        int position = getArguments().getInt("imagePosition");
        String text = getArguments().getString("txtTitle");

        ImageView iv  = (ImageView)rootView.findViewById(R.id.myIv);
        iv.setImageResource(imageId);

        TextView tv = (TextView)rootView.findViewById(R.id.textView);
        tv.setText(text);

//        Toast.makeText(getActivity(), "Page Number " + position, Toast.LENGTH_SHORT).show();

        return rootView;
    }
}
