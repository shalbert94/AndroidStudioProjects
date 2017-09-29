package com.example.android.pennyworthtest.summaryAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.pennyworthtest.R;
import com.example.android.pennyworthtest.summaryObjects.Insurance;

import java.util.ArrayList;

/**
 * Created by shalom on 2017-06-13.
 */

public class InsuranceArrayAdapter extends ArrayAdapter<Insurance> {
    public InsuranceArrayAdapter(Context context, ArrayList<Insurance> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Insurance insuranceObject = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.summary_insurance_list_item, parent, false);
        }

        TextView title = (TextView) convertView.findViewById(R.id.summary_insurance_list_item_title_textview);
        ImageView existence = (ImageView) convertView.findViewById(R.id.summary_insurance_list_item_existance_imageview);

        title.setText(insuranceObject.getInsuranceType());
        existence.setImageResource(R.drawable.ic_check_circle_black_24dp);

        switch (insuranceObject.getExistance()) {
            case 0:
                existence.setVisibility(View.INVISIBLE);
                break;
            case 1:
                existence.setVisibility(View.VISIBLE);
                break;
        }

        return convertView;
    }
}
