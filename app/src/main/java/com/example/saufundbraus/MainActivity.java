package com.example.saufundbraus;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;


public class MainActivity extends AppCompatActivity {
    Button button_add_player;
    Button button_start_game;
    EditText edittext_player_name;
    ListView listview_player_list;
    int player_minimum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Erklärung: player_minimum = es müssen minimum so viele Spieler dabei sein, um das spiel zu starten
        player_minimum = 2;
        button_add_player = (Button)findViewById(R.id.button_add_player);
        button_start_game = (Button)findViewById(R.id.button_start_game);
        edittext_player_name = (EditText)findViewById(R.id.edittext_player_name);
        listview_player_list = (ListView)findViewById(R.id.listview_player_list);
        //String[] empty_name = new String[0];
       // ArrayList<String> player_name = new ArrayList<String>(Arrays.asList(empty_name));
        ArrayList<String> player_name = new ArrayList<String>();
    // sas
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1,player_name);
        listview_player_list.setAdapter(arrayAdapter);
        button_add_player.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edittext_player_name.getText().toString().length() > 0){
                    player_name.add(edittext_player_name.getText().toString());
                    arrayAdapter.notifyDataSetChanged();
                    edittext_player_name.setText("");
                } else {
                    Toast.makeText(MainActivity.this, "Spieler name darf nicht leer sein", Toast.LENGTH_SHORT).show();
                }
            }
        });

        button_start_game.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(player_name.size() >= player_minimum ){
                    Intent i = new Intent(MainActivity.this, GameScreen.class);
                    i.putStringArrayListExtra("spielerliste", player_name);
                    startActivity(i);
                } else {
                    Toast.makeText(MainActivity.this, "Es muss mindestens " + player_minimum + " Spieler mitsaufen damit ihr euch richtig die Kante geben könnt", Toast.LENGTH_SHORT).show();
                }

            }
        });

        // wenn du lange gedrückt hälts verschwindet der player Name
        listview_player_list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                arrayAdapter.remove(player_name.get(i));
                arrayAdapter.notifyDataSetChanged();
                return false;
            }
        });


    }
}