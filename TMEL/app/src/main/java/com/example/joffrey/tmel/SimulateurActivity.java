package com.example.joffrey.tmel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SimulateurActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simulateur);
        setTitle(R.string.titreSimulateur);

        // Ajout du bouton home dans l'ActionBar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

    }

    // Ajout du listener sur le bouton home en haut à gauche
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            startActivity(new Intent(this, HomeActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }

    public void onCalculeClick(View view) {
        TextView tvResultat = (TextView) findViewById(R.id.tvResultatValue);

        EditText etBiere = (EditText) findViewById(R.id.etBiere);
        EditText etVin = (EditText) findViewById(R.id.etVin);
        EditText etShot = (EditText) findViewById(R.id.etShot);
        EditText etCocktail = (EditText) findViewById(R.id.etCocktail);
        //EditText etTaille = (EditText) findViewById(R.id.etTaille);
        EditText etMasse = (EditText) findViewById(R.id.etMasse);

        int nbBiere = toInt(etBiere.getText().toString());
        int nbVin = toInt(etVin.getText().toString());
        int nbShot = toInt(etShot.getText().toString());
        int nbCocktail = toInt(etCocktail.getText().toString());
        //int taille = Integer.valueOf(etBiere.getText().toString());
        double masse = toDouble(etMasse.getText().toString());
        double k = 0.7; // Faire le test

        if(masse != 0){
            /*
                Cocktail: 40° dilué à 50% -> 10 cl à 20°
             */
            double resultat = (nbBiere*10.8 + nbVin*9.6 + nbShot*9.6 + nbCocktail*18 )/masse*k;
            tvResultat.setText(Math.round(resultat * 100.0) / 100.0 + " g/l"); //arrondi à 2 chiffres
        }else{
            tvResultat.setText("Entrez une masse");
        }
    }

    private int toInt(String st){
        if(!st.equals("")){
            return Integer.valueOf(st);
        }else{
            return 0;
        }
    }

    private double toDouble(String st){
        if(!st.equals("")){
            return Double.valueOf(st);
        }else{
            return 0.0;
        }
    }
}
