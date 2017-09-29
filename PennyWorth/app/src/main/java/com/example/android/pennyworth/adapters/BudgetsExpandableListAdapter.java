package com.example.android.pennyworth.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.android.pennyworth.R;
import com.example.android.pennyworth.budgetsObjects.BudgetsChild;
import com.example.android.pennyworth.budgetsObjects.BudgetsGroup;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Used for creating and populating ExpandableListView in budgets_fragment.xml
 */

//Must add an if statement for cases where client went over their budget in AmountLefts (must deduct from another budget and change color)

public class BudgetsExpandableListAdapter extends BaseExpandableListAdapter {
    private Context context;
    private ArrayList<BudgetsGroup> budgetGroup = new ArrayList<>();
    private HashMap<String, ArrayList<BudgetsChild>> budgetChild = new HashMap<>();

    /**
     * @param context BudgetsFragment's getContext() method
     * @param budgetGroup List of budget titles (i.e. Weekly, Monthly, or Goals) along with their data
     * @param budgetChild Map using budget's title for a Key which points to an ArrayList composed of BudgetsChild objects
     */
    public BudgetsExpandableListAdapter(Context context, ArrayList<BudgetsGroup> budgetGroup, HashMap<String, ArrayList<BudgetsChild>> budgetChild) {
        this.context = context;
        this.budgetGroup = budgetGroup;
        this.budgetChild = budgetChild;
    }

//    Number of BudgetsGroup objects in budgetGroup
    @Override
    public int getGroupCount() {
        return this.budgetGroup.size();
    }

//    Number of BudgetsChild objects in budgetChild's ArrayList
    @Override
    public int getChildrenCount(int groupPosition) {
//        String budgetChildSize = String.valueOf(budgetGroup.);
//        Log.e(getClass().getSimpleName(), "budgetGroup value is: " + budgetChildSize);

        return this.budgetChild.get(budgetGroup.get(groupPosition).getTitle()).size();
    }

//    Returns one BudgetsGroup object located at groupPosition
    @Override
    public BudgetsGroup getGroup(int groupPosition) {
        return this.budgetGroup.get(groupPosition);
    }

//    Returns one ArrayList<BudgetsChild> whose key is found with this.budgetGroup.get(groupPosition).getTitle()
//    and selects the BudgetsChild object from the ArrayList located at childPosition
    @Override
    public BudgetsChild getChild(int groupPosition, int childPosition) {
        return this.budgetChild.get(this.budgetGroup.get(groupPosition).getTitle()).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

//    How budget_group_layout.xml will be populated
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        BudgetsGroup groupData = getGroup(groupPosition);

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.budget_group_layout, null);
        }

//        Create reference objects for textviews
        TextView groupTitle = (TextView) convertView.findViewById(R.id.budgets_group_title);
        TextView groupAmountLeft = (TextView) convertView.findViewById(R.id.budgets_group_amount_left);
        TextView groupBudgetSize = (TextView) convertView.findViewById(R.id.budgets_group_budget_size);
        ProgressBar groupProgressBar = (ProgressBar) convertView.findViewById(R.id.budgets_group_progressbar);

//        Format ints from Budgets object to be show with commas
        NumberFormat moneyFormatter = new DecimalFormat("###,###,###");
        String formattedAmountLeft = moneyFormatter.format(groupData.getAmountLeft());
        String formattedBudgetSize = moneyFormatter.format(groupData.getBudgetSize());
        String amountLeft = "$" + formattedAmountLeft + " left";
        String budgetSize = "$" + formattedBudgetSize;

//        Set what text will be displayed
        groupTitle.setText(groupData.getTitle());
        groupAmountLeft.setText(amountLeft);
        groupBudgetSize.setText(budgetSize);

//        Set what the progress bar will didsplay
        groupProgressBar.setVisibility(View.VISIBLE);
        groupProgressBar.setMax(100);
        groupProgressBar.setProgress(groupData.getAmountSpent());
        groupProgressBar.setSecondaryProgress(groupData.getAmountSpent());

        return convertView;
    }

//    How budget_child_item_layout.xml will be populated
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final BudgetsChild childData = getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.budget_child_item_layout, null);
        }

        ProgressBar childProgressBar = (ProgressBar) convertView.findViewById(R.id.budget_child_progress_bar);
        TextView childBudgetSize = (TextView) convertView.findViewById(R.id.budget_child_budget_size);
        TextView childTitle = (TextView) convertView.findViewById(R.id.budget_child_title);
        TextView childAmountLeft = (TextView) convertView.findViewById(R.id.budget_child_amount_left);

        //        Format ints from Budgets object to be show with commas
        NumberFormat moneyFormatter = new DecimalFormat("###,###,###");
        String formattedAmountLeft = moneyFormatter.format(childData.getAmountLeft());
        String formattedBudgetSize = moneyFormatter.format(childData.getBudgetSize());
        String amountLeft = "$" + formattedAmountLeft + " left";
        String budgetSize = "$" + formattedBudgetSize + " left";


        childProgressBar.setVisibility(View.VISIBLE);
        childProgressBar.setMax(100);
        childProgressBar.setProgress(childData.getAmountSpent());
        childProgressBar.setSecondaryProgress(childData.getAmountSpent());

        childBudgetSize.setText(budgetSize);
        childTitle.setText(childData.getTitle());
        childAmountLeft.setText(amountLeft);

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

}
