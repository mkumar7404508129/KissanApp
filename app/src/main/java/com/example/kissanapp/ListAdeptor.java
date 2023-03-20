package com.example.kissanapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdeptor extends RecyclerView.Adapter<ListAdeptor.ListViewHolder> {
    private List<ItemData> mData;
  static   Context context;
    ListAdeptor(List<ItemData> mData , Context  context){
        this.mData = mData;
        this.context = context;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        ItemData item = mData.get(position);
        holder.bind(item.itemName,item.appLogo,item.dataNum);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
    public static  class ListViewHolder extends RecyclerView.ViewHolder{
        private TextView mTextView;
        private ImageView img;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.my_text_view);
            img = itemView.findViewById(R.id.appPic);

        }
        public void bind(String text, Drawable drawable,int item) {
            mTextView.setText(text);
            img.setImageDrawable(drawable);
            img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // replace with the package name of the app you want to launch
                    switch (item){
                        case 1:
                            notification("Your request is initialization." +
                                    "\n Soon team will come and Collect Data." +
                                    "\n Thanks for connecting");
                            break;
                        case 2:
                            notification("Our Team will Test and Update by 23/03/2023");
                            break;
                        case 3:
                            context.startActivity(new Intent(context,Analysis.class));
                            break;
                        case 4:
                            context.startActivity(new Intent(context,FindSolutions.class));
                            break;
                        case 5:
                            context.startActivity(new Intent(context,LearnMore.class));
                            break;
                        case 7:
                            context.startActivity(new Intent(context,TakeOnLessee.class));
                            break;
                        case 6:
                            context.startActivity(new Intent(context,GiveOnLessee.class));
                            break;

                    }
                }
            });
        }
        public void toast(String data){
            Toast.makeText(context,data,Toast.LENGTH_SHORT).show();
        }

    }
    static public  void notification(String data){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("WiFi is disabled");
        builder.setMessage(data);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // do nothing
            }
        });
        builder.show();
    }
}
