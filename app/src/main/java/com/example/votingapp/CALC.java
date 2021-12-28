package com.example.votingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CALC extends AppCompatActivity {

    Button calc,clear;
    TextView tv;
    int co1,co2,co3;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_candidate);
        calc=findViewById(R.id.calc);
        clear=findViewById(R.id.clear);
        tv=findViewById(R.id.tv);
        sp= getSharedPreferences("MYDETAILS",MODE_PRIVATE);
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getIntent();
                co1= intent.getIntExtra("count1",0);
                co2= intent.getIntExtra("count2",0);
                co3= intent.getIntExtra("count3",0);

                if(co1>co2 && co1>co3){
                    tv.setText("Thanmay is CR!");
                }
                if(co2>co1 && co2>co3){
                    tv.setText("Dhruv is CR!");
                }
                if(co3>co1 && co3>co1){
                    tv.setText("Alden is CR!");
                }
            }
        });
    }
}