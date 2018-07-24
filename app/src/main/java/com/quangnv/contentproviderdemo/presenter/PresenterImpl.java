package com.quangnv.contentproviderdemo.presenter;

import android.content.Context;

import com.quangnv.contentproviderdemo.model.ImageUtil;
import com.quangnv.contentproviderdemo.view.MainView;

import java.util.List;

public class PresenterImpl implements Presenter {

    private MainView mMainView;
    private Context mContext;

    public PresenterImpl(Context context, MainView mainView) {
        mContext = context;
        mMainView = mainView;
    }

    @Override
    public void loadImages() {
        List<String> images = new ImageUtil(mContext).loadImages();
        mMainView.showImages(images);
    }
}
