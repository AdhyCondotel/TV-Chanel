package com.ammase.androidtvonline.api;

import com.ammase.androidtvonline.modul.ResponseGetVideo;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface RequestAPI {
    //get data news
    @GET("/karebosicondotel-api/data-video/video-menu.php")
    Observable<ResponseGetVideo> getVideo();

}
