package com.example.monapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onBtnClick(View view) {
        //selectionner des design textView
        TextView txtName = findViewById(R.id.txtName);
        TextView txtFirstname = findViewById(R.id.txtFirstname);
        TextView txtMail = findViewById(R.id.txtMail);

        //Selection des design EditText
        EditText EditTxtName = findViewById(R.id.editTxtName);
        EditText EditTxtFirstname = findViewById(R.id.editTxtFirstname);
        EditText EditTxtMail = findViewById(R.id.editTxtMail);

        //Prendre la valeur de format text entree dans les design editText et les mettre en string
        EditTxtName.getText().toString();
        EditTxtFirstname.getText().toString();
        EditTxtMail.getText().toString();

        //changer la lettre dans les textView grace au valeur entrée du editText
        txtName.setText("Nom: "+EditTxtName.getText().toString());
        txtFirstname.setText("Prénom: "+EditTxtFirstname.getText().toString());
        txtMail.setText("Adresse mail: "+EditTxtMail.getText().toString());
    }
}