package com.example.monapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView TxtMessage;
    private EditText EditTxtMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Selection du bouton Hello
        Button Btnhello = findViewById(R.id.btnHello);

        //Selection des textview et editview
        TxtMessage = findViewById(R.id.txtHello);
        EditTxtMessage = findViewById(R.id.editTxtHello);


        //va declencer la fonction onclick sur ce design
        Btnhello.setOnClickListener(this);

        //pour déclencer dans le cas ou on clique sur editTXThello
        EditTxtMessage.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
       switch (v.getId()){
           //Dans le cas où id du view est le button donc on a cliquer sur button
           case R.id.btnHello:
               TxtMessage.setText("Hello "+EditTxtMessage.getText().toString());
               break;
           //Dans le cas où id du view est l'id du EditTXTMessage donc on a cliquer sur EditTxtView
           case R.id.editTxtHello:
               //affiche un message de courte durée
                Toast.makeText(this,"En train d'ecrire", Toast.LENGTH_SHORT).show();
                break;
           //cas par defaut
           default:
               break;
       }
    }
}