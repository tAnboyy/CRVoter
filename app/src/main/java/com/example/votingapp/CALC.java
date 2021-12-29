package com.example.votingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CALC extends AppCompatActivity {

    Button calc,clear,bacc;
    TextView tv;
    int co1,co2,co3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_candidate);
        calc=findViewById(R.id.calc1);
        tv=findViewById(R.id.tv);
        bacc=findViewById(R.id.bacc);
        co1=VOTE_PAGE.getActivityInstance().count1();
        co2=VOTE_PAGE.getActivityInstance().count2();
        co3=VOTE_PAGE.getActivityInstance().count3();
            calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CALC.this, co1+" "+co2+" "+co3, Toast.LENGTH_SHORT).show();
                if(co1>co2 && co1>co3){
                    tv.setText("Thanmay is CR!");
                }
                if(co2>co1 && co2>co3){
                    tv.setText("Dhruv is CR!");
                }
                if(co3>co1 && co3>co2){
                    tv.setText("Alden is CR!");
                }
                if(co1==co2 && co1==co3 && co2==co3)
                    tv.setText("Equal Votes!");
            }
        });
        bacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(CALC.this, First.class);
                startActivity(i2);
            }
        });


    }


}

