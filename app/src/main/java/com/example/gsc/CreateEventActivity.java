package com.example.gsc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Calendar;

public class CreateEventActivity extends AppCompatActivity {


    private EditText mEventName, mEventDate, mEventVenue,mEventTime,mEventDisc;
    private ImageView mEventCoverPic;
    private Button mCreateEvent;
    private DatePickerDialog.OnDateSetListener mdateSetListener;
    public static final String TAG = "TAG";

    private FirebaseFirestore database;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);

        mEventName = findViewById(R.id.eventname);
        mEventDate = findViewById(R.id.eventdata);
        mEventDisc=findViewById(R.id.eventDisc);
        mEventTime=findViewById(R.id.eventtime);
        mEventVenue=findViewById(R.id.eventVenue);
        mEventCoverPic = findViewById(R.id.coverpic);
        mCreateEvent = findViewById(R.id.createbtn);


            //----------------------------------------------------------------------------Submit Event On Firebase-----------------------------------------------------
      final String mClubName = getIntent().getStringExtra("clubname");

      database = FirebaseFirestore.getInstance();
      mAuth = FirebaseAuth.getInstance();
      mCreateEvent.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {

              String EventName = mEventName.getText().toString().trim();
              String EventDate = mEventDate.getText().toString().trim();
              String EventDisc = mEventDisc.getText().toString().trim();
              String EventVenue = mEventVenue.getText().toString().trim();
              String EventTime = mEventTime.getText().toString().trim();

              DocumentReference dbReference = collectionReference("Clubs", mClubName, "Events").document(EventName);

              CreateEvent mCreateEvent = new CreateEvent(EventName,EventDate,EventDisc,EventTime,EventVenue);

              final ProgressDialog progressDialog = new ProgressDialog(CreateEventActivity.this);
              progressDialog.setTitle("Uploading...");
              progressDialog.show();

              dbReference.set(mCreateEvent)

                      .addOnSuccessListener(new OnSuccessListener<Void>() {
                          @Override
                          public void onSuccess(Void aVoid) {
                              progressDialog.dismiss();
                              Toast.makeText(CreateEventActivity.this, "Event Created Successful", Toast.LENGTH_SHORT).show();
                          }
                      })
                      .addOnFailureListener(new OnFailureListener() {
                          @Override
                          public void onFailure(@NonNull Exception e) {
                              progressDialog.dismiss();
                              Toast.makeText(CreateEventActivity.this, "Event Not Created", Toast.LENGTH_SHORT).show();
                          }
                      });
          }
      });

      //-------------------------------------------------------------------------Dialog Time------------------------------------------------------------------
     mEventTime.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             final Calendar c = Calendar.getInstance();
             int hour = c.get(Calendar.HOUR_OF_DAY);
             int minute = c.get(Calendar.MINUTE);
             TimePickerDialog mtimePickerDialog = new TimePickerDialog(CreateEventActivity.this, new TimePickerDialog.OnTimeSetListener() {
                 @Override
                 public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                     if (hourOfDay<12)
                     mEventTime.setText(hourOfDay + ":" + minute);

                 }
             },hour,minute,false);
             mtimePickerDialog.show();
         }
     });
        //--------------------------------------------------------------------------Dialog Calender------------------------------------------------------------
        mEventDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get((Calendar.YEAR));
                int month = cal.get((Calendar.MONTH));
                int day = cal.get((Calendar.DAY_OF_MONTH));
                DatePickerDialog dialog = new DatePickerDialog(CreateEventActivity.this,android.R.style.Theme_Holo_Dialog_MinWidth,mdateSetListener,year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

            }
        });
        mdateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month=month+1;
                Log.d(TAG, "onDateSet: mm/dd/yy: " + year + "/" + month + "/" + dayOfMonth);
                String date = month+ "/" + dayOfMonth + "/" + year;
                mEventDate.setText(date);
            }
        };

        //---------------------------------------------------------------------end of calender------------------------------------------------------------------


    }


    private CollectionReference collectionReference(String collection, String document, String doc_collection){

        CollectionReference databaseRegisterStudent = database.collection(collection)
                .document(document)
                .collection(doc_collection);

        return databaseRegisterStudent;
    }

}
