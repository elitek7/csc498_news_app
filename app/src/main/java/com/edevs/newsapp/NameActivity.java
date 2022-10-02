package com.edevs.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

public class NameActivity extends AppCompatActivity
{
    SharedPreferences shared;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //Hiding the title and action bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        //Setting fullscreen
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        shared = this.getSharedPreferences("com.lau.shared", Context.MODE_PRIVATE);
        setContentView(R.layout.activity_name);
    }

    public void enter(View v)
    {
        EditText username = (EditText)findViewById(R.id.username);
        String username_input = username.getText().toString();
        if(username_input.equals(""))
        {       //Making sure the user inputs their name
                Toast.makeText(this, "Please enter your name.", Toast.LENGTH_LONG).show();
        }
        else
        {   //Saving the user's name to the Shared Preferences
            shared.edit().putString("Username", username_input);
            Toast.makeText(this, "Latest news", Toast.LENGTH_SHORT).show();
            //Initializing an intent to access the news page
            Intent i = new Intent(getApplicationContext(), NewsActivity.class);
            i.putExtra("username", username_input);
            startActivity(i);
        }
    }
}
