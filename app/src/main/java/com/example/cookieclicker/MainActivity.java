package com.example.cookieclicker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Data.entryList.add(new Entry(Data.xOnChart,Data.totalScore));
        Data.xOnChart++;
        Thread threadUpdateList = new Thread() {

            @Override
            public void run() {

                try {
                    while (true) {
                        Thread.sleep(2000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Data.entryList.add(new Entry(Data.xOnChart,Data.totalScore));
                                Data.xOnChart++;
                            }
                        });
                    }
                } catch (InterruptedException e) {
                }
            }
        };

        threadUpdateList.start();
        Intent screen = new Intent(getApplicationContext(),Menu.class);
        startActivity(screen);

    }
}
