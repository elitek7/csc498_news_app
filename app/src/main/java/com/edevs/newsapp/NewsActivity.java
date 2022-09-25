package com.edevs.newsapp;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.AppCompatActivity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

public class NewsActivity extends AppCompatActivity
{
    private SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    // Lines 17 to 19 hide the title and action bar
    requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    getSupportActionBar().hide();
    setContentView(R.layout.activity_main);

        try
        {
    db = this.openOrCreateDatabase("newsdb", MODE_PRIVATE, null);
    db.execSQL("CREATE Table IF NOT EXISTS exam (name VARCHAR, url VARCHAR)");
    // To be ran once
    db.execSQL("INSERT INTO new (name, url) VALUES ('Top News', 'https://edition.cnn.com/')");
    db.execSQL("INSERT INTO new (name, url) VALUES ('World', 'https://edition.cnn.com/world')");
    db.execSQL("INSERT INTO new (name, url) VALUES ('Lebanese Politics', 'https://www.aljazeera.com/where/lebanon/')");
    db.execSQL("INSERT INTO new (name, url) VALUES ('Tech', 'https://www.bbc.com/news/technology')");
        }
        catch (Exception e)
    {
        e.printStackTrace(); //pinpoints the exact line in which the method raised the exception
    }
    /*mobileButton = findViewById(R.id.panel_mobile);
    parallelButton = findViewById(R.id.panel_parallel);
    softwareButton = findViewById(R.id.panel_software);
    discreteButton = findViewById(R.id.panel_discrete);*/

}

    public void post(View v)
    {
        Toast.makeText(this, "Post mode", Toast.LENGTH_SHORT).show();
        //Initializing an intent to access the post page
        Intent i = new Intent(getApplicationContext(), PostActivity.class);
        startActivity(i);
    }
}
