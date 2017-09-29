package com.example.android.pennyworthtest.summaryObjects;

import com.example.android.pennyworthtest.R;

/**
 * Created by shalom on 2017-06-07.
 * Contains all information needed in relaiton to displaying Insurances on SummaryFragment UI
 */

public class Insurance {
    private String insuranceType;
    private int existance;
    public final static int checkCircleImageResource = R.drawable.ic_check_circle_black_24dp;

    /**
     * @param insuranceType Type of insurance (e.g. automotive, homeowners, disability, etc.)
     * @param existance Binary indicator for  whether client has the named type of insurance
     */
    public Insurance(String insuranceType, int existance) {
        this.insuranceType = insuranceType;
        this.existance = existance;
    }

    public String getInsuranceType() {
        return insuranceType;
    }

    public int getExistance() {
        return existance;
    }
}
