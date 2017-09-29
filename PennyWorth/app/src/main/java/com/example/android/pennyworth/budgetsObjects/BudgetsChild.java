package com.example.android.pennyworth.budgetsObjects;

/**
 * Created by shalom on 2017-06-02.
 * Used for creating a BudgetsGroup object which contains all the information required for
 * the BudgetsExpandableListAdapter
 */

public class BudgetsChild {
    private String title;
    private int amountLeft;
    private int amountSpent;
    private int budgetSize;

    /**
     * @param title Title of budget child
     * @param amountLeft Amount of the budget that is unspent
     * @param amountSpent Amount of the budget that is spent
     * @param budgetSize Size of the budget
     */
    public BudgetsChild(String title, int amountLeft, int amountSpent, int budgetSize) {
        this.title = title;
        this.amountLeft = amountLeft;
        this.amountSpent = amountSpent;
        this.budgetSize = budgetSize;
    }

    public String getTitle() {
        return title;
    }

    public int getAmountLeft() {
        return amountLeft;
    }

    public int getAmountSpent() {
        return amountSpent;
    }

    public int getBudgetSize() {
        return budgetSize;
    }
}
