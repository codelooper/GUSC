package com.example.gsc;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class ClubFragment extends Fragment {

    RecyclerView mClubList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_club,container,false);

        // this is for club list.

        ArrayList<ClubList> mclublist = new ArrayList<>();

        mclublist.add(new ClubList(R.drawable.gu_mnangement_logo,"GU Management Team",getString(R.string.About_Club),"Gautam Arya","Deepanshu Goyal","gautam.arya01_2017@galgotiasuniversity.edu.in","deepanshu.goyal01_2017@galgotiasuniversity.edu.in","7764911451","8979106667"));
        mclublist.add(new ClubList(R.drawable.technojam_logo,"TechnoJam",getString(R.string.About_Club),"Anubhav Raj Singh","Swetank","anubhavraj.08@gmail.com","Swetank199@gmail.com","9521419475","7042435242"));
        mclublist.add(new ClubList(R.drawable.frag_logo,"F.R.A.G Club",getString(R.string.About_Club),"Prayas Kundu","Amaan Siddiqui","prayasm4a1@gmail.com","amaansiddiqui14@gmail.com","9818441774","9811679465"));
        mclublist.add(new ClubList(R.drawable.kafila_logo,"Kafila",getString(R.string.About_Club),"Swastik Anand Tripathi","Sujata Tripathi","swastik.tripathicool@gmail.com","sujatatripathi1619@gmail.com","8918756193","7985211676"));
        mclublist.add(new ClubList(R.drawable.galgotias_university_small_logo,"Stage Management",getString(R.string.About_Club),"Abhishek Das","xx","abhishekdas672@gmail.com","xx","7503674855","xx"));
        mclublist.add(new ClubList(R.drawable.artsclubnew_logo,"Artistico",getString(R.string.About_Club),"Mohd Rehan Shaikh","Simran Kushwah","rehannshaikh5@gmail.com","xx","9956484367","8130323814"));
        mclublist.add(new ClubList(R.drawable.the_actors_hub_logo,"The Actor's Hub",getString(R.string.About_Club),"Priyank Bhardwaj","Vishvendra Singh","Priyank.bhardwaj@galgotiasuniversity.edu.in","vishvendra993@gmail.com","8650831342","9784352341"));
        mclublist.add(new ClubList(R.drawable.note_veda_logo,"Noteveda",getString(R.string.About_Club),"Shubhang Sinha","Pratibha Saanvi","shubhangsinha7@gmail.com","saanvisings201@gmail.com","9889805805","xx"));
        mclublist.add(new ClubList(R.drawable.vervelogo,"Verve",getString(R.string.About_Club),"Syed Awwab Tausif","Niharika Kashyap","awwabtausif@gmail.com","niharikakashyap3456@gmail.com","8791788834","919650181408"));
        mclublist.add(new ClubList(R.drawable.studio_d_club_logo,"Studio-D",getString(R.string.About_Club),"Sachin pal","Rakshit Malhotra","sachinpal.sp20@gmail.com","rakshit5898@gmail.com","8447335115","9811131428"));
        mclublist.add(new ClubList(R.drawable.marketing_logo1,"Marketing Team",getString(R.string.About_Club),"Harsh Chandani","Tanmay Shukla","harsh.chandani01_2017@galgotiasuniversity.edu.in","tanmay.shukla01_2017@galgotiasuniversity.edu.in","7455095984","8448948126"));
        mclublist.add(new ClubList(R.drawable.galgotias_university_small_logo,"Scintillation",getString(R.string.About_Club),"Shubham Rawat","Harsha Anisy","shubhamrawat8393@gmail.com","harshanisy98@gmail.com","8393814338","9939285138"));
        mclublist.add(new ClubList(R.drawable.cam_circle_refined2_logo,"Cam Circle",getString(R.string.About_Club),"Nishant Jha","Kartik Saxena","jhanishant96@gmail.com","kartiksaxena055@gmail.com","9667652548","8588051025"));
        mclublist.add(new ClubList(R.drawable.literary_club_lingo_freax_logo,"Lingo Freaks",getString(R.string.About_Club),"Sneha Sakshi","Bakhtawar Parvez","snehasdf@gmail.com","bakhtawarparvez@gmail.com","9868342117","9044322341"));
        mclublist.add(new ClubList(R.drawable.galgotias_university_small_logo,"Sponsorship team",getString(R.string.About_Club),"Akarsh Baliyan","Abhishek Anand","akarsh.baliyan@galgotiasuniversity.edu.in","abhishek.anand02_2017@galgotiasuniversity.edu.in","7042741941","8800285169"));
        mclublist.add(new ClubList(R.drawable.galgotias_university_small_logo,"Automantra Racing",getString(R.string.About_Club),"Shobhit Agarwal","Aakash Jawla","shobhit.agarwal@galgotiasuniversity.edu.in","aakash.jawla@galgotiasuniversity.edu.in","9717279078","9458268292"));
        mclublist.add(new ClubList(R.drawable.humanity_saviours_logo,"The Humanity Saviours Club",getString(R.string.About_Club),"Sudhanshu Agarwal","Pallavi Thakur","sudhanshu.agarwal@galgotiasuniversity.edu.in","Pallavi@galgotiasuniversity.edu.in","8588075444","7982549405"));
        mclublist.add(new ClubList(R.drawable.grace_logo,"GRACE",getString(R.string.About_Club),"Shahzeb Khan","Mohd Saquib","shahzeb.khan@galgotiasuniversity.edu.in","mohd.saquib1@galgotiasuniversity.edu.in","9795406782","9554262772"));
        mclublist.add(new ClubList(R.drawable.comikaze_1_logo,"Comikaze",getString(R.string.About_Club),"Pragya bhardwaj","Dishank sharma","sharma06pragya@gmail.com","kdevesh58@gmail.com","9990703496","9540386339"));
        mclublist.add(new ClubList(R.drawable.g_post_logo,"G-Post",getString(R.string.About_Club),"Priyansh Mishra","xx","priyansh.mishra01_2017@galgotiasuniversity.edu.in","xx","8448948119","xx"));
        mclublist.add(new ClubList(R.drawable.graphex_club_logo,"Graphex",getString(R.string.About_Club),"Ankur pal","Ayush upadhyay","palankur891@gmail.com","uayush600@gmail.com","8448661167","8765910889"));
        mclublist.add(new ClubList(R.drawable.galgotias_university_small_logo,"Reverso",getString(R.string.About_Club),"Apoorv Mishra","xx","apoorv.misra@galgotiasuniversity.edu.in","xx","7291826231","xx"));
        mclublist.add(new ClubList(R.drawable.galgotias_university_small_logo,"IRIS",getString(R.string.About_Club),"KUMAR DIVYA MANI","xx","dxivyamani@gmail.com","xx","9667898837","xx"));
        mclublist.add(new ClubList(R.drawable.galgotias_university_small_logo,"Online Promotions",getString(R.string.About_Club),"Anindita Chaki","Tanul Prabhat Rai","aninditachaki1234@gmail.com","tanul9876@gmail.com","8448268447","8604607841"));


        mClubList = rootView.findViewById(R.id.clubRecyclerView);
        mClubList.setLayoutManager(new LinearLayoutManager(getActivity()));
        mClubList.setAdapter(new ClubListAdapter(mclublist,getActivity()));
        return rootView;
    }
}

