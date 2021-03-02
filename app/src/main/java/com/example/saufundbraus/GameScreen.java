package com.example.saufundbraus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class GameScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);
        /*
        ArrayList<String> spielerliste = (ArrayList<String>) getIntent().getStringArrayListExtra("spielerliste");
        String text = spielerliste.get(1);
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(this, text, duration);

        toast.show();
         */

    }
}