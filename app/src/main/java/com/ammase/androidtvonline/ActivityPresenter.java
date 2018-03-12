package com.ammase.androidtvonline;

import android.util.Log;

import com.ammase.androidtvonline.api.NetworkClient;
import com.ammase.androidtvonline.api.RequestAPI;
import com.ammase.androidtvonline.modul.ResponseGetVideo;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by programmer on 12/22/17.
 */

public class ActivityPresenter {
    private ActivityView view;
    private CompositeDisposable mCompositeDisposable;

    public ActivityPresenter(ActivityView view) {
        this.view = view;
    }

    public void loadAllData() {
        view.showLoading();
        RequestAPI requestAPI = NetworkClient.getRetrofit().create(RequestAPI.class);
        if (mCompositeDisposable == null) mCompositeDisposable = new CompositeDisposable();
        mCompositeDisposable.add(requestAPI.getVideo()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                        responseAuth -> combineSuccessObserver(responseAuth),
                        throwable -> combineErrorObserver(throwable)
                )
        );

    }

    private void combineSuccessObserver(ResponseGetVideo responseAuth) {
        view.hideLoading();
        view.handleLoadDataSuccess(responseAuth);

        Log.v("DATAKU :", responseAuth.getVideo().get(0).getNamaVideo());
    }

    private void combineErrorObserver(Throwable throwable) {
        view.handleLoadDataError(throwable);
        view.showLoading();

        Log.v("DATAKU ERROR :", throwable.getMessage());
    }
}
