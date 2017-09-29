package com.example.android.pennyworthtest.summaryObjects;

/**
 * Created by shalom on 2017-06-07.
 * Contains all information needed in relaiton to displaying Assets on SummaryFragment UI
 */

public class Asset {
    private String accountName;
    private int accountBalance;

    /**
     * @param accountName Name of asset (e.g. the accounts name)
     * @param accountBalance Balance in the account
     */
    public Asset(String accountName, int accountBalance) {
        this.accountName = accountName;
        this.accountBalance = accountBalance;
    }

    public String getAccountName() {
        return accountName;
    }

    public int getAccountBalance() {
        return accountBalance;
    }
}
