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

public class MainActivity extends AppCompatActivity {
    Button sub;
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
        db = openOrCreateDatabase("VoterDB", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS VoterDB(usn varchar(10) primary key,name varchar(25),phone varchar(10),voted varchar(20))");
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n = name.getText().toString();
                String u = usn.getText().toString();
                String p = phone.getText().toString();

                if (n.equals("") || u.equals(""))
                    Toast.makeText(MainActivity.this, "Enter All Fields.", Toast.LENGTH_SHORT).show();
                else {
                    switchActivities();
                    Cursor c = db.rawQuery("Select * from VoterDB where usn=?", new String[]{u});
                    if (c.getCount() == 0) {
                        db.execSQL("Insert into VoterDB values('" + u + "','" + n + "',’" + p + "’)");
                    } else
                        Toast.makeText(MainActivity.this, "USN voted, please try another one.", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
    private void switchActivities() {
        Intent switchActivityIntent = new Intent(this, MainActivity2.class);
        startActivity(switchActivityIntent);
    }
}