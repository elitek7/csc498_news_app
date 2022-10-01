package com.edevs.newsapp;

import android.content.Intent;
import android.database.Cursor;
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
import android.widget.RelativeLayout;
import android.widget.Toast;

public class NewsActivity extends AppCompatActivity
{
    private RelativeLayout topButton;
    private RelativeLayout worldButton;
    private RelativeLayout lebaneseButton;
    private RelativeLayout techButton;
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
            db = this.openOrCreateDatabase("newdb", MODE_PRIVATE, null);
            db.execSQL("CREATE Table IF NOT EXISTS new (name VARCHAR, description TEXT, author VARCHAR, published_at VARCHAR, location VARCHAR)");
            // To be ran once
            db.execSQL("INSERT INTO new (name, description, author, published_at, location) VALUES ('Top News', 'hello top', 'author1', 'published1', 'loc1')");
            db.execSQL("INSERT INTO new (name, description, author, published_at, location) VALUES ('World News', 'hello world', 'author2', 'published2', 'loc2')");
            db.execSQL("INSERT INTO new (name, description, author, published_at, location) VALUES ('Lebanese Politics', 'hello leb', 'author3', 'published3', 'loc3')");
            db.execSQL("INSERT INTO new (name, description, author, published_at, location) VALUES ('Tech News', 'hello tech', 'author4', 'published4', 'loc4')");
        }
        catch (Exception e)
    {
        e.printStackTrace(); //pinpoints the exact line in which the method raised the exception
    }
        topButton = findViewById(R.id.panel_top);
        worldButton = findViewById(R.id.panel_world);
        lebaneseButton = findViewById(R.id.panel_lebanese);
        techButton = findViewById(R.id.panel_tech);

        topButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String description = "";
                String author = "";
                String published_at = "";
                String location = "";

                Cursor c = db.rawQuery("SELECT description FROM new WHERE name = \"Top News\"", null);
                int n = c.getColumnIndex("description");
                c.moveToFirst();
                description = c.getString(n);

                Cursor d = db.rawQuery("SELECT author FROM new WHERE name = \"Top News\"", null);
                int o = d.getColumnIndex("author");
                d.moveToFirst();
                author = d.getString(o);

                Cursor e = db.rawQuery("SELECT published_at FROM new WHERE name = \"Top News\"", null);
                int p = e.getColumnIndex("published_at");
                e.moveToFirst();
                published_at = e.getString(p);

                Cursor f = db.rawQuery("SELECT location FROM new WHERE name = \"Top News\"", null);
                int q = f.getColumnIndex("location");
                f.moveToFirst();
                location = f.getString(q);

                Intent goToPage = new Intent(getApplicationContext(), InfoActivity.class);
                goToPage.putExtra("Description", description);
                goToPage.putExtra("Author", author);
                goToPage.putExtra("Published At", published_at);
                goToPage.putExtra("Location", location);
                startActivity(goToPage);
            }
        });

        worldButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String description = "";
                String author = "";
                String published_at = "";
                String location = "";

                Cursor c = db.rawQuery("SELECT description FROM new WHERE name = \"World News\"", null);
                int n = c.getColumnIndex("description");
                c.moveToFirst();
                description = c.getString(n);

                Cursor d = db.rawQuery("SELECT author FROM new WHERE name = \"World News\"", null);
                int o = d.getColumnIndex("author");
                d.moveToFirst();
                author = d.getString(o);

                Cursor e = db.rawQuery("SELECT published_at FROM new WHERE name = \"World News\"", null);
                int p = e.getColumnIndex("published_at");
                e.moveToFirst();
                published_at = e.getString(p);

                Cursor f = db.rawQuery("SELECT location FROM new WHERE name = \"World News\"", null);
                int q = f.getColumnIndex("location");
                f.moveToFirst();
                location = f.getString(q);

                Intent goToPage = new Intent(getApplicationContext(), InfoActivity.class);
                goToPage.putExtra("Description", description);
                goToPage.putExtra("Author", author);
                goToPage.putExtra("Published At", published_at);
                goToPage.putExtra("Location", location);
                startActivity(goToPage);
            }
        });

        lebaneseButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String description = "";
                String author = "";
                String published_at = "";
                String location = "";

                Cursor c = db.rawQuery("SELECT description FROM new WHERE name = \"Lebanese Politics\"", null);
                int n = c.getColumnIndex("description");
                c.moveToFirst();
                description = c.getString(n);

                Cursor d = db.rawQuery("SELECT author FROM new WHERE name = \"Lebanese Politics\"", null);
                int o = d.getColumnIndex("author");
                d.moveToFirst();
                author = d.getString(o);

                Cursor e = db.rawQuery("SELECT published_at FROM new WHERE name = \"Lebanese Politics\"", null);
                int p = e.getColumnIndex("published_at");
                e.moveToFirst();
                published_at = e.getString(p);

                Cursor f = db.rawQuery("SELECT location FROM new WHERE name = \"Lebanese Politics\"", null);
                int q = f.getColumnIndex("location");
                f.moveToFirst();
                location = f.getString(q);

                Intent goToPage = new Intent(getApplicationContext(), InfoActivity.class);
                goToPage.putExtra("Description", description);
                goToPage.putExtra("Author", author);
                goToPage.putExtra("Published At", published_at);
                goToPage.putExtra("Location", location);
                startActivity(goToPage);
            }
        });

        techButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String description = "";
                String author = "";
                String published_at = "";
                String location = "";

                Cursor c = db.rawQuery("SELECT description FROM new WHERE name = \"Tech News\"", null);
                int n = c.getColumnIndex("description");
                c.moveToFirst();
                description = c.getString(n);

                Cursor d = db.rawQuery("SELECT author FROM new WHERE name = \"Tech News\"", null);
                int o = d.getColumnIndex("author");
                d.moveToFirst();
                author = d.getString(o);

                Cursor e = db.rawQuery("SELECT published_at FROM new WHERE name = \"Tech News\"", null);
                int p = e.getColumnIndex("published_at");
                e.moveToFirst();
                published_at = e.getString(p);

                Cursor f = db.rawQuery("SELECT location FROM new WHERE name = \"Tech News\"", null);
                int q = f.getColumnIndex("location");
                f.moveToFirst();
                location = f.getString(q);

                Intent goToPage = new Intent(getApplicationContext(), InfoActivity.class);
                goToPage.putExtra("Description", description);
                goToPage.putExtra("Author", author);
                goToPage.putExtra("Published At", published_at);
                goToPage.putExtra("Location", location);
                startActivity(goToPage);
            }
        });
    }

    public void post(View v)
    {
        Toast.makeText(this, "Post mode", Toast.LENGTH_SHORT).show();
        //Initializing an intent to access the post page
        Intent i = new Intent(getApplicationContext(), PostActivity.class);
        startActivity(i);
    }
}
