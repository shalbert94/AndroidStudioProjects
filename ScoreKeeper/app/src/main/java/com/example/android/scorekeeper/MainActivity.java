package com.example.android.scorekeeper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int blueJayRuns;
    int blueJayOuts;
    int oriolesRuns;
    int oriolesOuts;

    public void blueJaysRun(View view) {
        blueJayRuns++;
        displayBlueJaysRuns(blueJayRuns);
    }

    public void blueJaysOut(View view) {
        blueJayOuts++;
        displayBlueJaysOuts(blueJayOuts);
    }

    public void oriolesRun(View view) {
        oriolesRuns++;
        displayOriolesRuns(oriolesRuns);
    }

    public void oriolesOut(View view) {
        oriolesOuts++;
        displayOriolesOuts(oriolesOuts);
    }

    public void resetStats(View view) {
        blueJayOuts = 0;
        blueJayRuns = 0;
        oriolesOuts = 0;
        oriolesRuns = 0;

        displayBlueJaysOuts(blueJayOuts);
        displayBlueJaysRuns(blueJayRuns);
        displayOriolesOuts(oriolesOuts);
        displayOriolesRuns(oriolesRuns);
    }

    public void displayBlueJaysRuns(int run) {
        TextView runs = (TextView) findViewById(R.id.blue_jays_runs);
        runs.setText(run + "");
    }

    public void displayBlueJaysOuts(int out) {
        TextView outs = (TextView) findViewById(R.id.blue_jays_outs);
        outs.setText(out + "");
    }

    public void displayOriolesRuns(int run) {
        TextView runs = (TextView) findViewById(R.id.orioles_runs);
        runs.setText(run + "");
    }

    public void displayOriolesOuts(int out) {
        TextView outs = (TextView) findViewById(R.id.orioles_outs);
        outs.setText(out + "");
    }
}
