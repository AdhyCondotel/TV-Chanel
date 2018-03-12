package com.ammase.androidtvonline;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.ammase.androidtvonline.adapter.AdapterVideo;
import com.ammase.androidtvonline.modul.ResponseGetVideo;
import com.ammase.androidtvonline.modul.VideoItem;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements ActivityView {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private ActivityPresenter presenter;
    private List<VideoItem> listItem;
    private AdapterVideo mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        presenter = new ActivityPresenter(this);
        presenter.loadAllData();
        initComponent();
    }

    private void initComponent() {
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new AdapterVideo (this,new ArrayList<>());
        recyclerView.setAdapter(mAdapter);

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void handleLoadDataSuccess(ResponseGetVideo responseAuth) {
        this.listItem = new ArrayList<>(responseAuth.getVideo());
        mAdapter.setListItem(listItem);
        mAdapter.notifyDataSetChanged();

        /*jumlah = 0;
        for (int i = 0; i < listItem.size(); i++) {
            jumlah = jumlah + Integer.valueOf(listItem.get(i).getTotalBayar());

            DecimalFormat formatter = new DecimalFormat("#,###,###");
            String harga = formatter.format(jumlah);
            txtJumlahTotal.setText("Rp. " + harga);
        }*/
    }

    @Override
    public void handleLoadDataError(Throwable throwable) {

    }
}
