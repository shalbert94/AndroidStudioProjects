package com.example.android.pennyworth.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.example.android.pennyworth.R;
import com.example.android.pennyworth.adapters.BudgetsExpandableListAdapter;
import com.example.android.pennyworth.budgetsObjects.BudgetsChild;
import com.example.android.pennyworth.budgetsObjects.BudgetsGroup;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by shalom on 2017-06-03.
 * Fragment shown through TabLayout on MainActivity.java that expresses the Budgets feature
 */

public class BudgetsFragment extends android.support.v4.app.Fragment {

    public static final String ARG_PAGE = "ARG_PAGE";
    private int mPage;
    private View view;
    private ExpandableListView budgetExpandableListView;
    private BudgetsExpandableListAdapter adapter;
    private ArrayList<BudgetsGroup> budgetGroup = new ArrayList<>();
    private HashMap<String, ArrayList<BudgetsChild>> budgetChild = new HashMap<>();

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

        budgetExpandableListView = (ExpandableListView) view.findViewById(R.id.budget_expandable_listview);

        prepareListData();

        adapter = new BudgetsExpandableListAdapter(getContext(), budgetGroup, budgetChild);

        budgetExpandableListView.setAdapter(adapter);

        return view;
    }

//    Placeholder information that will be deleted
    private void prepareListData() {
        createGroupList();
        createChildList();
    }

//    Placeholder information that will be deleted
    private void createGroupList() {
        budgetGroup.add(new BudgetsGroup("Weekly", 16, 152, 168));
        budgetGroup.add(new BudgetsGroup("Monthly Bills", 110, 115, 225));
        budgetGroup.add(new BudgetsGroup("Goals", 236, 236, 472));
    }

//    Placeholder information that will be deleted
    private void createChildList() {
        ArrayList<BudgetsChild> weeklyChildren = new ArrayList<>();
        ArrayList<BudgetsChild> monthlyBillsChildren = new ArrayList<>();
        ArrayList<BudgetsChild> goalsChildren = new ArrayList<>();

        weeklyChildren.add(new BudgetsChild("Recreation", 23, 22, 45));
        weeklyChildren.add(new BudgetsChild("Transportation", 0, 20, 20));
        weeklyChildren.add(new BudgetsChild("Groceries", 41, 15, 56));
        weeklyChildren.add(new BudgetsChild("Restaurants", -2, 49, 47));

        monthlyBillsChildren.add(new BudgetsChild("Health Insurance", 110, 0, 110));
        monthlyBillsChildren.add(new BudgetsChild("Electricity", 0, 87, 87));
        monthlyBillsChildren.add(new BudgetsChild("Phone", 0, 28, 28));

        goalsChildren.add(new BudgetsChild("Net Worth: $100,000", 0, 79, 79));
        goalsChildren.add(new BudgetsChild("Travel", 157, 0, 157));
        goalsChildren.add(new BudgetsChild("Retirement", 0, 236, 236));

        budgetChild.put("Weekly", weeklyChildren);
        budgetChild.put("Monthly Bills", monthlyBillsChildren);
        budgetChild.put("Goals", goalsChildren);
    }
}
