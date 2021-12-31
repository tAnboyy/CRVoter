package com.example.votingapp;

import static com.example.votingapp.Utils.candidateList;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class SubmitVoteActivity extends AppCompatActivity {
    static SubmitVoteActivity INSTANCE;
    RadioGroup rg;
    RadioButton rb, rb1, rb2, rb3;
    Button b, back;
    SharedPreferences sp;

    int c1 = 0, c2 = 0, c3 = 0;
    TextView tv1, tv2, tv3;
    ImageView ib1, ib2, ib3;

    public static SubmitVoteActivity getActivityInstance() {
        return INSTANCE;
    }

    public Integer count1() {
        return this.c1;
    }

    public Integer count2() {
        return this.c2;
    }

    public Integer count3() {
        return this.c3;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        INSTANCE = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        b = findViewById(R.id.vote);
        rg = findViewById(R.id.radio);

        back = findViewById(R.id.back);
//        sp = getSharedPreferences("your_prefs", SubmitVoteActivity.MODE_PRIVATE);
//        SharedPreferences.Editor e = sp.edit();

        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        rb3 = findViewById(R.id.rb3);

        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);

        ib1 = findViewById(R.id.ib1);
        ib1.setImageResource(R.drawable.instagram);
        ib2 = findViewById(R.id.ib2);
        ib2.setImageResource(R.drawable.instagram);
        ib3 = findViewById(R.id.ib3);
        ib3.setImageResource(R.drawable.instagram);

        ib1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(candidateList.get(0).ig));
                startActivity(i);
            }
        });

        ib2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(candidateList.get(1).ig));
                startActivity(i);
            }
        });

        ib3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(candidateList.get(2).ig));
                startActivity(i);
            }
        });

        if (candidateList.size() == 0) {
            Candidate cd1 = new Candidate("Thanmay", 0, "mass bunk? :P", "https://www.instagram.com/tanboyy/?hl=en");
            candidateList.add(cd1);
            Candidate cd2 = new Candidate("Dhruv", 0, "get free samosa", "");
            candidateList.add(cd2);
            Candidate cd3 = new Candidate("Jogi", 0, "pls vote for me", "");
            candidateList.add(cd3);
        }

        String n1 = candidateList.get(0).name;
        rb1.setText(n1);
        String n2 = candidateList.get(1).name;
        rb2.setText(n2);
        String n3 = candidateList.get(2).name;
        rb3.setText(n3);

        tv1.setText(candidateList.get(0).tagline);
        tv2.setText(candidateList.get(1).tagline);
        tv3.setText(candidateList.get(2).tagline);


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = rg.getCheckedRadioButtonId();
                if (id == -1)
                    Toast.makeText(SubmitVoteActivity.this, "None selected", Toast.LENGTH_SHORT).show();
                else {
                    rb = (RadioButton) findViewById(id);
                    String s1 = rb.getText().toString();
//                    c1 = sp.getInt("c1", 0);
//                    c2 = sp.getInt("c2", 0);
//                    c3 = sp.getInt("c3", 0);

                    AlertDialog.Builder builder = new AlertDialog.Builder(SubmitVoteActivity.this);
                    builder.setTitle("Vote for " + s1 + " ?");
                    builder.setMessage("Are you sure?");
                    builder.setNegativeButton("I changed my mind", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    builder.setPositiveButton("Yes!", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if (s1.equalsIgnoreCase(n1)) {
                                candidateList.get(0).voteCount++;
                            }
                            if (s1.equalsIgnoreCase(n2)) {
                                candidateList.get(1).voteCount++;
                            }
                            if (s1.equalsIgnoreCase(n3)) {
                                candidateList.get(2).voteCount++;
                            }

                            c1 = candidateList.get(0).voteCount;
                            c2 = candidateList.get(1).voteCount;
                            c3 = candidateList.get(2).voteCount;

                            Toast.makeText(SubmitVoteActivity.this, c1 + " " + c2 + " " + c3 + " ", Toast.LENGTH_SHORT).show();
                            Intent i2 = new Intent(SubmitVoteActivity.this, VoterLoginActivity.class);
                            startActivity(i2);
                        }
                    });
                    builder.create().show();

                }
//                e.putInt("c1", c1);
//                e.putInt("c2", c2);
//                e.putInt("c3", c3);
//                e.commit();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(SubmitVoteActivity.this, VoterLoginActivity.class);
                startActivity(i2);
            }
        });
    }
}

