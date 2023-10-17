package com.example.alexisindickweighttrackingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsforUser extends AppCompatActivity {

    Button deleteAccount;
    User _userDB;
    WeightDB _weights;
    UserModel _user;
    CompoundButton _switch;
    EditText phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        _user = UserModel.getUserInstance();
        phone = findViewById(R.id.editTextPhone);
        phone.setText(_user.getSMSText());

        deleteAccount = findViewById(R.id.buttonDelAccount);
        _switch = findViewById(R.id.notifications);
        _switch.setChecked(_user.isTextPermission());
        _switch.setOnCheckedChangeListener((buttonView, isChecked) -> _user.setTextPermission(isChecked));

    }

    public void deleteUserAccounts(View view) {
        //call the singleton
        _userDB = User.getInstance(this);
        _weights = WeightDB.getInstance(this);
        _user = UserModel.getUserInstance();

        _weights.deleteUser(_user);
        _userDB.deleteUser(_user);

        //force the user out
        this.finishAffinity();
        System.exit(0);
    }

    public void openMain(View view) {

        phone = findViewById(R.id.editTextPhone);
        String sPhone = phone.getText().toString();

        _user.setSMSText(sPhone);

        Intent intent = new Intent(this, DashboardActivity.class);
        startActivity(intent);
    }


}
