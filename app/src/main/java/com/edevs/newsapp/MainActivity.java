package com.edevs.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.*;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //Hiding the title and action bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        //Setting fullscreen
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable()
        {
            @Override
            public void run()
            {   //Starting the next activity after the splash screen
                Intent i = new Intent(MainActivity.this, NameActivity.class);
                startActivity(i);
                finish();
            }
        }, 3000);
    }


}