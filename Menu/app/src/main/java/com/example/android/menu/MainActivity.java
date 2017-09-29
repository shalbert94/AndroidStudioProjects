package com.example.android.menu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void printToLogs(View view) {
        // Find first menu item TextView and print the text to the logs
        TextView firstItem = (TextView) findViewById(R.id.menu_item_1);
        //String logOne = (String) firstItem.getText();
        //Log.v("MainActivity.java", logOne);
        Log.v("MainActivity.java", firstItem.getText().toString());

        // Find second menu item TextView and print the text to the logs
        TextView secondItem = (TextView) findViewById(R.id.menu_item_2);
        //String logTwo = (String) secondItem.getText();
        //Log.v("MainActivity.java", logTwo);
        Log.v("MainActivity.java", secondItem.getText().toString());

        // Find third menu item TextView and print the text to the logs
        TextView thirdItem = (TextView) findViewById(R.id.menu_item_3);
        //String logThree = (String) thirdItem.getText();
        //Log.v("MainActivity.java", logThree);
        Log.v("MainActivity.java", thirdItem.getText().toString());
    }
}