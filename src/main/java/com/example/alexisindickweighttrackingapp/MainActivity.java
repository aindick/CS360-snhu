package com.example.alexisindickweighttrackingapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText username;
    EditText password;
    Button loginBTN;
    TextView passwordMSG;
    User _db;
    UserModel validUser;
    WeightDB _weights;
    private DialogInterface.OnClickListener dialogClickListener;

    private void loginSuccess(View view, String _user) {

        //start the weights Database
        _weights = WeightDB.getInstance(this);

        //instantiate the UserModel
        validUser = UserModel.getUserInstance();
        validUser.setUserName(_user);
        validUser.setGoal(_weights.getGoal(validUser));

        Intent intent = new Intent(this, DashboardActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.editTextUsername);
        password = findViewById(R.id.editTextTextPassword);
        loginBTN = findViewById(R.id.buttonLogin);
        passwordMSG = findViewById(R.id.passwordMSG);

        //call the singleton
        _db = User.getInstance(this);


        loginBTN.setOnClickListener(v -> {

            String _username = username.getText().toString();
            String _password = password.getText().toString();

            boolean validUser = _db.checkUserName(_username);
            boolean validPass = _db.checkUserPassword(_username, _password);

            //first test if a valid user/pass combo --> registered user
            if (validUser) {
                if (validPass) {
                    Toast.makeText(MainActivity.this, "Login Success", Toast.LENGTH_SHORT).show();
                    loginSuccess(v, _username);
                } else {
                    Toast.makeText(MainActivity.this, "Incorrect Password", Toast.LENGTH_SHORT).show();
                }
            } else {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder
                        .setTitle("Account Not Made")
                        .setMessage("Would you like to register?")
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setPositiveButton("Yes", (dialog, which) -> {
                            //Yes if button is clicked, do something

                            Boolean userAdded = _db.insertUser(_username, _password);

                            if (userAdded) {
                                Toast.makeText(MainActivity.this, "Account added!", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(MainActivity.this, "Account not added", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("No", null) //Do nothing on no
                        .show();
            }
        });

        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            //monitor the password entry
            //if the passwords meets > 6  characters
            //enable the button and hide the message
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() < 6) {
                    passwordMSG.setVisibility(View.VISIBLE);
                } else {
                    passwordMSG.setVisibility(View.INVISIBLE);
                    loginBTN.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

}