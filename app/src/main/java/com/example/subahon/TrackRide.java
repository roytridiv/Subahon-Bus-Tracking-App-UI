package com.example.subahon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class TrackRide extends AppCompatActivity {

    RelativeLayout myTrip , trackRide , bookingVerification;
    ImageView mytripG , mytripB , trackRideG , trackRideB , bookingVerificationG , bookingVerificationB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_ride);

        myTrip = findViewById(R.id.myTripXml);
        trackRide = findViewById(R.id.trackRideXml);
        bookingVerification = findViewById(R.id.verifyBookingXml);

        mytripG = findViewById(R.id.myTripGreenLogo);
        mytripB = findViewById(R.id.myTripBlackLogo);

        trackRideG = findViewById(R.id.trackRideGreenLogo);
        trackRideB = findViewById(R.id.trackRideBlackLogo);

        bookingVerificationG = findViewById(R.id.verifyBookingGreenLogo);
        bookingVerificationB = findViewById(R.id.verifyBookingBlackLogo);

        trackRideG.setVisibility(View.VISIBLE);
        trackRideB.setVisibility(View.GONE);
        mytripB.setVisibility(View.VISIBLE);
        mytripG.setVisibility(View.GONE);
        bookingVerificationB.setVisibility(View.VISIBLE);
        bookingVerificationG.setVisibility(View.GONE);

    }


    @Override
    public void onBackPressed() {
        Intent intent = new Intent(TrackRide.this, MyBookings.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }
}
