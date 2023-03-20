package com.example.kissanapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;

public class GiveOnLessee extends AppCompatActivity {

    RecyclerView recyclerView;
    List<AvailableData> dataList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_give_on_lessee);
        recyclerView= findViewById(R.id.availableList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));

        dataList = new ArrayList<>();
        dataList.add(new AvailableData("Nripender","1234567890","Jaipur Rajasthan","5 Decimal"));
        dataList.add(new AvailableData("Jayant","1234567890","Jaipur Rajasthan","15 Decimal"));
        dataList.add(new AvailableData("Sahaurya","1234567890","Jaipur Rajasthan","50 Decimal"));

        AvailableAdeptor availableAdeptor = new AvailableAdeptor(dataList,this);
        recyclerView.setAdapter(availableAdeptor);

    }

}