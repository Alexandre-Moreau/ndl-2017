package com.example.joffrey.tmel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class JeuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeu);
        setTitle(R.string.titreJeu);

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

    public void onBtnDesigneClick(View view) {
        TextView tv = (TextView) findViewById(R.id.tvResult);
        EditText et = (EditText) findViewById(R.id.etNbPersonnes);

        int nbPersonnes = toInt(et.getText().toString());
        Random random = new Random();
        if(nbPersonnes > 0){
            int rnd = random.nextInt(nbPersonnes)+1 ;
            tv.setText(String.valueOf(rnd));
        }else{
            tv.setText("Combien êtes-vous?");
        }
    }



    private int toInt(String st){
        if(!st.equals("")){
            return Integer.valueOf(st);
        }else{
            return 0;
        }
    }
}
