package com.example.kissanapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AvailableAdeptor extends RecyclerView.Adapter<AvailableAdeptor.ListViewHolder> {
    private List<AvailableData> mData;
    static Context context;
    AvailableAdeptor(List<AvailableData> mData , Context  context){
        this.mData = mData;
        this.context = context;
    }

    @NonNull
    @Override
    public AvailableAdeptor.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.available, parent, false);
        return new AvailableAdeptor.ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AvailableAdeptor.ListViewHolder holder, int position) {
        AvailableData item = mData.get(position);
        holder.bind(item.Name,item.Phone,item.Location,item.Land);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
    public static  class ListViewHolder extends RecyclerView.ViewHolder{
        private TextView name;
        private TextView phone;
        private TextView location;
        private TextView land;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.Name);
            phone= itemView.findViewById(R.id.MobileNO);
            location = itemView.findViewById(R.id.location);
            land  = itemView.findViewById(R.id.totalLand);

        }
        public void bind(String text, String phn, String loc,String lan) {
            name.setText(text);
            phone.setText(phn);
            location.setText(loc);
            land.setText(lan);
        }
        public void toast(String data){
            Toast.makeText(context,data,Toast.LENGTH_SHORT).show();
        }

    }
}
