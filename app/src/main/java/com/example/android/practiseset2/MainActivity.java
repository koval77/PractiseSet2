package com.example.android.practiseset2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import java.util.Random;
import java.util.*;

public class MainActivity extends AppCompatActivity {
    int scoreTeamA=0;
    int scoreTeamB=0;
//    Random r2=new Random();
//    int r1=0;

//    r1.nextInt(56);
//    r1=(int)(Math.random()*3.0);
//    operand1Value = (int) (Math.random()*19.0) + 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // PASTE CODE YOU WANT TO TEST HERE

    }

    public void getQuestion(View view)
    {    Random r1=new Random();
        int pcn1=r1.nextInt(100);
        Random r2=new Random();
        int pcn2=r2.nextInt(100);
        TextView number1View = (TextView) findViewById(R.id.number_1);
        number1View.setText(String.valueOf(Integer.toBinaryString(pcn1)));
        TextView number2View = (TextView) findViewById(R.id.number_2);
        number2View.setText(String.valueOf(Integer.toBinaryString(pcn2)));
    }
    public void displayNumberOne(int score) {
        TextView number1View = (TextView) findViewById(R.id.number_1);
        number1View.setText(String.valueOf(score));
        TextView number2View = (TextView) findViewById(R.id.number_2);
        number2View.setText(String.valueOf(score));
    }
    public void displayNumberTwo(int score) {
        TextView number2View = (TextView) findViewById(R.id.number_2);
        number2View.setText(String.valueOf(score));
    }
    public void add2(View view){
        scoreTeamA=scoreTeamA+2;
        displayNumberOne(scoreTeamA);
    }
    public void free(View view){
        scoreTeamA=scoreTeamA+1;
        displayNumberOne((scoreTeamA));
    }
    public void add2B(View view){
        scoreTeamB=scoreTeamB+2;
        displayNumberTwo(scoreTeamB);
    }
    public void freeB(View view){
        scoreTeamB=scoreTeamB+1;
        displayNumberTwo((scoreTeamB));
    }
    public void check(View view){
        scoreTeamA=0;
        scoreTeamB=0;
        displayNumberTwo(scoreTeamB);
        displayNumberOne(scoreTeamA);
    }
}