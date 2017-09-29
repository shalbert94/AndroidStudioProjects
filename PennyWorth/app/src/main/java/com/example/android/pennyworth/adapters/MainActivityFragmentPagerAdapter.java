package com.example.android.pennyworth.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.android.pennyworth.fragments.BudgetsFragment;
import com.example.android.pennyworth.fragments.RecommendationsFragment;
import com.example.android.pennyworth.fragments.SummaryFragment;

/**
 * Created by shalom on 2017-06-03.
 * Enables MainActivity.java to host fragments using TabLayout
 * Related fragments are RecommendationsFragment.java, BudgetsFragment.java, and SummaryFragment.java
 */

//Change tabTitles to approriate icons, and change app heading (where it would say Pennyworth) to the feauture name

public class MainActivityFragmentPagerAdapter extends FragmentPagerAdapter {

    //    Number of tabs
    final int PAGE_COUNT = 3;
    private String tabTitles[] = new String[] {"Recommendations", "Budgets", "Summary"};
    private Context context;

    public MainActivityFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return RecommendationsFragment.newInstance(position + 1);
            case 1:
                return BudgetsFragment.newInstance(position + 1);
            case 2:
                return SummaryFragment.newInstance(position + 1);
        }
        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }
}
