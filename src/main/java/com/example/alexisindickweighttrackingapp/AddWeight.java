package com.example.alexisindickweighttrackingapp;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class AddWeight extends AppCompatActivity {

    protected EditText dateEntry;
    protected EditText weightEntry;
    protected String isoDate;
    UserModel _user;
    WeightDB _db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addweight);
        weightEntry = findViewById(R.id.editWeightWeight);
        dateEntry = findViewById(R.id.editWeightDate);


        _user = UserModel.getUserInstance();
        _db = WeightDB.getInstance(this);

        dateEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // I decided to add a calendar instead for user's to enter the date
                final Calendar c = Calendar.getInstance();


                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog datePickerDialog = new DatePickerDialog(

                        AddWeight.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // on below line we are setting date to our edit text.
                                dateEntry.setText((monthOfYear + 1) + "-" + dayOfMonth + "-" + year);
                                isoDate = year + "-" + (monthOfYear + 1) + "-" +
                                        dayOfMonth;
                            }
                        },
                        year, month, day);
                datePickerDialog.show();
            }

        });
    }

    public void openSettingsForm(View view) {
        Intent intent = new Intent(this, SettingsforUser.class);
        startActivity(intent);
    }

    public void openMainForm(View view) {
        Intent intent = new Intent(this, AddWeight.class);
        startActivity(intent);
    }

    public void onSaveClick(View view) {
        String date = dateEntry.getText().toString();
        String sWeight = weightEntry.getText().toString();
        float weight = 0;

        //protect against an empty form
        if (!date.equals("") && !sWeight.equals("")) {
            weight = Float.valueOf(sWeight);
            WeightClass entry = new WeightClass(isoDate, weight);
            Boolean weightAdd = _db.addEntry(entry, _user);
            //send message to user if goal weight is achieved
            if (weight <= _user.getGoal()) {
                if (_user.isTextPermission()) {
                    SMSNotify.sendLongSMS(_user.getSMSText());
                }
            }
        }

        //go back to dashboard
        Intent intent = new Intent(this, DashboardActivity.class);
        startActivity(intent);

    }

    public void openSettings(View view) {
    }
}