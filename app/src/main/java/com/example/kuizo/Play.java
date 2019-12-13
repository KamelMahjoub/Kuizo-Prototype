package com.example.kuizo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class Play extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play);

        Question q1 = new Question(0,"",true);
        Question q2 = new Question(1,"",true);
        Question q3 = new Question(2,"",true);
        Question q4 = new Question(3,"",true);
        Question q5 = new Question(4,"",true);
        Question q6 = new Question(5,"",true);
        Question q7 = new Question(6,"",true);
        Question q8 = new Question(7,"",true);
        Question q9 = new Question(8,"",true);
        Question q10 = new Question(9,"",true);

        ArrayList<Question> Liste_Question = new ArrayList<>();

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






    }
}
