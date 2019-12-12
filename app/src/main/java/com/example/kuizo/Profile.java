package com.example.kuizo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kuizo.R;

import org.w3c.dom.Text;

public class Profile extends AppCompatActivity {
DbAdapter DB = new DbAdapter(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        Intent intent = getIntent();
        String ch = intent.getStringExtra("id");


        User u ;
        u = DB.getUser(ch);

        TextView t1 = findViewById(R.id.InputProfileUsername);
        TextView t2 = findViewById(R.id.InputProfileQuestions);
        TextView t3 = findViewById(R.id.InputProfileAnswers);
        TextView t4 = findViewById(R.id.InputProfilePercentage);

        Toast.makeText(getApplicationContext(),u.getUsername(),Toast.LENGTH_SHORT).show();

        t1.setText(u.getUsername());
        t2.setText(String.valueOf(u.getNbAnsweredQuestions()));
        t3.setText(String.valueOf(u.getNbCorrectAnswers()));



    }
}
