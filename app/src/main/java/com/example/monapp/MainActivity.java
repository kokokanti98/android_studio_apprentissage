package com.example.monapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private CheckBox CheckBoxHarry,CheckBoxMatrix,CheckBoxJoker;
    private RadioGroup rgMartialStatus;
    private android.widget.ProgressBar ProgressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Selection de chaque design par son ID
        CheckBoxHarry = findViewById(R.id.checkBoxHarry);
        CheckBoxMatrix = findViewById(R.id.checkBoxMatrix);
        CheckBoxJoker = findViewById(R.id.checkBoxJoker);
        rgMartialStatus = findViewById(R.id.RdgMaritalStatus);
        ProgressBar = findViewById(R.id.progress_bar);


        //appel de la fonction pour verifier le message toast sur checkbox Harry Potter
        Check_Checkbox(CheckBoxHarry);

        //Pour incrémenter la progress bar chq 1/2 seconde de 10
        //déclaration du thread
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0;i<10; i++){
                    //à chaque 1/2 seconde la progress bar est incrémentée de 10
                    ProgressBar.incrementProgressBy(10);
                    SystemClock.sleep(500);
                }
            }
        });

        //declenchement du thread
        thread.start();

        //Ici commence pour le radio Group

        //fonction évènement pour savoir quel button du radio group l'utilisateur a cliquer
        rgMartialStatus.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    //Si dans le cas où vous cliquer sur marriés affiche Vous etes maries
                    case R.id.rbMarried:
                        Toast.makeText(MainActivity.this, "Vous êtes Mariées", Toast.LENGTH_SHORT).show();
                        break;
                    //Si dans le cas où vous cliquer sur célibataire affiche Vous etes Célibataire
                    case R.id.rbSingle:
                        Toast.makeText(MainActivity.this, "Vous êtes Célibataire", Toast.LENGTH_SHORT).show();
                        //Affiche la progress Bar en chargement
                        ProgressBar.setVisibility(View.VISIBLE);
                        //Pour que la barre de progression soit à 100 pourcent
                        ProgressBar.setProgress(10);
                        break;
                    //Si dans le cas où vous cliquer sur en couple affiche Vous etes en couple
                    case R.id.rbRelationship:
                        Toast.makeText(MainActivity.this, "Vous êtes en couple", Toast.LENGTH_SHORT).show();
                        //Met la progress Bar en invisible
                        ProgressBar.setVisibility(View.GONE);
                        break;
                    default:
                        break;
                }
            }
        });
    }

   //fonction pour checker si un checkbox CheckBOX est cliquer
   // si c'est le cas afficher un short message toast sinon affiche un autre message toast
    public void Check_Checkbox(CheckBox CheckBOX){
        CheckBOX.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    Toast.makeText(MainActivity.this, "Vous avez regarder "+CheckBOX.getText().toString()+" Cool", Toast.LENGTH_SHORT).show();
                    //Pour la barre de progresse soit à 70 pourcent
                    ProgressBar.setProgress(70);
                }
                else{
                    Toast.makeText(MainActivity.this,"Vous devez regarder "+CheckBOX.getText().toString()+" un film super cool", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}