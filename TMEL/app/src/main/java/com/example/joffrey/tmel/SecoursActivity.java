package com.example.joffrey.tmel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class SecoursActivity extends AppCompatActivity {

    private ListView lv;
    private ListViewAdapter lva;
    JSONArray liste;
    JSONObject obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secours);
        setTitle(R.string.titreSecours);

        // Ajout du bouton home dans l'ActionBar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        try {
            obj = new JSONObject(loadJSONFromAsset());
            liste = obj.getJSONArray("gestes");
            lv = (ListView) findViewById(R.id.list_view);
            // Ajout du ListView et de son adapter
            lva = new ListViewAdapter(this, R.layout.layout_tab_list, this.liste);
            if (lv != null) {
                lv.setAdapter(lva);
            } else {
                Log.d("==========****", "lv est null");
            }
        } catch (JSONException e) {
            e.printStackTrace();
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

    public String loadJSONFromAsset() {
        String json;
        try {
            InputStream is = this.getAssets().open("consignes.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
