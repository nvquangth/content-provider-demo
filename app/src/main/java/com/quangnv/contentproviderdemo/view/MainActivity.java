package com.quangnv.contentproviderdemo.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.quangnv.contentproviderdemo.R;
import com.quangnv.contentproviderdemo.model.ImageAdapter;
import com.quangnv.contentproviderdemo.presenter.PresenterImpl;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView {

    private RecyclerView mRecyclerView;
    private ImageAdapter mAdapter;
    private PresenterImpl mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        mPresenter.loadImages();
    }

    private void init() {
        mRecyclerView = findViewById(R.id.recycler_view);

        mPresenter = new PresenterImpl(this, this);
        mAdapter = new ImageAdapter(this);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void showImages(List<String> images) {
        mAdapter.setImages(images);
    }
}
