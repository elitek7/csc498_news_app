package com.edevs.newsapp;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class InfoActivity extends AppCompatActivity
{
    private String description = "";
    private String author = "";
    private String published_at = "";
    private String location = "";

    private TextView descriptionView;
    private TextView authorView;
    private TextView publishedView;
    private TextView locationView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_info);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        description = getIntent().getStringExtra("Description");
        author = getIntent().getStringExtra("Author");
        published_at = getIntent().getStringExtra("Published At");
        location = getIntent().getStringExtra("Location");

        descriptionView = (TextView) findViewById(R.id.descriptionView);
        descriptionView.setText(description);
        authorView = (TextView) findViewById(R.id.authorView);
        authorView.setText("Author: " + author);
        publishedView = (TextView) findViewById(R.id.publishedView);
        publishedView.setText(published_at);
        locationView = (TextView) findViewById(R.id.locationView);
        locationView.setText(location);
    }
}
