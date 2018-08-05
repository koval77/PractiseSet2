package com.example.android.practiseset2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int scoreTeamA=0;
    int scoreTeamB=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // PASTE CODE YOU WANT TO TEST HERE

    }

    /**
     * Display methods that allow the text to appear on the screen. Don't worry if you don't know
     * how these work yet. We'll be covering them in lesson 3.
     */

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }
    public void add3(View view){
        scoreTeamA=scoreTeamA+3;
        displayForTeamA(scoreTeamA);
    }
    public void add2(View view){
        scoreTeamA=scoreTeamA+2;
        displayForTeamA(scoreTeamA);
    }
    public void free(View view){
        scoreTeamA=scoreTeamA+1;
        displayForTeamA((scoreTeamA));
    }
    public void add3B(View view){
        scoreTeamB=scoreTeamB+3;
        displayForTeamB(scoreTeamB);
    }
    public void add2B(View view){
        scoreTeamB=scoreTeamB+2;
        displayForTeamB(scoreTeamB);
    }
    public void freeB(View view){
        scoreTeamB=scoreTeamB+1;
        displayForTeamB((scoreTeamB));
    }
    public void reset(View view){
        scoreTeamA=0;
        scoreTeamB=0;
        displayForTeamB(scoreTeamB);
        displayForTeamA(scoreTeamA);
    }
}