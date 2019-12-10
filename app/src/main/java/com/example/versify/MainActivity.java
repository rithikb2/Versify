package com.example.versify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button button;  //<< declare here..

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.versify); //<< initialize here
        // set OnClickListener for Button here
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText eText = findViewById(R.id.editText);
                final String text = eText.getText().toString();

                Button go = findViewById(R.id.versify);

                go.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent vDIntent = new Intent(MainActivity.this, IdeaDisplay.class);
                        vDIntent.putExtra("key", text);
                        startActivity(vDIntent);
                    }
                });
            }
        });
    }
}
