package com.example.kissanapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.ImageView;


import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView manageLand;
//LinearLayoutManager layoutManager;
    List<ItemData> data;
    List<ItemData> landData;

    ImageView ksanImg;
    GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).setIcon(R.drawable.ic_launcher_background);
        getSupportActionBar().setTitle("OUR KISSAN");
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        ksanImg = findViewById(R.id.KisanImage);
        ksanImg.setImageBitmap(generateBitmap(R.raw.khet));

        recyclerView  = findViewById(R.id.my_recycler_view);
        manageLand = findViewById(R.id.manage_land);
        manageLand.setLayoutManager(new GridLayoutManager(this,3));
        layoutManager = new GridLayoutManager(this,3);
        recyclerView.setLayoutManager(layoutManager);

        data  = new ArrayList<>();
        landData = new ArrayList<>();
        data.add(new ItemData(this,getDrawable(R.mipmap.soil_test_round),"Soil Test",1));
        data.add(new ItemData(this,getDrawable(R.mipmap.soil_progress_round),"Test Progress",2));
        data.add(new ItemData(this,getDrawable(R.mipmap.soil_analisis_round),"Analysis",3));
        data.add(new ItemData(this,getDrawable(R.mipmap.findsolution),"Find Solutions",4));
        data.add(new ItemData(this,getDrawable(R.mipmap.learnmore),"Learn More",5));

        landData = new ArrayList<>();

        landData.add(new ItemData(this,getDrawable(R.mipmap.lessee),"Take Lessee",6));
        landData.add(new ItemData(this,getDrawable(R.mipmap.lessee_give),"Give On essee",7));

        ListAdeptor adapter = new ListAdeptor(data,this);
        manageLand.setAdapter(new ListAdeptor(landData,this));
        recyclerView.setAdapter(adapter);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_add) {
            // Handle the add action
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    private Bitmap generateBitmap(int Id){
        Resources resources = getResources();
        InputStream inputStream = resources.openRawResource(Id);
        Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
        return  bitmap;
    }
}