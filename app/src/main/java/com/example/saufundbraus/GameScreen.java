package com.example.saufundbraus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class GameScreen extends AppCompatActivity {
    ImageButton exit;
    TextView frage_view;
    int counter_spieler;
    int counter_random_liste;
    ConstraintLayout cl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);
        exit = (ImageButton)findViewById(R.id.button_exit);
        frage_view = (TextView)findViewById(R.id.textFrage);
        cl = (ConstraintLayout) findViewById(R.id.game_background);
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
        fragenliste_allgemein.add("Alle, die jünger als 19 sind müssen 4 Schlücke trinken.");
        fragenliste_allgemein.add("Alle müssen trinken.");
        fragenliste_allgemein.add("Die Person mit der kleinsten & die Person mit der größten Hand müssen 4 Schlücke trinken.");
        fragenliste_allgemein.add("Alle die ein Auto besitzen müssen 2 Schlücke trinken.");
        fragenliste_allgemein.add("Alle die kein Haustierhaben haben müssen 4 Schlücke trinken.");
        fragenliste_allgemein.add("Alle die keine Geschwister haben müssen 2 Schlücke trinken.");
        fragenliste_allgemein.add("Jeder der noch keinen Führerschein hat muss 4 Schlücke trinken.");
        fragenliste_allgemein.add("Jeder der eine Kutsche besitzt darf 5 Schlücke verteilen.");
        fragenliste_allgemein.add("Alle Studenten, müssen 3 Schlücke trinken (ihr solltet ja trinkfest sein).");
        fragenliste_allgemein.add("Alle die im Namen den Buchstaben e haben müssen auf ex trinken.");
        fragenliste_allgemein.add("Die kleinste Person darf 5 Schlücke verteilen.");
        fragenliste_allgemein.add("Die größte Person muss 4 Schlücke trinken.");
        fragenliste_allgemein.add("Die größte Frau darf 10 Schlücke an die Männer verteilen.");
        fragenliste_allgemein.add("Alle Männer trinken auf ex.");
        fragenliste_allgemein.add("Alle Singles müssen auf ex trinken.");
        fragenliste_allgemein.add("Alle die kleiner als 1,65 Meter groß sind verteilen 4 Schlücke.");
        fragenliste_allgemein.add("Alle mit einem iPhone müssen 2 Schlücke trinken.");
        fragenliste_allgemein.add("Alle die einen Tik Tok Account haben müssen auf ex trinken.");
        fragenliste_allgemein.add("Alle Veganer müssen 5 Schlücke trinken");
        fragenliste_allgemein.add("Alle die gerne Apps programmieren müssen 2 Schlücke trinken.");
        // Entscheidungs Liste / index = 1
        ArrayList<String> fragenliste_entscheidung = new ArrayList<String>();
        fragenliste_entscheidung.add("Pringles oder Nachos?");
        fragenliste_entscheidung.add("Sommer oder Winter?");
        fragenliste_entscheidung.add("Hund oder Katze?");
        fragenliste_entscheidung.add("Wein oder Bier?");
        fragenliste_entscheidung.add("Pizza oder Burger?");
        fragenliste_entscheidung.add("Youtube oder Netflix?");
        fragenliste_entscheidung.add("Gummibärchen: sauer oder süß?");
        fragenliste_entscheidung.add("Kochen oder Backen?");
        fragenliste_entscheidung.add("Fleisch oder Gemüse?");
        fragenliste_entscheidung.add("Rache oder Vergebung?");
        // Virus Liste / index = 2
        ArrayList<String> frageliste_virus = new ArrayList<String>();
        frageliste_virus.add("Du darfst keinen der anderen Spieler beim Namen nennen, oder ihren Namen aussprechen. Ansonsten trinke 3 Schlücke.");
        frageliste_virus.add("Du darfst nicht mehr „der“, „die“ oder „das“ sagen. Jeder Fehler zählt 3 Schlücke.");
        frageliste_virus.add("Du darfst nicht mehr mit deinem linken Nachbarn reden. Der Nachbar allerdings schon mit dir. Jeder Fehler zählt 3 Schlücke.");
        frageliste_virus.add("Du darfst keine Fragen mehr beantworten. Tust du das doch, trinke 4 Schlücke.");
        frageliste_virus.add("Immer wenn du jemandem in die Augen schaust musst du 2 Schlücke trinken.");
        frageliste_virus.add("Alles was du sagen möchtest muss du singen. Bei jedem Fehler trinke 3 Schlücke.");
        frageliste_virus.add("Immer wenn du etwas sagen möchtest musst du deine Hand heben. Erst wenn ein Mitspieler deinen Namen aufruft und dich dran nimmt, darfst du reden.  ");
        frageliste_virus.add("Versuche nicht zu lachen. Wenn du lachst, trinke immer 2 Schlücke.");
        frageliste_virus.add("Dein Name ist jetzt Säufer. Wenn du auf deinen Namen reagierst trinke 2 Schlücke, wenn du auf Säufer nicht reagierst, trinke auch 2 Schücke.");
        frageliste_virus.add("Fasse dir immer auf die Nase wenn du redest, vergisst du es, trinke 2 Schlücke.");
        frageliste_virus.add("Sag nach jedem Satz den du sagst Punkt. Vergisst du es, trinke 3 Schlücke.");
        // Personen Liste / index = 3
        ArrayList<String> frageliste_personen = new ArrayList<String>();
        frageliste_personen.add("Verteile 5 Schlücke");
        frageliste_personen.add("Trinke 3 Schlücke");
        frageliste_personen.add("Erzähle eine Geschichte. Ob wahr oder falsch müssen die anderen entscheiden. Haben die anderen recht trinkst du 5 Schlücke, ansosnten trinken alle anderen einen Schluck.");
        frageliste_personen.add("Wenn du eine Brille trägst, verteile 3 Schlücke.");
        frageliste_personen.add("Wenn du blond bist, trinke 3 Schlücke.");
        frageliste_personen.add("Alle stimmen ab. Bist du ordentlich oder unordentlich? Wenn du ordentlich bist musst du 5 Schlücke tinken, wenn du unordentlich bist verteile 10 Schlücke.");
        frageliste_personen.add("Dein linker Nachbar darf entscheiden wie viele Schlücke du trinken musst.");
        frageliste_personen.add("Wenn du gerne Bücher liest, trinke 2 Schlücke.");
        frageliste_personen.add("Wenn du länger als 3 Stunden pro Tag an deinem Handy bist, trinke so viele Schlücke, wie viele Stunden du an deinem Handy bist.");
        frageliste_personen.add("Beschreibe einen Mitspieler. Du hast 60 Sekunden Zeit. Der der es errät darf mit dir zusammen 10 Schlücke verteilen. Wenn es keiner errät trinkt jeder 3.");
        frageliste_personen.add("Summe einen Song. Wenn es jemand errät verteilst du und der, der es erraten hat, 10 Schlücke.");
        frageliste_personen.add("Wenn du bereits in Russland warst, trinke 5 Schlücke.");
        frageliste_personen.add("Tinke auf ex.");
        frageliste_personen.add("Nenne Dinge,die du an deinem rechten Nachbar magst. Für jedes Kompliment muss er drei Mal trinken.");
        frageliste_personen.add("Trinke mindestens einen Schluck. Solange du noch trinkst, müssen alle anderen auch trinken.");
        frageliste_personen.add("Alle abstimmen: Bist du schon betrunken oder noch nicht? Wenn du noch nicht betrunken bist, trinke auf ex.");
        frageliste_personen.add("Verteile 10 Schlücke an alle Männer");
        frageliste_personen.add("Wenn du im Oktober oder November Geburtstag hast, verteile 5 Schlücke, ansonsten trinke du 5 Schlücke.");
        frageliste_personen.add("Entscheide welche 2 Spieler auf ex trinken müssen.");
        frageliste_personen.add("Wenn dein Handyakku unter 20% ist, trinke für jeden prozent einen Schluck.");
        frageliste_personen.add("Trägst du eine Jeans, verteile 5 Schlücke. Tägst du keine, trinkt dein linker Nachbar 5 Schlücke.");
        frageliste_personen.add("Entscheide wer die betrunkenste Person ist und verteile ihr belibig viele Schlücke.");
        frageliste_personen.add("Alle stimmen ab: Wie betrunken bist du auf eine Skala von 1- 10. Trinke diese Anzahl an Schlücken.");
        frageliste_personen.add("Trinke 5 Schlücke, wenn du in den letzten 24 Stunden Fleisch gegessen hast.");
        frageliste_personen.add("Wenn du mehr als 10 paar Schuhe hast, dann trinke auf ex.");




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

                        if(counter_random_liste == 2){
                            cl.setBackgroundColor(getResources().getColor(R.color.fragenliste_entscheidung));
                        } else if (counter_random_liste == 3) {
                            cl.setBackgroundColor(getResources().getColor(R.color.fragenliste_entscheidung));
                        }

                        // wenn spielerliste durchgelaufen ist, fange von vorne an
                        if(counter_spieler == spielerliste.size()){
                            counter_spieler = 0;
                        }
                        //erzeuge Text mit Spieler und Random Frage  && lösche anschließend Frage an stelle des berechneten random index aus fragenliste
                        int counter_random_frage = new Random().nextInt(all_lists.get(counter_random_liste).size());
                        frage_view.setText(spielerliste.get(counter_spieler)+ " " + all_lists.get(counter_random_liste).get(counter_random_frage));
                        all_lists.get(counter_random_liste).remove(counter_random_frage);
                        counter_spieler++;
                    } else {

                        if(counter_random_liste == 0){
                            cl.setBackgroundColor(getResources().getColor(R.color.frageliste_virus));
                        } else if (counter_random_liste == 1) {
                            cl.setBackgroundColor(getResources().getColor(R.color.frageliste_personen));
                        }

                        int counter_random_frage = new Random().nextInt(all_lists.get(counter_random_liste).size());
                        frage_view.setText(all_lists.get(counter_random_liste).get(counter_random_frage));
                        all_lists.get(counter_random_liste).remove(counter_random_frage);
                    }

                }
            }
        });
    }
}