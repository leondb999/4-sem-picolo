package com.example.saufundbraus;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button button_add_player;
    Button button_start_game;
    EditText edittext_player_name;
    ListView listview_player_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_add_player = (Button)findViewById(R.id.button_add_player);
        button_start_game = (Button)findViewById(R.id.button_start_game);
        edittext_player_name = (EditText)findViewById(R.id.edittext_player_name);
        listview_player_list = (ListView)findViewById(R.id.listview_player_list);
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
                Intent i = new Intent(MainActivity.this, GameScreen.class);
                i.putStringArrayListExtra("spielerliste", player_name);
                startActivity(i);
            }
        });
    }
}