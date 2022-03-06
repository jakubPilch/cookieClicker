package com.example.cookieclicker;

import androidx.appcompat.app.AppCompatActivity;
//import androidx.constraintlayout.solver.widgets.Helper;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.Image;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class Play extends AppCompatActivity {


public static TextView textViewScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play);

        Button buttonStats = (Button) findViewById(R.id.buttonPlayStats);
        Button buttonMenu = (Button) findViewById(R.id.buttonPlayMenu);
        Button buttonShop = (Button) findViewById(R.id.buttonPlayShop);
        textViewScore = (TextView) findViewById(R.id.textViewScore);
        TextView textViewPerSec = (TextView) findViewById(R.id.textViewPerSec);
        ImageButton imgButtonCookie = (ImageButton)  findViewById(R.id.imageButtonCookie);
        textViewScore.setText("Score: " + Data.score);
        textViewPerSec.setText(Data.autoClick + " per second");

        Thread thread = new Thread() {

            @Override
            public void run() {

                try {
                    while (true) {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Data.score = Data.score + Data.autoClick;
                                Data.totalScore = Data.totalScore + Data.autoClick;
                                textViewScore.setText("Score: " + Data.score);
                                textViewPerSec.setText(Data.autoClick + " per second");
                            }
                        });
                    }
                } catch (InterruptedException e) {
                }
            }
        };
            thread.start();



        buttonStats.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                Intent screen = new Intent(getApplicationContext(), Stats.class);
                startActivity(screen);
               thread.interrupt();
            }
        });


        buttonMenu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent screen = new Intent(getApplicationContext(), Menu.class);
                startActivity(screen);
               thread.interrupt();
            }
        });

        buttonShop.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent screen = new Intent(getApplicationContext(), Shop.class);
                startActivity(screen);
              thread.interrupt();
            }
        });
    }


    public void buttonKlik(View view) {
        TextView textViewScore = (TextView) findViewById(R.id.textViewScore);
        Data.score = Data.score + Data.perClick;
        Data.totalScore = Data.totalScore + Data.perClick;
        textViewScore.setText("Score: " + Data.score);


    }
}



