package com.example.kissanapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class LearnMore extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_more);
        recyclerView = findViewById(R.id.ListView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        List<VideoData> list = new ArrayList<>();
        list.add(new VideoData("https://www.youtube.com/watch?v=l0bpy857deM"));
        VideoListAdapter adapter = new VideoListAdapter(list,this);
        recyclerView.setAdapter(adapter);
    }
}