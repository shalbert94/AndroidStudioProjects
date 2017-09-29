package com.example.android.pennyworth.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.pennyworth.R;
import com.example.android.pennyworth.recommendationsObjects.Recommendation;

import java.util.ArrayList;

/**
 * Adapts an ArrayList composed of Recommendation objects and makes them displayable on RecommendationsFragment
 */

public class RecommendationsArrayAdapter extends ArrayAdapter<Recommendation> {

    //    imageResourceID is Resource ID for the image displayed beside list item (e.g. for a credit card vector)
    private int imageResourceId;

    /**
     * Required for attaining Recommendation data
     * @param context RecommendationFragment's getContext() method
     * @param objects An ArrayList composed of Recommendation objects
     */
    public RecommendationsArrayAdapter(Context context, ArrayList<Recommendation> objects) {
        super(context, 0, objects);
    }

//    Adapts the ArrayList's object's variables to views
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final Recommendation recommendationObject = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.recommendations_list_item, parent, false);
        }

//        Each view references recommendations_list_item.xml
        ImageView listItemIcon = (ImageView) convertView.findViewById(R.id.recommendation_list_item_icon);
        TextView listItemHeading = (TextView) convertView.findViewById(R.id.recommendation_list_item_heading);
        TextView listItemBenefit = (TextView) convertView.findViewById(R.id.recommendation_list_item_benefit);
        TextView listItemDetails = (TextView) convertView.findViewById(R.id.recommendation_list_item_details);

        setImageResourceId(recommendationObject.getHeading());

        listItemIcon.setImageResource(getImageResourceId());
        listItemHeading.setText(recommendationObject.getHeading());
        listItemBenefit.setText(recommendationObject.getBenefit());
        listItemDetails.setText(recommendationObject.getDetails());

        return convertView;
    }

//    Cases & icons should be chnaged
    private void setImageResourceId(String listItemHeading) {

        switch (listItemHeading) {
            case "Credit Cards":
                imageResourceId = R.drawable.ic_credit_card_black_24dp;
                break;
            case "Debt":
                imageResourceId = R.drawable.ic_trending_down_black_24dp;
                break;
            case "Disability Insurance":
                imageResourceId = R.drawable.ic_warning_black_24dp;
                break;
            case "Transfer":
                imageResourceId = R.drawable.ic_transform_black_24dp;
                break;
        }
    }

    private int getImageResourceId() {
        return imageResourceId;
    }
}

