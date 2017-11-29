package com.playground.academy.britt.networkingdemo.network.utils;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by britt on 11/25/17.
 */

public class ImageDownloader {

    public static void download(Context context, String url, ImageView view){
        Picasso.with(context).load(url).into(view);

    }
}
