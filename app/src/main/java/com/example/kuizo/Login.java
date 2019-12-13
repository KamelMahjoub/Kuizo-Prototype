package com.example.kuizo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    DbAdapter DB = new DbAdapter(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Button btnToregister = findViewById(R.id.BtnSignUp);
        Button btnLogin = findViewById(R.id.BtnSignIn);



        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(checkInputs())
                {
                    EditText textUsername = findViewById(R.id.InputLoginUsername);
                    EditText textPassword = findViewById(R.id.InputLoginPassword);
                    String Username = textUsername.getText().toString();
                    String Password = textPassword.getText().toString();
                    if(DB.checkUserHasAccount(Username,Password))
                    {
                        Intent intent = new Intent(view.getContext(),Menu.class);
                        intent.putExtra("user",Username);
                        view.getContext().startActivity(intent);
                    }
                    else
                    {
                        AlertDialog alertDialog = new AlertDialog.Builder(Login.this).create();
                        alertDialog.setTitle("Warning");
                        alertDialog.setMessage("Wrong username or password !");
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Okay",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });
                        alertDialog.show();
                    }
                }
                else
                {
                    AlertDialog alertDialog = new AlertDialog.Builder(Login.this).create();
                    alertDialog.setTitle("Warning");
                    alertDialog.setMessage("Please fill both fields !");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Okay",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                }

            }
        });

        btnToregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Register.class);
                view.getContext().startActivity(intent);}
        });
    }


    public Boolean checkInputs()
    {
        EditText textUsername = findViewById(R.id.InputLoginUsername);
        EditText textPassword = findViewById(R.id.InputLoginPassword);
        String Username = textUsername.getText().toString();
        String Password = textPassword.getText().toString();
        if (Username.equals("")||Password.equals(""))
        {
            return false;
        }
        else
            return true;
    }

}
