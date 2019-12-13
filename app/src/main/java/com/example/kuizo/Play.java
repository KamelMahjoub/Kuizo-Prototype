package com.example.kuizo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;



public class Play extends AppCompatActivity {
    DbAdapter DB = new DbAdapter(this);
    private int id = 0 ;
    private int score = 0;
    private int x = 1 ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play);

        Button b1 = findViewById(R.id.BtnTrue);
        Button b2 = findViewById(R.id.BtnFalse);

        final TextView t1 = findViewById(R.id.TextPlayQuestion);
        final TextView t2 = findViewById(R.id.TextPlayScore);
        final TextView t3 = findViewById(R.id.TextPlayQsId);

       final ArrayList<Question> Liste_Question = new ArrayList<>();

        Question q1 = new Question(0,"Japan is made up of 6,852 islands.",true);
        Question q2 = new Question(1,"Won is the official currency of Japan.",false);
        Question q3 = new Question(2,"Osaka is the capital of Japan.",false);
        Question q4 = new Question(3,"The average delay of the japanese trains is only 18 seconds.",true);
        Question q5 = new Question(4,"In Japan there are more pets than children.",true);
        Question q6 = new Question(5,"Japan's population is 50 million.",false);
        Question q7 = new Question(6,"Japan is the 62nd largest country in the world.",true);
        Question q8 = new Question(7,"The unemployment rate in Japan is less than 4%.",true);
        Question q9 = new Question(8,"The national sport of Japan is Swordfighting.",false);
        Question q10 = new Question(9,"Japan officially banned dancing after midnight",true);

        Liste_Question.add(q1);
        Liste_Question.add(q2);
        Liste_Question.add(q3);
        Liste_Question.add(q4);
        Liste_Question.add(q5);
        Liste_Question.add(q6);
        Liste_Question.add(q7);
        Liste_Question.add(q8);
        Liste_Question.add(q9);
        Liste_Question.add(q10);

        int totalqs = Liste_Question.size();


        Intent intent = getIntent();
        final Globals g = (Globals) intent.getSerializableExtra("cuser");
        final String ch = g.getCurrentUser();


        Question qs = Liste_Question.get(id);

        t1.setText(qs.getText());
        t2.setText(t2.getText()+String.valueOf(score));
        t3.setText(x+" / "+Liste_Question.size());




        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Play p = (Play) view.getContext();
                Question qs = Liste_Question.get(id);

                if (qs.getAnswer().equals(true)) {
                    AlertDialog alertDialog = new AlertDialog.Builder(Play.this).create();
                    alertDialog.setMessage("Correct !");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Allright !",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                    score++; }

                if (qs.getAnswer().equals(false)) {
                    AlertDialog alertDialog = new AlertDialog.Builder(Play.this).create();
                    alertDialog.setMessage("Wrong answer !");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Allright !",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                     }

                if (x == Liste_Question.size()) {

                    if (qs.getAnswer().equals(true)) {
                        AlertDialog alertDialog = new AlertDialog.Builder(Play.this).create();
                        alertDialog.setMessage("Correct !");
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Allright !",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        User u ;
                                        u = DB.getUser(ch);
                                        int a = u.getNbAnsweredQuestions()+10;
                                        int b = u.getNbCorrectAnswers()+score;
                                        DB.updateStats(b,a,ch);
                                        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(Play.this);
                                        builder.setMessage("You have scored :"+score+" correct answers out of "+x+" questions !")
                                                .setPositiveButton("Allright", new DialogInterface.OnClickListener() {
                                                    public void onClick(DialogInterface dialog, int id) {
                                                        Intent intent = new Intent(getApplicationContext(),Menu.class);
                                                        intent.putExtra("user",ch);
                                                        startActivity(intent); }
                                                });

                                        android.app.AlertDialog alert = builder.create();
                                        alert.show();
                                    }
                                });
                        alertDialog.show();
                         }

                    if (qs.getAnswer().equals(false)) {
                        AlertDialog alertDialog = new AlertDialog.Builder(Play.this).create();
                        alertDialog.setMessage("Wrong answer !");
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Allright !",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        User u ;
                                        u = DB.getUser(ch);
                                        int a = u.getNbAnsweredQuestions()+10;
                                        int b = u.getNbCorrectAnswers()+score;
                                        DB.updateStats(b,a,ch);
                                        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(Play.this);
                                        builder.setMessage("You have scored :"+score+" correct answers out of "+x+" questions !")
                                                .setPositiveButton("Allright", new DialogInterface.OnClickListener() {
                                                    public void onClick(DialogInterface dialog, int id) {
                                                        Intent intent = new Intent(getApplicationContext(),Menu.class);
                                                        intent.putExtra("user",ch);
                                                        startActivity(intent); }
                                                });

                                        android.app.AlertDialog alert = builder.create();
                                        alert.show();
                                    }
                                });
                        alertDialog.show();
                    }
                }
                else
                {
                    x++;
                    p.id++;
                    qs = Liste_Question.get(id);
                    t1.setText(qs.getText());
                    t2.setText("Score : " + String.valueOf(score));
                    t3.setText(x + " / " + Liste_Question.size());
                }
            }
        });


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Play p = (Play) view.getContext();
                Question qs = Liste_Question.get(id);

                if (qs.getAnswer().equals(false)) {
                    AlertDialog alertDialog = new AlertDialog.Builder(Play.this).create();
                    alertDialog.setMessage("Correct !");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Allright !",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                    score++; }

                if (qs.getAnswer().equals(true)) {
                    AlertDialog alertDialog = new AlertDialog.Builder(Play.this).create();
                    alertDialog.setMessage("Wrong answer !");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Allright !",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                }

                if (x == Liste_Question.size()) {

                    if (qs.getAnswer().equals(false)) {
                        AlertDialog alertDialog = new AlertDialog.Builder(Play.this).create();
                        alertDialog.setMessage("Correct !");
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Allright !",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        User u ;
                                        u = DB.getUser(ch);
                                        int a = u.getNbAnsweredQuestions()+10;
                                        int b = u.getNbCorrectAnswers()+score;
                                        DB.updateStats(b,a,ch);
                                        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(Play.this);
                                        builder.setMessage("You have scored :"+score+" correct answers out of "+x+" questions !")
                                                .setPositiveButton("Allright", new DialogInterface.OnClickListener() {
                                                    public void onClick(DialogInterface dialog, int id) {
                                                        Intent intent = new Intent(getApplicationContext(),Menu.class);
                                                        intent.putExtra("user",ch);
                                                        startActivity(intent); }
                                                });

                                        android.app.AlertDialog alert = builder.create();
                                        alert.show();
                                    }
                                });
                        alertDialog.show();
                        }

                    if (qs.getAnswer().equals(true)) {
                        AlertDialog alertDialog = new AlertDialog.Builder(Play.this).create();
                        alertDialog.setMessage("Wrong answer !");
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Allright !",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        User u ;
                                        u = DB.getUser(ch);
                                        int a = u.getNbAnsweredQuestions()+10;
                                        int b = u.getNbCorrectAnswers()+score;
                                        DB.updateStats(b,a,ch);
                                        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(Play.this);
                                        builder.setMessage("You have scored :"+score+" correct answers out of "+x+" questions !")
                                                .setPositiveButton("Allright", new DialogInterface.OnClickListener() {
                                                    public void onClick(DialogInterface dialog, int id) {
                                                        Intent intent = new Intent(getApplicationContext(),Menu.class);
                                                        intent.putExtra("user",ch);
                                                        startActivity(intent); }
                                                });

                                        android.app.AlertDialog alert = builder.create();
                                        alert.show();
                                    }
                                });
                        alertDialog.show();
                    }
                }
                else
                {
                    x++;
                    p.id++;
                    qs = Liste_Question.get(id);
                    t1.setText(qs.getText());
                    t2.setText("Score : " + String.valueOf(score));
                    t3.setText(x + " / " + Liste_Question.size());
                }
            }
        });



    }

    @Override
    public void onBackPressed() {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to go back to the menu ?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = getIntent();
                        final Globals g = (Globals) intent.getSerializableExtra("cuser");
                        final String ch = g.getCurrentUser();
                        Intent intent2 = new Intent(getApplicationContext(),Menu.class);
                        intent2.putExtra("user",ch);
                        startActivity(intent2);
                                                }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        android.app.AlertDialog alert = builder.create();
        alert.show();
    }


}
