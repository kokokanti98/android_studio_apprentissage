package com.example.monapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onHelloBtnCicked(View view) {

        //Selection de design Textview
        TextView TxtMessage = findViewById(R.id.txtWelcome);
        //Changer le text dans TextView
        TxtMessage.setText("Hi everyone");

    }
}