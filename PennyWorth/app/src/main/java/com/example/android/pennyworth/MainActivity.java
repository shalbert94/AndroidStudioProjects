package com.example.android.pennyworth;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.android.pennyworth.adapters.MainActivityFragmentPagerAdapter;

/**
 * MainActivity.java is setup so that there are tabs for each of the three main features
 * It uses a TabLayout that is combined with a ViewPager
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

//        Get the ViewPager and set it's PagerAdapter so that it can display items
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new MainActivityFragmentPagerAdapter(getSupportFragmentManager(), MainActivity.this));

//        Give the TabLayout the ViewPager
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);
    }
}
