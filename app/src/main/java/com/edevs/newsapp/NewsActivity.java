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
            db = this.openOrCreateDatabase("newwwwdb", MODE_PRIVATE, null);
            db.execSQL("CREATE Table IF NOT EXISTS new (name VARCHAR, description TEXT, author VARCHAR, published_at VARCHAR, location VARCHAR)");
            // To be ran once
            db.execSQL("INSERT INTO new (name, description, author, published_at, location) VALUES ('Top News', 'Russian forces retreat from strategic Donetsk city a day after Moscow’s annexation of the region.\n Russian forces retreated from Lyman, a strategic city for its operations in the east, the Russian defense ministry said Saturday, just a day after Moscow’s annexation of the region that’s been declared illegal by the West.\n" +
                    "\n" + "“In connection with the creation of a threat of encirclement, allied troops were withdrawn from the settlement of Krasny Liman to more advantageous lines,” the ministry said on Telegram, using the Russian name for the town of Lyman.', 'Kostan Nechyporenko', 'Published 10:46 AM EDT, Sat October 1, 2022', 'Kyiv, Ukraine')");
            db.execSQL("INSERT INTO new (name, description, author, published_at, location) VALUES ('World News', 'South Korean President warns North over nuclear program.\n North Korea will face “a determined and overwhelming response” from South Korea and the United States if it attempts to use nuclear weapons, South Korea’s President Yoon Suk Yeol said Saturday.\n" +
                    "\n" + "Speaking at the nation’s 74th Armed Forces Day ceremony, Yoon called North Korea’s recent law declaring itself a “nuclear weapons state” a threat to the survival and prosperity of South Korea and reiterated calls for Kim Jong Un to denuclearize.', 'Yoonjung Seo', 'Published 11:56 PM EDT, Fri September 30, 2022', 'Seoul, South Korea')");
            db.execSQL("INSERT INTO new (name, description, author, published_at, location) VALUES ('Lebanese Politics', '63 blank votes, 36 votes for Mouawad, 11 for Edde in 1st round of presidential election.\n The Lebanese parliament on Thursday held a first presidential election round in which no candidate managed to garner 86 votes needed to win from the first round.\n" +
                    "\n" + "As 63 MPs cast blank ballots, 36 voted for MP Michel Mouawad, 11 voted for entrepreneur and philanthropist Salim Edde, 10 voted for \"Lebanon\", one voted for Mahsa Amini who died in Iranian morality police custody, and one voted for \"the approach of (slain ex-PM) Rashid Karami\".', 'Naharnet Newsdesk', 'Published 1:07 PM EDT, Thu September 29, 2022', 'Beirut, Lebanon')");
            db.execSQL("INSERT INTO new (name, description, author, published_at, location) VALUES ('Tech News', 'Out-of-service satellites must be removed within 5 years, FCC says.\n Satellites that are no longer in service must get out of the sky far more quickly under a new rule adopted by US federal regulators Thursday — and it’s all in the name of combating the garbage in Earth’s orbit.\n" +
                    "\n" + "Unused satellites in low-Earth orbit, which is the area already most congested with satellites, must be dragged out of orbit “as soon as practicable, and no more than five years following the end of their mission,” according to the new Federal Communications Commission rule.', 'Jackie Wattles', 'Published 1:29 PM EDT, Thu September 29, 2022', 'Washington')");
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
