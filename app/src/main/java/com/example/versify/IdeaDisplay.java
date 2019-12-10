package com.example.versify;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.*;
import java.net.*;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

/*
    url = new URL("https://api.datamuse.com/words?ml=" + words[i] + "&max=3");
    url2 = new URL("https://api.datamuse.com/words?sl=" + words[i] + "&max=3");
    url3 = new URL("https://api.datamuse.com/words?sp=" + words[i] + "m&ax=3");
*/

public class IdeaDisplay extends AppCompatActivity {
    TextView display;
    private String[] inspo = new String[3];
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_idea);
        display = findViewById(R.id.display);
        String search = getIntent().getExtras().getString("key");
        final Bar bar = new Bar(search);
        String[] words = bar.getWords();
        for (int i = 0; i < words.length; i++) {
            String link = "https://api.datamuse.com/words?ml=" + words[i] + "&max=3";
            Connect check = new Connect();
            try {
                String rV = check.c(link);
                display.setText(rV);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
