package com.example.kissanapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class Analysis extends AppCompatActivity {

    String URL_BEANS = "https://www.youtube.com/watch?v=IFTuvbPgQMk";
    String URL_GOURD ="https://www.youtube.com/watch?v=lDnpQFVROqk";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analysis);
    }

    public void beans(View view) {

        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(URL_BEANS)));
        Log.i("Video", "Video Playing....");


    }

    public void gourd(View view) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(URL_GOURD)));
        Log.i("Video", "Video Playing....");
    }
}