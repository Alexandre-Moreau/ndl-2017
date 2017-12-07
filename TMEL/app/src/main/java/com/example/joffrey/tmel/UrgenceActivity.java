package com.example.joffrey.tmel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class UrgenceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urgence);
        setTitle(R.string.titreUrgence);
    }

    public void onHomeClick(View view) {
        startActivity(new Intent(this, HomeActivity.class));
    }
}
