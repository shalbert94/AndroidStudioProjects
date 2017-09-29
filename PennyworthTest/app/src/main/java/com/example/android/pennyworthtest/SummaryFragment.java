package com.example.android.pennyworthtest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import com.example.android.pennyworthtest.summaryAdapters.AssetArrayAdapter;
import com.example.android.pennyworthtest.summaryAdapters.DebtArrayAdapter;
import com.example.android.pennyworthtest.summaryAdapters.InsuranceArrayAdapter;
import com.example.android.pennyworthtest.summaryObjects.Asset;
import com.example.android.pennyworthtest.summaryObjects.Debt;
import com.example.android.pennyworthtest.summaryObjects.Insurance;
import com.example.android.pennyworthtest.summaryObjects.Retirement;

import java.util.ArrayList;

/**
 * Created by shalom on 2017-06-03.
 * Fragment shown through TabLayout on MainActivity.java that expresses the Budgets feature
 */

public class SummaryFragment extends android.support.v4.app.Fragment {

    public static final String ARG_PAGE = "ARG_PAGE";
    private int mPage;
    private View view;

//    ArrayLists for the Summary objects
    private AssetArrayAdapter assetAdapter;
    private DebtArrayAdapter debtAdapter;
    private InsuranceArrayAdapter insuranceAdapter;
    private ArrayList<Asset> assetArrayList = new ArrayList<>();
    private ArrayList<Debt> debtArrayList = new ArrayList<>();
    private ArrayList<Insurance> insuranceArrayList = new ArrayList<>();

//    Required empty constructor
    public SummaryFragment() {}

//    Required for MainActivityFragmentPagerAdapter
    public static SummaryFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);

        SummaryFragment fragment = new SummaryFragment();
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
        view = inflater.inflate(R.layout.summary_fragment, container, false);

        populateSummaryFragment(container);

        return view;
    }

//    All called methods, and this, will be deleted. They are placeholders
    private void populateSummaryFragment(ViewGroup container) {
        populateHeadings(container);
        populateListViews(container);
        populateRetirement(container);
    }

    private void populateHeadings(ViewGroup container) {
        TextView creditScore = (TextView) container.findViewById(R.id.summary_credit_score_value_textview);
        TextView netWorth = (TextView) container.findViewById(R.id.summary_net_worth_value_textview);
        TextView assets = (TextView) container.findViewById(R.id.summary_assets_value_textview);
        TextView debts = (TextView) container.findViewById(R.id.summary_debts_value_textview);

        creditScore.setText("650");
        netWorth.setText("$73,479");
        assets.setText("$97,633");
        debts.setText("$24,154");
    }

    private void populateListViews(ViewGroup container) {
        createArrayLists();

        assetAdapter = new AssetArrayAdapter(getContext(), assetArrayList);
        debtAdapter = new DebtArrayAdapter(getContext(), debtArrayList);
        insuranceAdapter = new InsuranceArrayAdapter(getContext(), insuranceArrayList);

        ListView assetListView = (ListView) container.findViewById(R.id.summary_assets_listview);
        ListView debtListView = (ListView) container.findViewById(R.id.summary_debts_listview);
        ListView insuranceListView = (ListView) container.findViewById(R.id.summary_insurance_listview);

        assetListView.setAdapter(assetAdapter);
        debtListView.setAdapter(debtAdapter);
        insuranceListView.setAdapter(insuranceAdapter);
    }

    private void populateRetirement(ViewGroup container) {
        TextView estimatedAgeTitle = (TextView) container.findViewById(R.id.summary_retirement_estimated_age_title_textview);
        TextView estimatedAgeValue = (TextView) container.findViewById(R.id.summary_retirement_estimated_age_value_textview);
        TextView estimatedIncomeTitle = (TextView) container.findViewById(R.id.summary_retirement_estimated_income_title_textview);
        TextView estimatedIncomeValue = (TextView) container.findViewById(R.id.summary_retirement_estimated_income_value_textview);

        estimatedAgeTitle.setText(Retirement.ESTIMATED_AGE);
        estimatedAgeValue.setText("73");
        estimatedIncomeTitle.setText(Retirement.ESTIMATED_INCOME);
        estimatedIncomeValue.setText("35,000");
    }

    private void createArrayLists() {
        assetArrayList.add(new Asset("TD Checking", 29845));
        assetArrayList.add(new Asset("Ameritrade Roth IRA", 58788));
        assetArrayList.add(new Asset("TD Emergency", 9000));

        debtArrayList.add(new Debt("'10 Stafford Loan", 5.6, 5278));
        debtArrayList.add(new Debt("'15 Auto Loan", 5.4, 15000));
        debtArrayList.add(new Debt("Citi Double Cash", 19, 1768));

        insuranceArrayList.add(new Insurance("Health", 1));
        insuranceArrayList.add(new Insurance("Renters", 1));
        insuranceArrayList.add(new Insurance("Disability", 0));
    }
}
