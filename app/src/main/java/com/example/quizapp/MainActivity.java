package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String[] questions={"java invented in 1233?", "java invented by A.K. swhing? ", "java made by using phyton?", "java invented by using c++?",
    "can java be used in game dev?"};
    private boolean[] answers={false,false,false,false,false};

    private int score=0;
    private int index=0;
    Button yes;
    Button no;
    TextView sc;
    TextView question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        yes=findViewById(R.id.yes);
        no=findViewById(R.id.no);
        sc=findViewById(R.id.sc);
        question=findViewById(R.id.question);
        question.setText(questions[index]);

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(index<=questions.length-1){
                    // CHECK WHETHER ANSWER IS CORRECT OR NOT!
                    if(answers[index]) {
                        score++;
                    }
                    else {
                        Toast.makeText(MainActivity.this, "WRONG ANSWER!", Toast.LENGTH_SHORT).show();
                    }
                    // CHECK WHETHER YOU ARE IN LENGTH OR NOT!
                    // THIS IF() STATEMENT IS ONLY TO CHECK THAT IF YOU R AT END THEN NO NEED TO SET ANOTHER TEXT.
                    index++;
                    if(index<=questions.length-1) {
                        question.setText(questions[index]);
                    }
                }
                else{
                    Toast.makeText(MainActivity.this, "you are at end bitch!\n you got "+score+"/"+questions.length, Toast.LENGTH_SHORT).show();
                }


            }
        });


            no.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(index<=questions.length-1){
                        if (!answers[index]) {
                            score++;
                        }
                        else{
                            Toast.makeText(MainActivity.this, "WRONG ANSWER!", Toast.LENGTH_SHORT).show();
                        }

                        index++;
                        if(index<=questions.length-1) {
                            question.setText(questions[index]);
                        }
                    }
                    else{
                        Toast.makeText(MainActivity.this, "you are at end bitch!\n you got "+score+"/"+questions.length, Toast.LENGTH_SHORT).show();
                    }


                }
            });


    }
}