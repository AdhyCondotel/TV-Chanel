package com.ammase.androidtvonline.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ammase.androidtvonline.R;
import com.ammase.androidtvonline.mode.VideoInfor;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by sujizhong on 16/6/30.
 */
public class VideoListAdapter extends BaseAdapter {

    private class ViewHodler {
        TextView mText_VideoTitle;
    }

    private List<VideoInfor> mLists = new ArrayList<>();
    private LayoutInflater mLayoutInflater;

    public VideoListAdapter(Context cxt) {
        mLayoutInflater = LayoutInflater.from(cxt);
    }

    public void setData(List<VideoInfor> data) {
        mLists.clear();
        String[] str = {"Siaran Live MP4", "Siaran2 Live MP4"};
        String[] path = {"http://103.53.184.165:9981/stream/channel/79daf06e741ea00008cdd8f37ac6eab3?ticket=656284E0B89AE727EE28FA8C59FA19DEDFAB5B3E", "http://adi:qwerty123@103.53.184.165:9981/stream/channel/79daf06e741ea00008cdd8f37ac6eab3?ticket=656284E0B89AE727EE28FA8C59FA19DEDFAB5B3E"};
        for (int i = 0; i < 2; i++) {
            VideoInfor videoInfor = new VideoInfor();
            videoInfor.videoPath = path[i];
            videoInfor.videoTitle = str[i];
            mLists.add(videoInfor);
        }
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mLists != null ? mLists.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return mLists != null ? mLists.get(position) : null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHodler viewHodler;
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.video_item, null);
            viewHodler = new ViewHodler();
            viewHodler.mText_VideoTitle = (TextView) convertView.findViewById(R.id.text_video_item_title);
            convertView.setTag(viewHodler);
        } else {
            viewHodler = (ViewHodler) convertView.getTag();
        }
        VideoInfor infor = mLists.get(position);
        viewHodler.mText_VideoTitle.setText(infor.videoTitle);
        return convertView;
    }

}
