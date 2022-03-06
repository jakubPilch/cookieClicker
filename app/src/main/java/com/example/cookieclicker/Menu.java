package com.example.cookieclicker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        Button buttonPlay = (Button)findViewById(R.id.buttonMenuPlay);
        Button buttonShop = (Button)findViewById(R.id.buttonMenuShop);
        Button buttonStats = (Button)findViewById(R.id.buttonMenuStats);

        buttonStats.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent screen = new Intent(getApplicationContext(),Stats.class);
                startActivity(screen);
            }
        });

        buttonPlay.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                try{
                    Intent play = new Intent(getApplicationContext(),Play.class);
                    startActivity(play);
                }
                catch (Exception e){
                    Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
                }

            }
        });

        buttonShop.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent screen = new Intent(getApplicationContext(),Shop.class);
                startActivity(screen);
            }
        });

    }
}

