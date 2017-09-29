package com.example.android.quizapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Run when test is submitted
    public void submit(View view) {
       displayToast();
    }

    private String calculateScore() {
        //RadioButton's for the answers of each question
        RadioButton one = (RadioButton) findViewById(R.id.question_one_answer);
        RadioButton two = (RadioButton) findViewById(R.id.question_two_answer);
        RadioButton three = (RadioButton) findViewById(R.id.question_three_answer);
        RadioButton four = (RadioButton) findViewById(R.id.question_four_answer);
        RadioButton five = (RadioButton) findViewById(R.id.question_five_answer);

        boolean[] answerGrid = {one.isChecked(), two.isChecked(), three.isChecked(),
                four.isChecked(), five.isChecked()};

        int score = 0;

        for (boolean answer : answerGrid) {
            if (answer == true) {
                score++;
            }
        }

        return "You scored " + score + " out of 5";
    }

    private void displayToast() {
        Context context = getApplicationContext();
        CharSequence text = calculateScore();
        int duration = Toast.LENGTH_LONG;
        Toast.makeText(context,text, duration).show();
    }
}
