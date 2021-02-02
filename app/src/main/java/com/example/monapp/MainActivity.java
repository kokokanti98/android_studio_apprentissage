package com.example.monapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private ConstraintLayout parent;
    private Button BtnshowSnackBar;
    private MaterialCardView CardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Selection
        BtnshowSnackBar = findViewById(R.id.btnshowsnackbar);
        parent = findViewById(R.id.parent);
        CardView = findViewById(R.id.Cardview);

        //button onclick event du Cardview
        CardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"La CardView a été Cliqué",Toast.LENGTH_SHORT).show();
            }
        });

        //button onclick event du boutton
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
