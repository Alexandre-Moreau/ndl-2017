package com.example.joffrey.tmel;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class UrgenceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urgence);
        setTitle(R.string.titreUrgence);

        // Ajout du bouton home dans l'ActionBar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        Button button112 = (Button) findViewById(R.id.btn112);
        Button button18 = (Button) findViewById(R.id.btn18);
        Button button15 = (Button) findViewById(R.id.btn15);
        Button button17 = (Button) findViewById(R.id.btn17);

        button112.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appelle(888);
                //appelle(112);
            }
        });

        button18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appelle(888);
                //appelle(18);
            }
        });

        button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appelle(888);
                //appelle(15);
            }
        });

        button17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appelle(888);
                //appelle(17);
            }
        });
    }

    public void onHomeClick(View view) {
        startActivity(new Intent(this, HomeActivity.class));
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

    public void appelle(int numero) {
        /* Si l'utilisateur n'a pas donné la permission CALL_PHONE alors on lui demande, sinon on ouvre l'application téléphone. */
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            Snackbar snackbar = Snackbar.make(this.findViewById(android.R.id.content),
                    "Veuillez autoriser l'application à accéder au téléphone",
                    Snackbar.LENGTH_INDEFINITE).setAction("AUTORISER",
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, 1);
                            }
                        }
                    });
            snackbar.setActionTextColor(Color.GREEN);
            snackbar.show();
        } else {
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:" + numero));
            startActivity(callIntent);
        }
    }
}
