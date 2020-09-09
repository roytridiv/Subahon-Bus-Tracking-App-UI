package com.example.subahon;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

import in.galaxyofandroid.spinerdialog.OnSpinerItemClick;
import in.galaxyofandroid.spinerdialog.SpinnerDialog;

public class BookTrip extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {


    RelativeLayout myTrip , trackRide , bookingVerification;
    ImageView mytripG , mytripB , trackRideG , trackRideB , bookingVerificationG , bookingVerificationB;




    CardView profile ;

    Button search;
    LinearLayout from, to, bus , selectDate , selectTime;
    TextView fromText, toText, selectedBus , setSelectedDate , setSelectedTime , setPassengerCount;
    ImageView plus , minus , menuIcon ;

    ArrayList<String> items = new ArrayList<>();
    ArrayList<String> busItems = new ArrayList<>();
    SpinnerDialog spinnerDialog1, spinnerDialog2 , spinnerDialog3;




  


    private int clickedDay, clickedMonth, clickedYear, currentday, currentMonth, currentYear ;
    private String selected_date;
    private boolean flag = false;

    int passengerCounter  = 1 ;
    String format = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_trip);



        menuIcon = findViewById(R.id.menuDrawerIconXml);
        myTrip = findViewById(R.id.myTripXml);
        trackRide = findViewById(R.id.trackRideXml);
        bookingVerification = findViewById(R.id.verifyBookingXml);

        mytripG = findViewById(R.id.myTripGreenLogo);
        mytripB = findViewById(R.id.myTripBlackLogo);

        trackRideG = findViewById(R.id.trackRideGreenLogo);
        trackRideB = findViewById(R.id.trackRideBlackLogo);

        bookingVerificationG = findViewById(R.id.verifyBookingGreenLogo);
        bookingVerificationB = findViewById(R.id.verifyBookingBlackLogo);

        trackRideG.setVisibility(View.GONE);
        trackRideB.setVisibility(View.VISIBLE);
        mytripB.setVisibility(View.GONE);
        mytripG.setVisibility(View.VISIBLE);
        bookingVerificationB.setVisibility(View.VISIBLE);
        bookingVerificationG.setVisibility(View.GONE);




        //fetching current date
        currentday = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        currentMonth = Calendar.getInstance().get(Calendar.MONTH) + 1;
        currentYear = Calendar.getInstance().get(Calendar.YEAR);





        search = findViewById(R.id.searchButtonXml);
        from = findViewById(R.id.fromXml);
        to = findViewById(R.id.toXml);
        bus = findViewById(R.id.selectBusXml);
        fromText = findViewById(R.id.fromTextXml);
        toText = findViewById(R.id.toTextXml);
        selectedBus = findViewById(R.id.busSelectionTextXml);
        selectDate = findViewById(R.id.selectDateXml);
        selectTime = findViewById(R.id.selectTimeXml);
        setSelectedDate = findViewById(R.id.selectedDateTextXml);
        setSelectedTime = findViewById(R.id.selectedTimeTextXml);
        plus = findViewById(R.id.plusButtonXml);
        minus = findViewById(R.id.minusButtonXml);
        setPassengerCount = findViewById(R.id.passengerCountXml);
        profile = findViewById(R.id.profileButtonXml);

        items.add("BRINDABON");
        items.add("DOHS GATE");
        items.add("ECB CANTEEN");
        items.add("KALSHI");
        items.add("ECB CHATTAR");
        items.add("SIGNAL GATE");
        items.add("CMH");
        items.add("ARMY HQ");
        items.add("GARRISON");
        items.add("ADAMJEE");
        items.add("WORKSHOP");
        items.add("FARMGATE");

        busItems.add("BRTC Round Route 1");
        busItems.add("BRTC Round Route 2");
        busItems.add("BRTC Round Route 3");
        busItems.add("BRTC Round Route 4");
        busItems.add("BRTC Round Route 5");


        //spinner for selecting location
        spinnerDialog1 = new SpinnerDialog(BookTrip.this, items, "Pick a Location");
        spinnerDialog1 = new SpinnerDialog(BookTrip.this, items, "Pick a Location", R.style.DialogAnimations_SmileWindow);

        spinnerDialog1.setCancellable(true);
        spinnerDialog1.setShowKeyboard(false);


        //spinner for selecting bus
        spinnerDialog2 = new SpinnerDialog(BookTrip.this, busItems, "Select bus");
        spinnerDialog2 = new SpinnerDialog(BookTrip.this, busItems, "Select bus", R.style.DialogAnimations_SmileWindow);

        spinnerDialog2.setCancellable(true);
        spinnerDialog2.setShowKeyboard(false);

        //spinner for selecting location
        spinnerDialog3 = new SpinnerDialog(BookTrip.this, items, "Pick a Location");
        spinnerDialog3 = new SpinnerDialog(BookTrip.this, items, "Pick a Location", R.style.DialogAnimations_SmileWindow);

        spinnerDialog3.setCancellable(true);
        spinnerDialog3.setShowKeyboard(false);



//        trackRide.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });





        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BookTrip.this, Profile.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passengerCounter++;
                setPassengerCount.setText(""+passengerCounter);
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (passengerCounter > 1){
                    passengerCounter--;
                    setPassengerCount.setText(""+passengerCounter);
                }

            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BookTrip.this, SearchResult.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });




        selectDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

        selectTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Calendar mcurrentTime = Calendar.getInstance();
                    int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                    int minute = mcurrentTime.get(Calendar.MINUTE);
                    TimePickerDialog mTimePicker;
                    mTimePicker = new TimePickerDialog(BookTrip.this, new TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute ) {
                            if (selectedHour == 0) {
                                selectedHour+= 12;
                                format = "AM";
                            } else if (selectedHour== 12) {
                                format = "PM";
                            } else if (selectedHour > 12) {
                                selectedHour -= 12;
                                format = "PM";
                            } else {
                                format = "AM";
                            }
                            setSelectedTime.setText( selectedHour + ":" + selectedMinute+" "+format);
                        }
                    }, hour, minute, false);//Yes 24 hour time
                    mTimePicker.setTitle("Select Time");
                    mTimePicker.show();
//

            }
        });





        spinnerDialog1.bindOnSpinerListener(new OnSpinerItemClick() {
            @Override
            public void onClick(String item, int position) {
                Toast.makeText(BookTrip.this, item + "  " + position + "", Toast.LENGTH_SHORT).show();
                fromText.setText(item);
            }
        });



        spinnerDialog2.bindOnSpinerListener(new OnSpinerItemClick() {
            @Override
            public void onClick(String item, int position) {
                Toast.makeText(BookTrip.this, item + "  " + position + "", Toast.LENGTH_SHORT).show();
                selectedBus.setText(item);


            }
        });

        spinnerDialog3.bindOnSpinerListener(new OnSpinerItemClick() {
            @Override
            public void onClick(String item, int position) {
                Toast.makeText(BookTrip.this, item + "  " + position + "", Toast.LENGTH_SHORT).show();
                toText.setText(item);


            }
        });




        from.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinnerDialog1.showSpinerDialog();

            }
        });

        to.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinnerDialog3.showSpinerDialog();

            }
        });

        bus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                spinnerDialog2.showSpinerDialog();

            }
        });


    }

    public void showDatePickerDialog() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(BookTrip.this, this,
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

        verifySelectedDate();

        if (flag) {

            setSelectedDate.setText(selected_date);


        } else {
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(BookTrip.this);
            alertDialog.setTitle("Message")
                    .setMessage("Please select an Future date to Book your seat. Past date selection is not allowed.")
                    .setPositiveButton("Select Date", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            showDatePickerDialog();
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
            alertDialog.setCancelable(false);
            alertDialog.show();

        }

    }

    public void verifySelectedDate() {
        if (clickedYear > currentYear) {
            flag = true;
        } else if (clickedYear == currentYear) {
            if (clickedMonth > currentMonth) {
                flag = true;
            } else if (clickedMonth == currentMonth) {
                flag = clickedDay >= currentday;
            }
        } else {
            flag = false;
        }
    }



}

