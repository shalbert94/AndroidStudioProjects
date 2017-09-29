package com.example.android.pennyworthtest.summaryObjects;

/**
 * Created by shalom on 2017-06-07.
 * Contains all information needed in relation to displaying Debts on SummaryFragment UI
 */

//Determine if we should show "remaining principle" or "remaining amount to be paid" which includes interest

public class Debt {
    private String debtName;
    private double interestRate;
    private int debtBalance;

    /**
     * @param debtName Name of the debt (e.g. JPMorgan Chase & Co.)
     * @param interestRate The debt's interest rate
     * @param debtBalance Remaining principle owed to lender
     */
    public Debt(String debtName, double interestRate, int debtBalance) {
        this.debtName = debtName;
        this.interestRate = interestRate;
        this.debtBalance = debtBalance;
    }

    public String getDebtName() {
        return debtName;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public int getDebtBalance() {
        return debtBalance;
    }
}
