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
import android.widget.RadioGroup;
import android.widget.Toast;

public class VOTE_PAGE extends AppCompatActivity {
    RadioGroup rg;
    Button b;
    SQLiteDatabase db;
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
                    Toast.makeText(VOTE_PAGE.this,"None selected",Toast.LENGTH_SHORT).show();
                else{

//                    db.execSQL();


                    Intent i = new Intent(VOTE_PAGE.this, VOTER_INFO.class);
                    startActivity(i);
                }
            }


        });


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id= item.getItemId();
        switch(id){
            case R.id.calc:

        }
        return super.onOptionsItemSelected(item);
    }

}