package com.perculacreative.peter.jokedisplay;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {
    public static final String JOKE_KEY = "joke_intent_key";
    public static final String ANSWER_KEY = "answer_intent_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        // Get data from the intent to populate the joke
        Intent intent = getIntent();
        String joke = intent.getStringExtra(JOKE_KEY);
        String answer = intent.getStringExtra(ANSWER_KEY);
        ((TextView) findViewById(R.id.joke)).setText(joke);
        ((TextView) findViewById(R.id.answer)).setText(answer);

        // Set actions for the reveal button click
        ((Button) findViewById(R.id.reveal)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Button) findViewById(R.id.reveal)).setVisibility(View.INVISIBLE);
                ((TextView) findViewById(R.id.answer)).setVisibility(View.VISIBLE);
            }
        });
    }
}
