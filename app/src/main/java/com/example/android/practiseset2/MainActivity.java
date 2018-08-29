package com.example.android.practiseset2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.FocusFinder;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
        EditText result=(EditText)findViewById(R.id.result);
        result.requestFocus();
        // PASTE CODE YOU WANT TO TEST HERE

    }

    public void getQuestion(View view)
    {    Random r1=new Random();
        int pcn1=r1.nextInt(100);
        Random r2=new Random();
        int pcn2=r2.nextInt(100);
        Random r3=new Random();
        int pcn3=r3.nextInt(100);
        Random r4=new Random();
        int pcn4=r4.nextInt(pcn3);
        Random r5=new Random();
        int pcn5=r5.nextInt(100);
        Random r6=new Random();
        int pcn6=r6.nextInt(100);
        TextView number1View = (TextView) findViewById(R.id.number_1);
        number1View.setText(String.valueOf(Integer.toBinaryString(pcn1)));
        TextView number2View = (TextView) findViewById(R.id.number_2);
        number2View.setText(String.valueOf(Integer.toBinaryString(pcn2)));
        EditText result=(EditText)findViewById(R.id.result);
        result.setText("");
        TextView number3View = (TextView) findViewById(R.id.number_3);
        number3View.setText(String.valueOf(Integer.toBinaryString(pcn3)));
        TextView number4View = (TextView) findViewById(R.id.number_4);
        number4View.setText(String.valueOf(Integer.toBinaryString(pcn4)));
        EditText results=(EditText)findViewById(R.id.resultS);
        results.setText("");
        TextView number5View = (TextView) findViewById(R.id.number_5);
        number5View.setText(String.valueOf(Integer.toBinaryString(pcn5)));
        TextView number6View = (TextView) findViewById(R.id.number_6);
        number6View.setText(String.valueOf(Integer.toBinaryString(pcn6)));
        EditText resultm=(EditText)findViewById(R.id.resultM);
        resultm.setText("");
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
    public void insert1(View view){
        EditText result=(EditText)getCurrentFocus();
        result.append("1");
    }
    public void free(View view){
        scoreTeamA=scoreTeamA+1;
        displayNumberOne((scoreTeamA));
    }
    public void insert0(View view){
//        EditText result=(EditText)findViewById(R.id.result);
        EditText result=(EditText)getCurrentFocus();
        result.append("0");
    }
    public boolean checkAdd(View view){
        TextView num1=(TextView)findViewById(R.id.number_1);
        TextView num2=(TextView)findViewById(R.id.number_2);
        EditText res=(EditText)findViewById(R.id.result);
        EditText ress=(EditText)findViewById(R.id.resultS);
        String n1=num1.getText().toString();
        int nn1=Integer.parseInt(n1,2);
        String n2=num2.getText().toString();
        int nn2=Integer.parseInt(n2,2);
        String r1=res.getText().toString();
        int rr1=Integer.parseInt(r1,2);
        if (nn1+nn2==rr1)
        {
            Toast.makeText(getApplicationContext(),"Yes!You are right!!!",Toast.LENGTH_SHORT).show();
            ress.requestFocus();
            return true;
        }
        else
        {
            Toast.makeText(getApplicationContext(),"No, sorry, you are wrong :(",Toast.LENGTH_SHORT).show();
            return false;
        }
    }
    public boolean checkSub(View view){
        TextView num3=(TextView)findViewById(R.id.number_3);
        TextView num4=(TextView)findViewById(R.id.number_4);
        EditText resm=(EditText)findViewById(R.id.resultS);
        String n3=num3.getText().toString();
        int nn3=Integer.parseInt(n3,2);
        String n4=num4.getText().toString();
        int nn4=Integer.parseInt(n4,2);
        String r2=resm.getText().toString();
        int rr2=Integer.parseInt(r2,2);
        if (nn3-nn4==rr2)
        {
            Toast.makeText(getApplicationContext(),"Yes!You are right!!!",Toast.LENGTH_SHORT).show();
            return true;
        }
        else
        {
            Toast.makeText(getApplicationContext(),"No, sorry, you are wrong :(",Toast.LENGTH_SHORT).show();
            return false;
        }
    }
    public boolean checkMult(View view) {
        TextView num5 = (TextView) findViewById(R.id.number_5);
        TextView num6 = (TextView) findViewById(R.id.number_6);
        EditText resm = (EditText) findViewById(R.id.resultM);
        String n5 = num5.getText().toString();
        int nn5 = Integer.parseInt(n5, 2);
        String n6 = num6.getText().toString();
        int nn6 = Integer.parseInt(n6, 2);
        String r3 = resm.getText().toString();
        int rr3 = Integer.parseInt(r3, 2);
        if (nn5 * nn6 == rr3) {
            Toast.makeText(getApplicationContext(), "Yes!You are right!!!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(getApplicationContext(), "No, sorry, you are wrong :(", Toast.LENGTH_SHORT).show();
            return false;
        }
    }
    public void check(View view){
        scoreTeamA=0;
        scoreTeamB=0;
        displayNumberTwo(scoreTeamB);
        displayNumberOne(scoreTeamA);
    }
}