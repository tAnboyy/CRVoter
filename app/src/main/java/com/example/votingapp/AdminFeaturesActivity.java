package com.example.votingapp;

import static com.example.votingapp.Utils.getWinner;
import static com.example.votingapp.Utils.updateCandidate;
import static com.example.votingapp.Utils.resetVoteCount;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.RoundedCorner;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AdminFeaturesActivity extends AppCompatActivity {

    Button calc, reset, bacc;
    TextView tv;

    Button update;
    EditText et0, et1, et2, et3;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_candidate);
        calc = findViewById(R.id.calc1);
        tv = findViewById(R.id.tv);
        bacc = findViewById(R.id.bacc);

        update = findViewById(R.id.rename);
        et0 = findViewById(R.id.et0);
        et1 = findViewById(R.id.et1);
        reset = findViewById(R.id.reset);
        et2 = findViewById(R.id.et2);
        et3 = findViewById(R.id.et3);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String prevName = et0.getText().toString();
                String newName = et1.getText().toString();
                String tagline = et2.getText().toString();
                String ig = et3.getText().toString();

                updateCandidate(prevName, newName, tagline, ig);
            }
        });

        int co1 = SubmitVoteActivity.getActivityInstance().count1();
        int co2 = SubmitVoteActivity.getActivityInstance().count2();
        int co3 = SubmitVoteActivity.getActivityInstance().count3();

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetVoteCount();
            }
        });

        calc.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                Toast.makeText(AdminFeaturesActivity.this, co1 + " " + co2 + " " + co3, Toast.LENGTH_SHORT).show();
                String winner = getWinner();
                if (winner == "") {
                    tv.setText("no votes registered!");
                } else {
                    tv.setText(winner + " is CR!");
                }

//                Cursor c = db.rawQuery("Select * from Voter", new String[]{});
//                String sms = winner + " is CR!";
//                while (c.moveToion(Manifest.permission.SEND_SMS)!= PackageManager.PERMISSION_GRANTED) {
//                        requestPermissionNext()) {
////                    String ph = c.getString(2);
////                    SmsManager msg = SmsManager.getDefault();
////                    if (checkSelfPermisss(new String[]{Manifest.permission.SEND_SMS}, 0);
//                    } else {
//                        msg.sendTextMessage(ph, null, sms, null, null);
//                    }
//                }
            }
        });

        bacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(AdminFeaturesActivity.this, MainActivity.class);
                startActivity(i2);
            }
        });
    }
}


