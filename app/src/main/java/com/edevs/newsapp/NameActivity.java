package com.edevs.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

public class NameActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_name);
    }

    public void enter(View v)
    {
        EditText username = (EditText)findViewById(R.id.username);
        String username_input = username.getText().toString();
        Toast.makeText(this, "Latest news", Toast.LENGTH_SHORT).show();
        //Initializing an intent to access the news page
        Intent i = new Intent(getApplicationContext(), NewsActivity.class);
        i.putExtra("username", username_input);
        startActivity(i);
    }
}
