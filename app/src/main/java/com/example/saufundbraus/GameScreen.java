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

public class GameScreen extends AppCompatActivity {
    Button exit;
    TextView frage_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);
        exit = (Button)findViewById(R.id.button_exit);
        frage_view = (TextView)findViewById(R.id.textFrage);

        ArrayList<String> spielerliste = (ArrayList<String>) getIntent().getStringArrayListExtra("spielerliste");

        String s1 = spielerliste.get(0);
        ArrayList<String> fragenliste = new ArrayList<String>();
        fragenliste.add("Pagnia kann mich mal");
        fragenliste.add(" gewinne das Spiel asjdaisdjlasjdlkasjdlajsdljasöldkjasldjalsjdlasjdlakjsdölasjdlasjdl asjd ölkasjaslkdj asöldj aslkdja slkdj askd jölsa jdlias jd asöldjasljdlas jd");
        ArrayList<String> fragenliste_finished = new ArrayList<String>();
        int counter_spieler = 1;

        frage_view.setText(s1 + fragenliste.get(0));
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        /*
        frage_view.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(liste zuende){
                    navigate to screen --> Spiel zuende;
                } else {
                    erhöre globale int variable
                }

            }

        });
*/

    }
}