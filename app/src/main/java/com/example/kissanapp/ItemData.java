package com.example.kissanapp;

import android.content.Context;
import android.graphics.drawable.Drawable;

public class ItemData {
    String itemName;
    Context context;
    Drawable appLogo;
    int dataNum;
    ItemData( Context context,Drawable appLogo,String itemName,int dataNum){
        this.appLogo =appLogo;
        this.itemName = itemName;
        this.dataNum = dataNum;
    }

}
