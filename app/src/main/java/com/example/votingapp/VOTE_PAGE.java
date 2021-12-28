package com.example.votingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class VOTE_PAGE extends AppCompatActivity {
    RadioGroup rg;
    RadioButton rb;
    Button b,back;
    SQLiteDatabase db;
    int c1=0,c2=0,c3=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        b = findViewById(R.id.vote);
        rg = findViewById(R.id.radio);
        back=findViewById(R.id.back);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = rg.getCheckedRadioButtonId();
                if (id == -1)
                    Toast.makeText(VOTE_PAGE.this, "None selected", Toast.LENGTH_SHORT).show();
                else {
                        rb =(RadioButton) findViewById(id);
                        String s1=rb.getText().toString();
                        if(s1.equalsIgnoreCase("Thanmay"))
                            c1++;
                        if(s1.equalsIgnoreCase("Dhruv"))
                            c2++;
                        if(s1.equalsIgnoreCase("Alden"))
                            c3++;
                        Intent i1= new Intent (VOTE_PAGE.this, CALC.class);
                        i1.putExtra("count1",c1);
                        i1.putExtra("count2",c2);
                        i1.putExtra("count3",c3);
                        Intent i2 = new Intent(VOTE_PAGE.this, VOTER_INFO.class);
                        startActivity(i2);
                }
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(VOTE_PAGE.this, VOTER_INFO.class);
                startActivity(i2);
            }
        });

    }
}