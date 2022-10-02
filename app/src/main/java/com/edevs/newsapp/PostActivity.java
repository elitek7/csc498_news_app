package com.edevs.newsapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PostActivity extends AppCompatActivity
{
    private SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        androidx.appcompat.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.e_devs_band));
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        db = this.openOrCreateDatabase("newwwwdb", MODE_PRIVATE, null);

    }

    public void done (View v)
    {
        EditText author = (EditText)findViewById(R.id.author);
        String author_input = author.getText().toString();
        EditText published_at = (EditText)findViewById(R.id.published_at);
        String published_input = published_at.getText().toString();
        EditText location = (EditText)findViewById(R.id.location);
        String location_input = location.getText().toString();
        EditText description = (EditText)findViewById(R.id.description);
        String description_input = description.getText().toString();
        String name = "User News";


        db.execSQL("INSERT INTO new (name, description, author, published_at, location) VALUES (" + name +  ", " + description_input+ ", " + author_input+ ", " + published_input+ ", " + location_input+")");
        Toast.makeText(this, "Your news have been added", Toast.LENGTH_SHORT).show();
    }
}
