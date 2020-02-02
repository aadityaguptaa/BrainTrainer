package com.example.braintrainer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.IntentCompat;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    Random rand = new Random();
    int i3 = rand.nextInt(4);
    boolean isRunning = false;


    public void startOnClick(View view){

        Log.i("i3",i3+"");

        final Button startButton = (Button)findViewById(R.id.startButton);
        startButton.setVisibility(View.INVISIBLE);

        final TextView timerTextView = (TextView)findViewById(R.id.timerTextView);
        timerTextView.setVisibility(View.VISIBLE);

        TextView equationTextView = (TextView)findViewById(R.id.equationTextView);
        equationTextView.setVisibility(View.VISIBLE);

        TextView scoreTextView = (TextView)findViewById(R.id.scoreTextView);
        scoreTextView.setVisibility(View.VISIBLE);

        Button startButton1 = (Button) findViewById(R.id.button1);
        startButton1.setVisibility(View.VISIBLE);

        Button startButton2 = (Button)findViewById(R.id.button2);
        startButton2.setVisibility(View.VISIBLE);

        Button startButton3 = (Button)findViewById(R.id.button3);
        startButton3.setVisibility(View.VISIBLE);

        Button startButton4 = (Button)findViewById(R.id.button4);
        startButton4.setVisibility(View.VISIBLE);

        Random random = new Random();
        int i1 = random.nextInt(100);
        int i2 = random.nextInt(100);

        equationTextView.setText(i1 + " + " + i2);


        i3 += 1;
        String button = "button" + i3;
        int resID = getResources().getIdentifier(button, "id", getPackageName());
        Button newButton = (Button)findViewById(resID);
        newButton.setText(i1+i2 + "");


        for(int i = 1; i <= 4; i++){
            if(i == i3){
                continue;
            }
            else{
                String buttonnew = "button" + i;
                int resID1 = getResources().getIdentifier(buttonnew, "id", getPackageName());
                Button newButton1 = (Button)findViewById(resID1);
                newButton1.setText(random.nextInt(100) + "");
            }
        }

        scoreTextView.setText("0/0");


        new CountDownTimer(30000,1000){
            int time = 0;
            public void onTick(long millisecondsuntildone){
                time += 1;
                timerTextView.setText(30 - time + "s");
                isRunning = true;

            }

            public void onFinish(){

                startButton.setVisibility(View.VISIBLE);
                score = 0;
                total = 0;

            }
        }.start();



    }


    int score = 0;
    int total = 0;

    public void buttonClick(View view){
        if(isRunning){
        Button new1 = (Button)view;
        String tag = new1.getTag().toString();


        if(Integer.parseInt(tag) == i3){
            TextView scoreTextView = (TextView)findViewById(R.id.scoreTextView);
            score++;
            total++;
            scoreTextView.setText(score + "/" + total);

        }
        else {
            TextView scoreTextView = (TextView)findViewById(R.id.scoreTextView);
            total++;
            scoreTextView.setText(score + "/" + total);

        }


            i3 = rand.nextInt(4);
            i3 += 1;
            int i1 = rand.nextInt(100);
            int i2 = rand.nextInt(100);

            TextView equationTextView = (TextView)findViewById(R.id.equationTextView);
            equationTextView.setText(i1 + " + " + i2);

            String buttonnew = "button" + i3;
            int resID1 = getResources().getIdentifier(buttonnew, "id", getPackageName());
            Button answerButton1 = (Button)findViewById(resID1);
            answerButton1.setText(i1+i2 + "");

            for(int i = 1; i <= 4; i++){
                if(i == i3){
                    continue;
                }
                else{
                    String buttonnew1 = "button" + i;
                    int resID12 = getResources().getIdentifier(buttonnew1, "id", getPackageName());
                    Button newButton1 = (Button)findViewById(resID12);
                    newButton1.setText(rand.nextInt(100) + "");
                }
            }
        }

    }


}
