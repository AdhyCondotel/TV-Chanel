package com.ammase.androidtvonline;

import com.ammase.androidtvonline.modul.ResponseGetVideo;

/**
 * Created by programmer on 12/22/17.
 */

public interface ActivityView {
    void showLoading();
    void hideLoading();
    void handleLoadDataSuccess(ResponseGetVideo responseAuth);
    void handleLoadDataError(Throwable throwable);
}
