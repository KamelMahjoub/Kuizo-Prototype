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

public class Register extends AppCompatActivity {
    DbAdapter DB = new DbAdapter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);


        Button b1 = findViewById(R.id.BtnLogin);
        Button b2 = findViewById(R.id.BtnCreateAccount);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(checkInputs())
                {

                    if(checkPassword())
                    {
                        EditText e1 = findViewById(R.id.InputRegisterUsername);
                        EditText e2 = findViewById(R.id.InputRegisterPassword);
                        String Username = e1.getText().toString();
                        String Password = e2.getText().toString();
                        if(DB.checkUserExists(Username))
                        {
                            AlertDialog alertDialog = new AlertDialog.Builder(Register.this).create();
                            alertDialog.setTitle("Error");
                            alertDialog.setMessage("Username exists already !");
                            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Okay",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                        }
                                    });
                            alertDialog.show();
                        }
                        else
                        {
                            User u = new User();
                            u.setUsername(Username);
                            u.setPassword(Password);
                            DB.addUser(u);
                            Intent intent = new Intent(view.getContext(), Menu.class);
                            intent.putExtra("user",Username);
                            view.getContext().startActivity(intent);
                        }
                    }
                    else
                    {
                        AlertDialog alertDialog = new AlertDialog.Builder(Register.this).create();
                        alertDialog.setTitle("Error");
                        alertDialog.setMessage("Passwords doesn't match !");
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
                    AlertDialog alertDialog = new AlertDialog.Builder(Register.this).create();
                    alertDialog.setTitle("Warning");
                    alertDialog.setMessage("Please fill all the fields !");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Okay",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                }}
        });


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Login.class);
                view.getContext().startActivity(intent);}
        });
    }



    public Boolean checkInputs()
    {
        EditText e1 = findViewById(R.id.InputRegisterUsername);
        EditText e2 = findViewById(R.id.InputRegisterPassword);
        EditText e3 = findViewById(R.id.InputRegisterPassword2);

        String Username = e1.getText().toString();
        String Password = e2.getText().toString();
        String Password2 = e3.getText().toString();

        if (Username.equals("")||Password.equals("")||Password2.equals(""))
        {
            return false;
        }
        else
            return true;
    }

    public Boolean checkPassword()
    {
        EditText e2 = findViewById(R.id.InputRegisterPassword);
        EditText e3 = findViewById(R.id.InputRegisterPassword2);

        String Password = e2.getText().toString();
        String Password2 = e3.getText().toString();

        if(Password.equals(Password2))
        {
            return true;
        }
        else
        {
            return false;
        }

    }


}
