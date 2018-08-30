package com.example.android.practiseset2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

/*Class definition for MainActivity which is extension (so we can use inherited methods for example findViewbyId)
 of AppCompatActivity. I have made global variable for points*/
public class MainActivity extends AppCompatActivity {
    private Handler handler = new Handler();
    int points=0;
/*By using override, it is possible to modify inherited methods from super class. I add here method for moving the focus to first answer view
* after starting the application.*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText result=(EditText)findViewById(R.id.result);
        result.requestFocus();
    }
    /*This method is generating pseudo-random numbers, converts them to binary and put on the right places.*/
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
        final EditText result=(EditText)findViewById(R.id.result);
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
        /*Creating ProgressBar object*/
        final ProgressBar prbr=findViewById(R.id.progressBar);
        prbr.setBackgroundColor(Color.YELLOW);
        prbr.setMax(115);
        final int[] progressStatus = {0};
        //Long operation by thread
        new Thread(new Runnable() {
            public void run() {
                while (progressStatus[0] < 100) {
                    progressStatus[0] += 4;
                    //Update progress bar with completion of operation
                    handler.post(new Runnable() {
                        public void run() {
                            prbr.setProgress(progressStatus[0]);
                        }
                    });
                    try {
                      /*   Sleep for 300 milliseconds.
                        Just to display the progress slowly*/
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace(); }
                        }
                        }
        }).start();
    }
    /*Method for displaying points. The casting which I have used here is not actually  necessary since API 26 and
    I could have delete it safely. */
    public void displayPoints(int points) {
        TextView number1View = (TextView) findViewById(R.id.pointshere);
        number1View.setText(String.valueOf(points));
    }
    /*In this method, method append is entering answer to the result edit views (0 in this case).*/
    public void insert1(View view){
        EditText result=(EditText)getCurrentFocus();
        result.append("1");
    }
    public void points(View view){
    }
    public void insert0(View view){
        EditText result=(EditText)getCurrentFocus();
        result.append("0");
    }
/*    This method read the text values from addition text views and converting them to decimals.
    In the conditional statement it check if the outcome is right, if it is Toast object is created
    using factory method, (not the constructor in this case) to display short message. Points are updated
    * and displayed, focus is moved to the next text view. This scenario ends by returning the true value (I have used it for testing).
    * If the calculation is wrong, another Toast is displayed and method return false value.*/
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
            points=points+10;
            displayPoints(points);
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
        EditText resmm=(EditText)findViewById(R.id.resultM);
        String n3=num3.getText().toString();
        int nn3=Integer.parseInt(n3,2);
        String n4=num4.getText().toString();
        int nn4=Integer.parseInt(n4,2);
        String r2=resm.getText().toString();
        int rr2=Integer.parseInt(r2,2);
        if (nn3-nn4==rr2)
        {
            Toast.makeText(getApplicationContext(),"Yes!You are right!!!",Toast.LENGTH_SHORT).show();
            points=points+50;
            displayPoints(points);
            resmm.requestFocus();
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
            points=points+100;
            displayPoints(points);
            return true;
        } else {
            Toast.makeText(getApplicationContext(), "No, sorry, you are wrong :(", Toast.LENGTH_SHORT).show();
            return false;
        }
    }
    public void checkAll(View view){
    }
/*Creates explicit intent object which is used to open another (help) activity.*/
    public void help(View view) {
        Intent intent = new Intent(MainActivity.this, HelpScreen.class);
        startActivity(intent);
    }
}