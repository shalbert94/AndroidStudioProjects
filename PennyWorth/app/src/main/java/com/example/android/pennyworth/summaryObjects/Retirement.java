package com.example.android.pennyworth.summaryObjects;

/**
 * Created by shalom on 2017-06-07.
 * Contains all information needed in relaiton to displaying Retirement information on SummaryFragment UI
 */

public class Retirement {
    public static final String ESTIMATED_AGE = "Estimated Age";
    public static final String ESTIMATED_INCOME = "Estimated Income";
    private int ageEstimated;
    private int incomeEstimated;

    /**
     * @param ageEstimated Estimated age at which the client will be retired
     * @param incomeEstimated Estimated annual income the client will receive during retirement
     */
    public Retirement(int ageEstimated, int incomeEstimated) {
        this.ageEstimated = ageEstimated;
        this.incomeEstimated = incomeEstimated;
    }

    public int getAgeEstimated() {
        return ageEstimated;
    }

    public int getIncomeEstimated() {
        return incomeEstimated;
    }
}
