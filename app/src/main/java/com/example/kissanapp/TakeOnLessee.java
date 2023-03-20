package com.example.kissanapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class TakeOnLessee extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_on_lessee);
    }
    public void SubmitData(View view) {
        ListAdeptor.notification("Will Soon Inform You . \n"+
                                    "Thanks.");
        finish();
    }
}