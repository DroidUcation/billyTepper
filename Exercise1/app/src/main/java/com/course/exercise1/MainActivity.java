package com.course.exercise1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //firstScreen
    }

    @Override
    protected void onStart() {
            super.onStart();
    }

    @Override
    protected void onResume() {
            super.onResume();
    }

    @Override
    protected void onPause() {
            super.onPause();
    }

    @Override
    protected void onStop() {
            super.onStop();
    }

    @Override
    protected void onDestroy() {
            super.onDestroy();
    }

    @Override
    public void onDetachedFromWindow() {
            super.onDetachedFromWindow();
    }

    public void startClicked(View v){
        Intent intent = new Intent(getApplicationContext(),ViewPagerActivity.class);
        startActivity(intent);
    }
}
