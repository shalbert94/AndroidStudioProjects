package com.example.android.pennyworthtest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by shalom on 2017-06-02.
 * Fragment shown through TabLayout on MainActivity.java that expresses the Recommendations feature
 */


public class RecommendationsFragment extends android.support.v4.app.Fragment {

    public static final String ARG_PAGE = "ARG_PAGE";
    private int mPage;
//    private View view;

    //    Required empty constructor
    public RecommendationsFragment() {
    }

    //    Required for MainActivityFragmentPagerAdapter
    public static RecommendationsFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);

        RecommendationsFragment fragment = new RecommendationsFragment();
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
        View rootView = inflater.inflate(R.layout.recommendations_fragment, container, false);
        TextView tv = (TextView) rootView.findViewById(R.id.recommendations_textview);
        tv.setText("Teststring");
        return rootView;
    }
}
