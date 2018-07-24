package com.quangnv.contentproviderdemo.model;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

import java.util.ArrayList;
import java.util.List;

public class ImageUtil {

    private Context mContext;
    private final Uri URI = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
    private final String [] mProjection = {MediaStore.Images.Media.DATA};

    public ImageUtil(Context context) {
        mContext = context;
    }

    public List<String> loadImages() {
        List<String> imagesPath = new ArrayList<>();

        Cursor cursor = mContext.getContentResolver().query(URI, mProjection, null, null, null, null);

        while (cursor.moveToNext()) {
            int columnIndex = cursor.getColumnIndex(mProjection[0]);
            String path = cursor.getString(columnIndex);
            imagesPath.add(path);
        }
        cursor.close();

        return imagesPath;
    }

}
