package com.example.monapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView TxtHello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Selection
        TxtHello = findViewById(R.id.txtHello);

        //le string hello est sur /src/main/res/values/strings.xml
        //clic droit sur values->new->valuesRessources files->local->ex:german
        //le fichier doit avoir le meme nom ici c'est strings.xml
        TxtHello.setText(getString(R.string.hello));

    }
}
