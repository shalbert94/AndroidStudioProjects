package com.example.android.pennyworth.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.android.pennyworth.R;
import com.example.android.pennyworth.recommendationsObjects.Recommendation;
import com.example.android.pennyworth.adapters.RecommendationsArrayAdapter;

import java.util.ArrayList;

/**
 * Created by shalom on 2017-06-02.
 * Fragment shown through TabLayout on MainActivity.java that expresses the Recommendations feature
 */



public class RecommendationsFragment extends android.support.v4.app.Fragment {

    public static final String ARG_PAGE = "ARG_PAGE";
    private int mPage;
    private View view;
    private ArrayList<Recommendation> recommendations = new ArrayList<>();
    private RecommendationsArrayAdapter adapter;

//    Required empty constructor
    public RecommendationsFragment() { }

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
        view = inflater.inflate(R.layout.recommendations_fragment, container, false);

        createRecommendationList();

        adapter = new RecommendationsArrayAdapter(getContext(), recommendations);
        ListView listView = (ListView) view.findViewById(R.id.recommendations_listview);
        listView.setAdapter(adapter);

        return view;
    }

//    Placeholder information that will be deleted
    private void createRecommendationList() {
        recommendations.add(new Recommendation("Credit Cards", "Save up to $1,018", "Apply for a 0% APR credit card, and transfer your Citi Double Cash balance to it."));
        recommendations.add(new Recommendation("Debt", "Save up to $1,200", "Allow us to reduce your Weekly budget by $6.25 and put it towards paying debts faster."));
        recommendations.add(new Recommendation("Disability Insurance", "Protection from loss of income", "Purchase disability insurance to ensure you have income even if you become disables."));
        recommendations.add(new Recommendation("Transfer", "Achieve life goals", "Follow your Goals budget by transferring $472.00 to the appropriate accounts."));
    }
}
