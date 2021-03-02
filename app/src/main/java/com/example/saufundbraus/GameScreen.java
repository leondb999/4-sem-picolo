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
    int counter_random_liste;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);
        exit = (Button)findViewById(R.id.button_exit);
        frage_view = (TextView)findViewById(R.id.textFrage);
        ArrayList<String> spielerliste = (ArrayList<String>) getIntent().getStringArrayListExtra("spielerliste");

        counter_spieler = 0;
        frage_view.setText("Klicke hier um das Spiel zu starten");
        /*String s1 = spielerliste.get(0);
        ArrayList<String> fragenliste = new ArrayList<String>();
        fragenliste.add(" Pagnia kann mich mal");
        fragenliste.add(" gewinne das Spiel asjdaisdjlasjdlkasjdlajsdljasöldkjasldjalsjdlasjdlakjsdölasjdlasjdl asjd ölkasjaslkdj asöldj aslkdja slkdj askd jölsa jdlias jd asöldjasljdlas jd");
*/

        // Allgemeine Liste / index = 0
        ArrayList<String> fragenliste_allgemein = new ArrayList<String>();
        fragenliste_allgemein.add(" Allgemein 1");
        fragenliste_allgemein.add(" Allgemein 2");
        // Entscheidungs Liste / index = 1
        ArrayList<String> fragenliste_entscheidung = new ArrayList<String>();
        fragenliste_entscheidung.add(" Entscheidung 1");
        fragenliste_entscheidung.add(" Entscheidung 2");
        // Virus Liste / index = 2
        ArrayList<String> frageliste_virus = new ArrayList<String>();
        frageliste_virus.add(" Virus 1");
        frageliste_virus.add(" Virus 2");
        // Personen Liste / index = 3
        ArrayList<String> frageliste_personen = new ArrayList<String>();
        frageliste_personen.add(" Person 1");
        frageliste_personen.add(" Person 2");

        //liste mit allen Fragelisten hier bekommen wir die anzahl der Listen für die Random Auswahl einer liste, sodass immer abwechselnd fragen von unterschiedlichen Typen gestellt werden
        ArrayList<ArrayList<String>> all_lists = new ArrayList<ArrayList<String>>();
        all_lists.add(fragenliste_allgemein);
        all_lists.add(fragenliste_entscheidung);
        all_lists.add(frageliste_virus);
        all_lists.add(frageliste_personen);


        // Klicke Exit button und gelange zum Start Screen
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        frage_view.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                // wenn alle fragelisten leer sind, beende das spiel.
                if(fragenliste_allgemein.size() == 0 &&  fragenliste_entscheidung.size() == 0 && frageliste_virus.size() == 0 && frageliste_personen.size() == 0 ){
                    frage_view.setText("Das Spiel ist zu Ende");
                } else {

                    // counter der berechnet, welche liste dran ist;
                    // suche solange bis eine Liste gefunden wurde deren size größer als 0 ist; also eine Liste wo Elemente drinnen stehen
                    do {
                        counter_random_liste = new Random().nextInt(all_lists.size());
                    } while(all_lists.get(counter_random_liste).size() == 0);

                    // wenn die Random ausgesuchte liste die Liste frageliste_personen ist oder die Liste frageliste_virus ist
                    if(counter_random_liste == 3 || counter_random_liste == 2){
                        // wenn spielerliste durchgelaufen ist, fange von vorne an
                        if(counter_spieler == spielerliste.size()){
                            counter_spieler = 0;
                        }
                        //erzeuge Text mit Spieler und Random Frage  && lösche anschließend Frage an stelle des berechneten random index aus fragenliste
                        int counter_random_frage = new Random().nextInt(all_lists.get(counter_random_liste).size());
                        frage_view.setText(spielerliste.get(counter_spieler) + all_lists.get(counter_random_liste).get(counter_random_frage));
                        all_lists.get(counter_random_liste).remove(counter_random_frage);
                        counter_spieler++;
                    } else {
                        int counter_random_frage = new Random().nextInt(all_lists.get(counter_random_liste).size());
                        frage_view.setText(all_lists.get(counter_random_liste).get(counter_random_frage));
                        all_lists.get(counter_random_liste).remove(counter_random_frage);
                    }

                }
            }
        });
    }
}