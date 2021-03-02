package com.example.saufundbraus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class GameScreen extends AppCompatActivity {
    Button exit;
    TextView frage_view;
    int counter_spieler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);
        exit = (Button)findViewById(R.id.button_exit);
        frage_view = (TextView)findViewById(R.id.textFrage);
        ArrayList<String> spielerliste = (ArrayList<String>) getIntent().getStringArrayListExtra("spielerliste");
        counter_spieler = 1;
        String s1 = spielerliste.get(0);
        ArrayList<String> fragenliste = new ArrayList<String>();
        fragenliste.add(" Pagnia kann mich mal");
        fragenliste.add(" gewinne das Spiel asjdaisdjlasjdlkasjdlajsdljasöldkjasldjalsjdlasjdlakjsdölasjdlasjdl asjd ölkasjaslkdj asöldj aslkdja slkdj askd jölsa jdlias jd asöldjasljdlas jd");
        frage_view.setText(s1 + fragenliste.get(0));
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        frage_view.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                // ist liste zuende
                if(fragenliste.size() == 0){
                    frage_view.setText("Das Spiel ist zu Ende");
                } else {
                    // wenn spielerliste durchgelaufen ist, fange von vorne an
                    if(counter_spieler == spielerliste.size()){
                        counter_spieler = 0;
                    }
                    //erzeuge Text mit Spieler und Random Frage  && lösche anschließend Frage aus fragenliste

                    String frage = fragenliste.get(new Random().nextInt(fragenliste.size()));
                    frage_view.setText(spielerliste.get(counter_spieler) + frage);
                    fragenliste.remove(frage);
                    counter_spieler++;
                }
            }
        });
    }
}