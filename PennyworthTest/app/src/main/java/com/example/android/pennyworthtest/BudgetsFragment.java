package com.example.android.pennyworthtest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by shalom on 2017-06-03.
 * Fragment shown through TabLayout on MainActivity.java that expresses the Budgets feature
 */

public class BudgetsFragment extends android.support.v4.app.Fragment {

    public static final String ARG_PAGE = "ARG_PAGE";
    private int mPage;
    private View view;

//    Required empty constructor
    public BudgetsFragment() {}

//    Required for MainActivityFragmentPagerAdapter
    public static BudgetsFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);

        BudgetsFragment fragment = new BudgetsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }

//    Defines what should be done when this fragment is displayed
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.budgets_fragment, container, false);


        return view;
    }
}
