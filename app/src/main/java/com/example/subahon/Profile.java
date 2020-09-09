package com.example.subahon;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Calendar;

public class Profile extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    EditText userName , address;
    TextView dateOfBirthText ;
    LinearLayout dateOfBirth ;
    private int clickedDay, clickedMonth, clickedYear, currentday, currentMonth, currentYear ;
    private String selected_date;
    private boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        userName = findViewById(R.id.userNameXml);
        address = findViewById(R.id.newAddress);
        dateOfBirth = findViewById(R.id.dateOfBirthXml);
        dateOfBirthText = findViewById(R.id.dateOfBirthTextXml);

        dateOfBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

    }

    public void showDatePickerDialog() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(Profile.this, this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }


    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        month = month + 1;
        this.clickedDay = dayOfMonth;
        this.clickedMonth = month;
        this.clickedYear = year;

        String conv_day, conv_month;

        if(month < 10){
            conv_month = "0" + month;
        } else {
            conv_month = String.valueOf(month);
        }

        if(dayOfMonth < 10){
            conv_day = "0" + dayOfMonth;
        } else {
            conv_day = String.valueOf(dayOfMonth);
        }


        selected_date = "" + year + "-" + conv_month + "-" + conv_day;

//        verifySelectedDate();
//
//        if (flag) {
//
//            dateOfBirthText.setText(selected_date);
//
//
//        } else {
//            AlertDialog.Builder alertDialog = new AlertDialog.Builder(BookTrip.this);
//            alertDialog.setTitle("Message")
//                    .setMessage("Please select an Future date to Book your seat. Past date selection is not allowed.")
//                    .setPositiveButton("Select Date", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            showDatePickerDialog();
//                        }
//                    })
//                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//
//                        }
//                    });
//            alertDialog.setCancelable(false);
//            alertDialog.show();
//
//        }

    }

//    public void verifySelectedDate() {
//        if (clickedYear > currentYear) {
//            flag = true;
//        } else if (clickedYear == currentYear) {
//            if (clickedMonth > currentMonth) {
//                flag = true;
//            } else if (clickedMonth == currentMonth) {
//                flag = clickedDay >= currentday;
//            }
//        } else {
//            flag = false;
//        }
//    }




    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Profile.this, NavDrawer.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }
}
