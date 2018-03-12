package com.ammase.androidtvonline.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ammase.androidtvonline.R;
import com.ammase.androidtvonline.VideoPlayActivity;
import com.ammase.androidtvonline.modul.VideoItem;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lincoln on 31/03/16.
 */

public class AdapterVideo extends RecyclerView.Adapter<AdapterVideo.MyViewHolder> {
    public List<VideoItem> resultsList;
    private Context mContext;


    public AdapterVideo(Context context, ArrayList<VideoItem> images) {
        this.mContext = context;
        this.resultsList = images;
    }

    public void setListItem(List<VideoItem> listItem) {
        this.resultsList = listItem;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_view, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder viewHolder, final int position) {
        viewHolder.textViewNamaVideo.setText(resultsList.get(position).getNamaVideo());

        /*Glide.with(mContext).load(Const.BASE_URL+"/adminkc/img/promo/"+resultsList.get(position).getNamaGambar())
                .thumbnail(0.1f)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(viewHolder.thumbnail);*/

        viewHolder.LinearItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, VideoPlayActivity.class);
                    i.putExtra("Item_Url_Video", resultsList.get(position).getVideo().toString());
                v.getContext().startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return resultsList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imageViewVideo) ImageView imageViewVideo;
        @BindView(R.id.textViewNamaVideo) TextView textViewNamaVideo;
        @BindView(R.id.LinearItem) LinearLayout LinearItem;
        public MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);

        }
    }
}