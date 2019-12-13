package com.example.kuizo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        Button b1 = findViewById(R.id.btnPlay);
        Globals g = new Globals();
        Intent intent = getIntent();
        String ch = intent.getStringExtra("user");
        g.currentUser = ch;

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),Play.class);
                view.getContext().startActivity(intent);
            }
        });
}
}
