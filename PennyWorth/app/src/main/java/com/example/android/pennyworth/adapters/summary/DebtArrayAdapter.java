package com.example.android.pennyworth.adapters.summary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.android.pennyworth.R;
import com.example.android.pennyworth.summaryObjects.Debt;

import java.util.ArrayList;

/**
 * Created by shalom on 2017-06-13.
 */

public class DebtArrayAdapter extends ArrayAdapter<Debt>{
    public DebtArrayAdapter(Context context, ArrayList<Debt> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Debt debtObject = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.summary_popular_list_item, parent, false);
        }

        TextView title = (TextView) convertView.findViewById(R.id.summary_popular_list_item_title_textview);
        TextView balance = (TextView) convertView.findViewById(R.id.summary_popular_list_item_value_textview);

        String debtBalance = String.valueOf(debtObject.getDebtBalance());

        title.setText(debtObject.getDebtName() + " (" + debtObject.getInterestRate() + "%)");
        balance.setText(debtBalance);

        return convertView;
    }
}
