package com.example.gsc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ClubActivity extends AppCompatActivity {

    String clubName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club);

        TextView mClubName = findViewById(R.id.clubName);
        ImageView mclubLogo = findViewById(R.id.clubLogo);
        TextView mAboutClub = findViewById(R.id.aboutclub);
        Button mRegisterBtn = findViewById(R.id.RegistrationButton);

        int clubLogo = getIntent().getExtras().getInt("clubLogo");
       clubName = getIntent().getStringExtra("ClubName");
       final String aboutClub = getIntent().getStringExtra("AboutClub");

        final String head1 = getIntent().getStringExtra("Head1");
        final String head2 = getIntent().getStringExtra("Head2");
        final String email1 = getIntent().getStringExtra("Email1");
        final String email2 = getIntent().getStringExtra("Email2");
        final String phone1 = getIntent().getStringExtra("Phone1");
        final String phone2 = getIntent().getStringExtra("Phone2");
        final int mClubHeadPic1 = getIntent().getExtras().getInt("ClubHeadPic1");
        final int mClubHeadPic2 = getIntent().getExtras().getInt("ClubHeadPic2");


        mclubLogo.setImageResource(clubLogo);
        mClubName.setText(clubName);
        mAboutClub.setText(aboutClub);

        Button mHeadsBtn = findViewById(R.id.HeadsButton);
        mHeadsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HeadsBottomClass headsbottomview = new HeadsBottomClass();

                Bundle clubHeadNamesBundle = new Bundle();
                clubHeadNamesBundle.putString("head1",head1);
                clubHeadNamesBundle.putString("head2",head2);
                clubHeadNamesBundle.putString("email1",email1);
                clubHeadNamesBundle.putString("email2",email2);
                clubHeadNamesBundle.putString("phone1",phone1);
                clubHeadNamesBundle.putString("phone2",phone2);
                clubHeadNamesBundle.putInt("clubHeadPic1",mClubHeadPic1);
                clubHeadNamesBundle.putInt("clubHeadPic2",mClubHeadPic2);

                headsbottomview.setArguments(clubHeadNamesBundle);
                headsbottomview.show(getSupportFragmentManager(),"HeadsBottomView");
            }
        });

        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ClubActivity.this, RegistrationActivity.class);
                intent.putExtra("clubname",clubName);
                Log.d("Log_test", "onClick: " + clubName);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
    }


}
