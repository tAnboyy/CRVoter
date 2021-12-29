package com.example.votingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class First extends AppCompatActivity {

    Button voter,ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        voter=findViewById(R.id.voter);
        ad=findViewById(R.id.admin);
        voter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(First.this, VOTER_INFO.class);
                startActivity(intent);
            }
        });
        ad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(First.this,CALC.class);
                startActivity(i);
            }
        });
    }
}