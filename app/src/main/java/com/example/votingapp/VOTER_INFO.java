package com.example.votingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class VOTER_INFO extends AppCompatActivity {
    Button sub,back;
    EditText name, usn, phone;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sub = findViewById(R.id.sub);
        name = findViewById(R.id.name);
        usn = findViewById(R.id.usn);
        phone = findViewById(R.id.phone);
        back=findViewById(R.id.back1);
        db = openOrCreateDatabase("Voter", MODE_PRIVATE, null);
        //db.execSQL("DROP TABLE Voter");
        db.execSQL("CREATE TABLE IF NOT EXISTS Voter(usn varchar(20) primary key,name varchar(25),phone varchar(10))");
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n = name.getText().toString();
                String u = usn.getText().toString();
                String p = phone.getText().toString();

                if (n.equals("") || u.equals("") || p.equals(""))
                    Toast.makeText(VOTER_INFO.this, "Enter All Fields.", Toast.LENGTH_SHORT).show();
                else {
                    switchActivities();
                    Cursor c = db.rawQuery("Select * from Voter where usn=?", new String[]{u});
                    if (c.getCount() == 0) {
                        db.execSQL("Insert into Voter values('"+u+"','"+n+"','"+p+"')");
                    } else
                        Toast.makeText(VOTER_INFO.this, "USN voted, please try another one.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(VOTER_INFO.this, First.class);
                startActivity(i2);
            }
        });
    }

    private void switchActivities() {
        Intent switchActivityIntent = new Intent(VOTER_INFO.this, VOTE_PAGE.class);
        startActivity(switchActivityIntent);
    }
}