package com.example.android.pennyworth.recommendationsObjects;

/**
 * Created by shalom on 2017-06-01.
 * Used for creating recommendation objects which are composed of all information necessary for a single
 * recommendation list item
 * Indirectly used for displaying recommendations on RecommendationsFragment.java
 * Directly used by RecommendationsArrayAdapter.java
 */

public class Recommendation {

// Data points required for creating a Recommendations list item
    private String heading;
    private String benefit;
    private String details;


    /**
     * The following parameters define a single recommendation
     * @param heading List item's heading (e.g. the words "Credit Cards")
     * @param benefit The benefit that can be attained by folowing the recommendation
     * @param details Describes a) What the recommended action is, b) Why client should do it
     */
    public Recommendation(String heading, String benefit, String details) {
        this.heading = heading;
        this.benefit = benefit;
        this.details = details;
    }

    public String getHeading() {
        return heading;
    }

    public String getBenefit() {
        return benefit;
    }

    public String getDetails() {
        return details;
    }
}