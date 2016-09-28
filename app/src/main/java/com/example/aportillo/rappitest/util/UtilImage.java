package com.example.aportillo.rappitest.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.util.Log;

import com.example.aportillo.rappitest.util.constans.MobileConstant;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by aportillo on 28/09/2016.
 */
public class UtilImage {

    public static Bitmap getBitmapFromURL(String src) {
        try {
            URL url = new URL(src);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            return myBitmap;
        } catch (IOException e) {
            Log.e(MobileConstant.exception, e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public static Drawable loadImageFromURL(String url, String name) {
        try {
            InputStream is = (InputStream) new URL(url).getContent();
            Drawable d = (BitmapDrawable) Drawable.createFromStream(is, name);
            return d;
        } catch (Exception e) {
            return null;
        }
    }

    public static Bitmap image(final String iconImg) {
        try {
            class CargaImagenes extends AsyncTask<String, Void, Bitmap> {
                private URL imageUrl = null;
                private HttpURLConnection conn = null;
                private Bitmap imagen = null;

                public CargaImagenes() {
                }
                @Override
                protected Bitmap doInBackground(String... params) {
                    try {
                        imageUrl = new URL(iconImg);
                        conn = (HttpURLConnection) imageUrl.openConnection();
                        conn.connect();
                        imagen = BitmapFactory.decodeStream(conn.getInputStream());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return imagen;
                }

            }
            return new CargaImagenes().execute().get();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}
