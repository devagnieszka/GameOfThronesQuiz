package com.example.android.gameofthronesquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    int points=0;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        Bundle b = getIntent().getExtras();
        name = b.getString("name");


        Button button = findViewById(R.id.buttonBack);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(QuizActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }

    public void Submit(View view) {
        RadioButton rb1 = (RadioButton) findViewById(R.id.radioButton21);
        if (rb1.isChecked()) points++;

        RadioButton rb2 = (RadioButton) findViewById(R.id.radioButton32);
        if (rb2.isChecked()) points++;

        EditText edit3 = (EditText) findViewById(R.id.edit);
        String text3 = edit3.getText().toString().toLowerCase();
        if (text3.equals("stark"))  points++;

        CheckBox chb4a = (CheckBox) findViewById(R.id.checkBox1);
        CheckBox chb4b = (CheckBox) findViewById(R.id.checkBox3);
        CheckBox chb4c = (CheckBox) findViewById(R.id.checkBox2);
        if (chb4a.isChecked() && chb4b.isChecked() && !chb4c.isChecked()) points++;

        RadioButton rb5 = (RadioButton) findViewById(R.id.radioButton35);
        if (rb5.isChecked()) points++;

        RadioButton rb6 = (RadioButton) findViewById(R.id.radioButton26);
        if (rb6.isChecked()) points++;

        RadioButton rb7 = (RadioButton) findViewById(R.id.radioButton17);
        if (rb7.isChecked()) points++;

        RadioButton rb8 = (RadioButton) findViewById(R.id.radioButton38);
        if (rb8.isChecked()) points++;


        String sumPoints = Integer.toString(points);
        String message;
        if (points>6) message = "Bravo! You are from Westeros!";
        else if (points>4) message = "Obviously you watched the show.";
        else if (points>2) message = "Maybe it's time to rewatch the show...";
        else  message = "Sorry, I see Dothraki horde is coming closer to you.";

        if(name.equals("")) name = "Stranger";
        String score = name + ", you earned " + sumPoints + " (of 8 points).\n" + message;

        Toast.makeText(this,score, Toast.LENGTH_LONG).show();

        points=0;
    }
}
