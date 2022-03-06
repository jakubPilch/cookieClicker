package com.example.cookieclicker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Shop extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop);

        Button buttonPlay = (Button)findViewById(R.id.buttonShopPlay);
        Button buttonMenu = (Button)findViewById(R.id.buttonShopMenu);
        Button buttonStats = (Button)findViewById(R.id.buttonShopStats);
        Button buttonDoubleClick = (Button)findViewById(R.id.buttonDoubleClick);
        Button buttonTrippleClick = (Button)findViewById(R.id.buttonTrippleClick);
        Button buttonCLick5x = (Button)findViewById(R.id.buttonClick5x);
        Button buttonOneMore = (Button)findViewById(R.id.buttonOneMore);
        Button buttonTwoMore = (Button)findViewById(R.id.buttonTwoMore);
        Button buttonFiveMore = (Button)findViewById(R.id.buttonFiveMore);

        buttonDoubleClick.setText("Double Click (cost: " +Data.doubleClickCost+" cookies");
        buttonTrippleClick.setText("Tripple Click (cost: " +Data.trippleClickCost+" cookies");
        buttonCLick5x.setText("Click x5!! (cost: " +Data.clickX5Cost+" cookies");
        buttonOneMore.setText("+1 per second (cost: " +Data.oneMoreCost+" cookies");
        buttonTwoMore.setText("+2 per second (cost: " +Data.twoMoreCost+" cookies");
        buttonFiveMore.setText("+5 per second (cost: " +Data.fiveMoreCost+" cookies");

        buttonStats.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent screen = new Intent(getApplicationContext(),Stats.class);
                startActivity(screen);
            }
        });


        buttonMenu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent screen = new Intent(getApplicationContext(),Menu.class);
                startActivity(screen);
            }
        });

        buttonPlay.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent screen = new Intent(getApplicationContext(),Play.class);
                startActivity(screen);
            }
        });

        buttonDoubleClick.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(Data.score >= Data.doubleClickCost) {
                    Data.perClick = Data.perClick * 2;
                    Data.score = Data.score - Data.doubleClickCost;
                    Data.cookiesSpent += Data.doubleClickCost;
                    Data.doubleClickCost *= 1.85;
                    buttonDoubleClick.setText("Double Click (cost: " +Data.doubleClickCost+" cookies");

                }
                else{
                    Toast.makeText(getApplicationContext(), "You don't have enough cookies", Toast.LENGTH_LONG).show();
                }
            }
        });
        buttonTrippleClick.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View v) {
                    if(Data.score >= Data.trippleClickCost) {
                        Data.perClick = Data.perClick * 3;
                        Data.score = Data.score - Data.trippleClickCost;
                        Data.cookiesSpent += Data.trippleClickCost;
                        Data.trippleClickCost *= 1.85;
                        buttonTrippleClick.setText("Tripple Click (cost: " +Data.trippleClickCost+" cookies");
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "You don't have enough cookies", Toast.LENGTH_LONG).show();
                    }
                };

        });
        buttonCLick5x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Data.score >= Data.clickX5Cost) {
                    Data.perClick = Data.perClick * 5;
                    Data.score = Data.score - Data.clickX5Cost;
                    Data.cookiesSpent += Data.clickX5Cost;
                    Data.clickX5Cost *= 1.85;
                    buttonCLick5x.setText("Click x5!! (cost: " +Data.clickX5Cost+" cookies");
                }
                else{
                    Toast.makeText(getApplicationContext(), "You don't have enough cookies", Toast.LENGTH_LONG).show();
                }
            }
        });

        buttonOneMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Data.score >= Data.oneMoreCost) {
                    Data.autoClick = Data.autoClick + 1;
                    Data.score = Data.score - Data.oneMoreCost;
                    Data.cookiesSpent += Data.oneMoreCost;
                    Data.oneMoreCost *= 1.85;
                    buttonOneMore.setText("+1 per second (cost: " +Data.oneMoreCost+" cookies");
                }
                else{
                    Toast.makeText(getApplicationContext(), "You don't have enough cookies", Toast.LENGTH_LONG).show();
                }
            }
        });
        buttonTwoMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Data.score >= Data.twoMoreCost) {
                    Data.autoClick = Data.autoClick + 2;
                    Data.score = Data.score - Data.twoMoreCost;
                    Data.cookiesSpent += Data.twoMoreCost;
                    Data.twoMoreCost *= 1.85;
                    buttonTwoMore.setText("+2 per second (cost: " +Data.twoMoreCost+" cookies");
                }
                else{
                    Toast.makeText(getApplicationContext(), "You don't have enough cookies", Toast.LENGTH_LONG).show();
                }
            }
        });
        buttonFiveMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Data.score >= Data.fiveMoreCost) {
                    Data.autoClick = Data.autoClick + 5;
                    Data.score = Data.score - Data.fiveMoreCost;
                    Data.cookiesSpent += Data.fiveMoreCost;
                    Data.fiveMoreCost *= 1.85;
                    buttonFiveMore.setText("+5 per second (cost: " + Data.fiveMoreCost + " cookies");
                } else {
                    Toast.makeText(getApplicationContext(), "You don't have enough cookies", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
