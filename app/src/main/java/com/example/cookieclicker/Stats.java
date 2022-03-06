package com.example.cookieclicker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class Stats extends AppCompatActivity {
    LineChart lineChart;
    LineData lineData;
    //ArrayList<Entry> entryList = new ArrayList<>();
    int i=0;
        public int valueOnChart=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stats);




        Button buttonPlay = (Button)findViewById(R.id.buttonStatsPlay);
        Button buttonMenu = (Button)findViewById(R.id.buttonStatsMenu);
        Button buttonShop = (Button)findViewById(R.id.buttonStatsShop);
        Button buttonDatabase = (Button)findViewById(R.id.buttonSaveToDatabase);
        TextView textViewTotalScore = (TextView) findViewById(R.id.textViewTotalScore);
        TextView textViewCookiesSpent = (TextView)findViewById(R.id.textViewCookiesSpent);
        LineChart lineChart = (LineChart) findViewById(R.id.lineChart);
        try{textViewTotalScore.setText("Total score: "+Data.totalScore);
            textViewCookiesSpent.setText("Cookies spent: "+Data.cookiesSpent);}catch (Exception e){e.getMessage();}

        LineDataSet lineDataSet = new LineDataSet(Data.entryList,"Score per minute");
        lineDataSet.setFillAlpha(110);
        lineDataSet.setColor(Color.rgb(64, 54, 45));
        lineDataSet.setCircleColor(Color.rgb(64, 54, 45));
        lineDataSet.setLineWidth(3);
        lineData = new LineData(lineDataSet);
        lineData.setValueTextSize(15);
        lineChart.getDescription().setEnabled(false);
        lineChart.setData(lineData);
        lineChart.invalidate();

        Thread threadChart = new Thread() {

            @Override
            public void run() {

                try {
                    while (true) {
                        Thread.sleep(500);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                try{LineDataSet lineDataSet = new LineDataSet(Data.entryList,"Score per minute");
                                    lineDataSet.setFillAlpha(110);
                                    lineDataSet.setColor(Color.rgb(64, 54, 45));
                                    lineDataSet.setCircleColor(Color.rgb(64, 54, 45));
                                    lineDataSet.setLineWidth(3);
                                    lineData = new LineData(lineDataSet);
                                    lineData.setValueTextSize(15);
                                    lineChart.getDescription().setEnabled(false);
                                    lineChart.setData(lineData);
                                    lineChart.invalidate();}
                                catch (Exception e){Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();}

                            }
                        });
                    }
                } catch (InterruptedException e) {
                }
            }
        };

        threadChart.start();


        buttonDatabase.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                SQLiteDatabase baza = openOrCreateDatabase("baza1.db", Context.MODE_PRIVATE, null);
                ContentValues rekord = new ContentValues();
               // rekord.put("", String.valueOf(textViewTotalScore.getText()));
                //rekord.put("", String.valueOf(textViewCookiesSpent.getText()));
                baza.execSQL("CREATE TABLE IF NOT EXISTS 'cookieStats' (idStats Integer PRIMARY KEY, total_score  STRING, cookies_spent STRING)");
                baza.execSQL("INSERT INTO cookieStats (total_score,cookies_spent)Values('"+String.valueOf(Data.totalScore)+"','"+String.valueOf(Data.totalScore)+"');");
                //baza.insert("cookieStats", null, rekord);
            }
        });


        buttonPlay.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                threadChart.interrupt();
                Intent play = new Intent(getApplicationContext(),Play.class);
                startActivity(play);
            }
        });

        buttonMenu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                threadChart.interrupt();
                Intent screen = new Intent(getApplicationContext(),Menu.class);
                startActivity(screen);
            }
        });

        buttonShop.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                threadChart.interrupt();
                Intent screen = new Intent(getApplicationContext(),Shop.class);
                startActivity(screen);
            }
        });

    }



}
