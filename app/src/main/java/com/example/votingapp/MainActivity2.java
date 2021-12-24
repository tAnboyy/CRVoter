package com.example.votingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    RadioGroup rg;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        b= findViewById(R.id.vote);
        rg= findViewById(R.id.radio);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id=rg.getCheckedRadioButtonId();
                if(id==-1)
                    Toast.makeText(MainActivity2.this,"None selected",Toast.LENGTH_SHORT).show();
                else{
                    String text="";
                    RadioButton r1=findViewById(id);
                    text=r1.getText().toString();
                    Intent i = new Intent(MainActivity2.this, MainActivity.class);
                    i.putExtra("key",text);
                    startActivity(i);
                }
            }
        });

    }
}