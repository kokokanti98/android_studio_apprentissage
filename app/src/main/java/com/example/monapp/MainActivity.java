package com.example.monapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //initialisation
    private ListView CitiesList;
    private Spinner StudentSpinner;
    private Spinner HumourSpinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Selection
        CitiesList = findViewById(R.id.citiesList);
        StudentSpinner = findViewById(R.id.studentSpinner);

        HumourSpinner = findViewById(R.id.humourSpinner);


        //La liste de données string pour construire le spinner
        ArrayList<String> students = new ArrayList<String>();
        students.add("Mark");
        students.add("John");
        students.add("Zero");
        students.add("Marky");
        students.add("Beavel");


        //La liste des données string qu'on va utiliser pour construire le ListView
        ArrayList<String> cities = new ArrayList<>();
        cities.add("Paris");
        cities.add("Tamatave");
        cities.add("Tana");
        cities.add("Australie");
        cities.add("Majunga");
        cities.add("Rouen");

        //Pour prendre les données de la Liste de String
        //Pour le arraylist cities
        ArrayAdapter<String> citiesAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                //le données a prendre ici c'est l'ArrayList cities
                cities
        );

        //Pour arraylist  students
        ArrayAdapter<String> studentsAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                //le données a prendre ici c'est l'ArrayList students
                students
        );

        //mettre les donneées de la liste dans le ListView(après avoir faire le Adapter)
        CitiesList.setAdapter(citiesAdapter);
        StudentSpinner.setAdapter(studentsAdapter);

        // ICI commence le onclick de chaque elemetnt du Arraylist
        CitiesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,"Vous habité à "+cities.get(position),Toast.LENGTH_SHORT).show();
            }
        });

        //Dans le cas de Spinner avec java arraylist Onclick
        StudentSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,"Bonjour "+students.get(position),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //Dans le cas de Spinner sans java arraylist Onclick(fichier xml)
        HumourSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,"Vous vous sentez "+HumourSpinner.getSelectedItem().toString(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
}

//NB: Le ListView n'est pas conseillée car si il y a beaucoup données y a un certain latence
// aussi on ne peut pas modifier les données dedans après avoir entrées les données préalable
//RecyclerView est bien plus performant que ListView
//final devant ArrayList pour mettre variable en constant
