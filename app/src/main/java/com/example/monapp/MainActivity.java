package com.example.monapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ConstraintLayout parent;
    private Button BtnshowSnackBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Selection
        BtnshowSnackBar = findViewById(R.id.btnshowsnackbar);
        parent = findViewById(R.id.parent);

        //button onclick event
        BtnshowSnackBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowSnackbar();
            }
        });
    }

    private void ShowSnackbar(){
        Snackbar.make(parent,"Ceci est un Snackbar",Snackbar.LENGTH_SHORT)
                //Action a déclencher qu'on on clique sur Réessayez afficher Réeesayez cliqué
                .setAction("Réessayez", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this,"Réessayez cliqué",Toast.LENGTH_SHORT).show();
                    }
                })
                //colore en rouge le message clicquable réeesayez
                .setActionTextColor(Color.RED)
                //colore en jaune le texte messaage 'Ceci est un snackbar'
                .setTextColor(Color.YELLOW)
                .show();
    }
}
