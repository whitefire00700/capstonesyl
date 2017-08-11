package com.sylvester.android.sylvesterfrancis.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.sylvester.android.sylvesterfrancis.R;

import java.util.List;

/**
 * Created by sylvester on 30/07/17.
 */

public class AboutViewAdapter extends RecyclerView.Adapter<AboutViewAdapter.AboutViewHolder> {

    List<Object> contents;

    static final int TYPE_HEADER = 0;
    public AboutViewAdapter(List<Object> contents) {
        this.contents = contents;
    }

    public class AboutViewHolder extends RecyclerView.ViewHolder {
        public ImageView Map,Header;

        public AboutViewHolder(View view) {
            super(view);
            Map = view.findViewById(R.id.map);
            Header = view.findViewById(R.id.image_header);
        }
    }

    @Override
    public int getItemViewType(int position) {
        switch (position) {
            case 0:
                return TYPE_HEADER;
            default:
                return TYPE_HEADER;
        }
    }

    @Override
    public int getItemCount() {
        return contents.size();
    }

    @Override
    public AboutViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;


        switch (viewType) {
            case TYPE_HEADER: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.activity_aboutme, parent, false);
                return new AboutViewHolder(view) {
                };
            }
        }
        return null;
    }


    @Override
    public void onBindViewHolder(AboutViewHolder holder, int position) {
       Context context_map = holder.Map.getContext();
        String Map_Url = "https://maps.googleapis.com/maps/api/staticmap?center=Choolaimedu,Chennai,TamilNadu&zoom=14&size=1000x1000&key=AIzaSyC_FVwRpGXA-2QkLcU6ELnsEBwE8erHPEY";
        Picasso.with(context_map).load(Map_Url).resize(1000, 1000)
                .centerCrop().into(holder.Map);
        Context context_header = holder.Header.getContext();
        String header_img_url = "http://sylvester-whitefire00700.rhcloud.com/images/img.png";
        Picasso.with(context_header).load(header_img_url).placeholder(R.drawable.img1).into(holder.Header);
        switch (getItemViewType(position)) {
            case TYPE_HEADER:
                break;
        }
    }
}
