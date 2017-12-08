package com.example.joffrey.tmel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setTitle(R.string.titreHome);
    }

    public void onUrgenceClick(View view) {
        startActivity(new Intent(this, UrgenceActivity.class));
    }

    public void onSimulateurClick(View view) {
        startActivity(new Intent(this, SimulateurActivity.class));
    }

    public void onSecoursClick(View view) {
        startActivity(new Intent(this, SecoursActivity.class));
    }

    public void onJeuClick(View view) {
        startActivity(new Intent(this, JeuActivity.class));
    }

}
