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
        String[] str = {"Global TV",
                "RCTI",
                "MNC TV",
                "NET TV",
                "SCTV",
                "Indosiar",
                "Trans 7",
                "ANTV",
        "Rajawali TV",
        "Spacetoon",
        "JakTV",
        "OChannel",
        "Comedy Channel",
        "Games Channel",
        "MNC Sport",
        "Movie Channel",
        "MNC Entertainment",
        "MNC Infotainment",
        "MNC Life Style",
        "MNC Shop",
        "Music Channel",
        "Food & Travel",
        "Auto & Gadget",
        "Life",
        "MNC Muslim",
        "TV One",
        "Kompas TV",
        "TVRI Nasional",
        "Metro TV HD",
        "MNC News",
        "CNN Indonesia",
        "Berita Satu",
        "iNews"};
        String[] path = {"https://cdn-livetv1.metube.id/hls/globaltv.m3u8",
                "https://cdn-livetv1.metube.id/hls/rcti.m3u8",
        "https://cdn-livetv1.metube.id/hls/mnctv.m3u8",
        "http://iptv.devanyahya.web.id:8000/live/devan/devan/74.ts",
        "https://kmklive-lh.akamaihd.net/i/sctv_live@94479/master.m3u8",
        "https://kmklive-lh.akamaihd.net/i/indosiar_live@94479/master.m3u8",
        "https://kmklive-lh.akamaihd.net/i/trans7_live@94476/master.m3u8",
        "https://kmklive-lh.akamaihd.net/i/antv_live@577566/master.m3u8",
        "https://kmklive-lh.akamaihd.net/i/rtv_live@137568/master.m3u8",
        "https://devanyahya.web.id/iptv/spacetoon.m3u8",
        "https://kmklive-lh.akamaihd.net/i/jaktv_live@94476/master.m3u8",
        "https://kmklive-lh.akamaihd.net/i/ochannel_live@94478/master.m3u8",
        "https://cdn-livetv1.metube.id/hls/comedy.m3u8",
        "https://cdn-livetv1.metube.id/hls/gameschannel.m3u8",
        "https://cdn-livetv1.metube.id/hls/mncsport.m3u8",
        "https://cdn-livetv1.metube.id/hls/mncmovie.m3u8",
        "https://cdn-livetv1.metube.id/hls/mncentertainment.m3u8",
        "https://cdn-livetv1.metube.id/hls/mncinfotainment.m3u8",
        "https://cdn-livetv1.metube.id/hls/mnclifestyle.m3u8",
        "https://cdn-livetv1.metube.id/hls/mncshop.m3u8",
        "https://cdn-livetv1.metube.id/hls/musicchannel.m3u8",
        "https://cdn-livetv1.metube.id/hls/foodtravel.m3u8",
        "https://cdn-livetv1.metube.id/hls/autogadget.m3u8",
        "https://cdn-livetv1.metube.id/hls/life.m3u8",
        "https://cdn-livetv1.metube.id/hls/mncmuslim.m3u8",
        "https://kmklive-lh.akamaihd.net/i/tvone_live@577566/master.m3u8",
        "https://kmklive-lh.akamaihd.net/i/kompastv_live@586951/master.m3u8",
        "https://cdn-livetv1.metube.id/hls/tvri.m3u8",
        "http://edge.metrotvnews.com:1935/live-edge/smil:metro.smil/playlist.m3u8",
        "https://cdn-livetv1.metube.id/hls/mncnews.m3u8",
        "https://live.cnnindonesia.com/livecnn/smil:cnntv.smil/playlist.m3u8",
        "http://iptv.devanyahya.web.id:8000/live/devan/devan/75.ts",
        "https://kmklive-lh.akamaihd.net/i/inewstv_live@94479/master.m3u8",};
        for (int i = 0; i < 33 ; i++) {
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
