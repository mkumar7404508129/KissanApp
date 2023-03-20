package com.example.kissanapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.List;

public class VideoListAdapter extends RecyclerView.Adapter<VideoListAdapter.ListViewHolder> {
    private List<VideoData> mData;
    static String TAG  ="VideoAdapter";
    static Context context;
    VideoListAdapter(List<VideoData> mData , Context  context){
        this.mData = mData;
        this.context = context;
    }

    @NonNull
    @Override
    public VideoListAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.video, parent, false);
        return new VideoListAdapter.ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoListAdapter.ListViewHolder holder, int position) {
        VideoData item = mData.get(position);
        holder.bind(item.URL);
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
            mTextView = itemView.findViewById(R.id.urlText);
            img = itemView.findViewById(R.id.VideoImg);

        }
        public void bind(String url) {
            String id= getVideoIdFromUrl(url);
            String thumUrl = getThumbnailUrl(id);
            Log.i(TAG,url);
            Glide.with(context)
                    .load(thumUrl)
                    .into(img);
            mTextView.setText(url);
        }
        public void toast(String data){
            Toast.makeText(context,data,Toast.LENGTH_SHORT).show();
        }
        public  void notification(String data){
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

        public String getVideoIdFromUrl(String videoUrl) {
            String videoId = "";

            // Sample video URL: https://www.youtube.com/watch?v=abcdefg
            String[] urlParts = videoUrl.split("v="); // Split URL at "v="
            Log.i(TAG,urlParts.length+" " +urlParts[1]);
            if (urlParts.length > 1) {
                String videoIdWithParams = urlParts[1]; // Get everything after "v="
                int ampersandPosition = videoIdWithParams.indexOf("&"); // Check for any additional parameters
                if (ampersandPosition != -1) {
                    videoId = videoIdWithParams.substring(0, ampersandPosition); // Extract video ID
                } else {
                    videoId = videoIdWithParams; // Extract video ID
                }
            }

            return videoId;
        }
        private String getThumbnailUrl(String videoId) {
            Log.i("Test",videoId);
            return "https://img.youtube.com/vi/" + videoId+ "/0.jpg";
        }

    }
}
