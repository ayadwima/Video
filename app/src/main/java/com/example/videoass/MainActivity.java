package com.example.videoass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn1,btn2,btn3,btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);



        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goVideo("https://firebasestorage.googleapis.com/v0/b/mccfirebase-ff14c.appspot.com/o/yt1s.com%20-%20AWARD%20WINNING%20Best%20Short%20Video%20%20Share%20Care%20Joy%20%20%20By%20Naik%20Foundation.mp4?alt=media&token=93fec59e-99fa-4de7-b878-d35c2e27d50d");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goVideo("https://firebasestorage.googleapis.com/v0/b/mccfirebase-ff14c.appspot.com/o/Stay%20at%20Home%20_%20One%20Minute%20Short%20Film%20Challenge%20_Film%20Riot.mp4?alt=media&token=37aa3145-7718-4389-ac08-fa326d676fc5");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goVideo("https://firebasestorage.googleapis.com/v0/b/mccfirebase-ff14c.appspot.com/o/yt1s.com%20-%20Toast%20%20One%20Minute%20Comedy%20Film%20%20Award%20Winning.mp4?alt=media&token=3f3b13fc-70b9-4810-a934-9233592d6827");

            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goVideo("https://firebasestorage.googleapis.com/v0/b/mccfirebase-ff14c.appspot.com/o/yt1s.com%20-%20DREAM%20%20Short%20Film%20Right%20to%20Education.mp4?alt=media&token=079df1ba-ea18-4fa2-aa50-6581b9140e7c");

            }
        });

    }
    public  void goVideo(String url){
        Intent i =new Intent(this, VideoStreamActivity.class);
        i.putExtra("VideoUrl",url);
        startActivity(i);
    }
    /*
       val i = Intent(this, VideoStreamingActivity::class.java)
        i.putExtra("URL", url)
        startActivity(i)
     */
    }