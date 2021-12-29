package com.example.votingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class VOTE_PAGE extends AppCompatActivity {
    static VOTE_PAGE INSTANCE;
    RadioGroup rg;
    RadioButton rb;
    Button b,back,clear;
    SQLiteDatabase db;
    SharedPreferences sp;
    int c1=0;
    int c2=0;
    int c3=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        INSTANCE=this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        b = findViewById(R.id.vote);
        rg = findViewById(R.id.radio);
        back=findViewById(R.id.back);
        clear=findViewById(R.id.clear);
        sp = getSharedPreferences("your_prefs", VOTE_PAGE.MODE_PRIVATE);
        SharedPreferences.Editor e = sp.edit();
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = rg.getCheckedRadioButtonId();
                if (id == -1)
                    Toast.makeText(VOTE_PAGE.this, "None selected", Toast.LENGTH_SHORT).show();
                else {
                        rb =(RadioButton) findViewById(id);
                        String s1=rb.getText().toString();
                        c1= sp.getInt("c1", -1);
                        c2= sp.getInt("c2", -1);
                        c3= sp.getInt("c3", -1);
                        if(s1.equalsIgnoreCase("Thanmay")) {
                            c1++;
                        }
                        if(s1.equalsIgnoreCase("Dhruv")){
                            c2++;
                        }
                        if(s1.equalsIgnoreCase("Alden")){
                            c3++;
                        }
                        Toast.makeText(VOTE_PAGE.this, c1+" "+c2+" "+c3+" ", Toast.LENGTH_SHORT).show();
                        Intent i2 = new Intent(VOTE_PAGE.this, VOTER_INFO.class);
                        startActivity(i2);
                }
                e.putInt("c1", c1);
                e.putInt("c2", c2);
                e.putInt("c3", c3);
                e.commit();
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


    public static VOTE_PAGE getActivityInstance()
    {
        return INSTANCE;
    }
    public Integer count1()
    {
        return this.c1;
    }
    public Integer count2()
    {
        return this.c2;
    }
    public Integer count3()
    {
        return this.c3;
    }

}

