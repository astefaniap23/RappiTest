package com.example.aportillo.rappitest.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by aportillo on 28/09/2016.
 */
public class UtilImage {


    public static Drawable loadImageFromURL(String url) {
        try {
            Bitmap bitmap = getImageFromUrl(url);
            Drawable drawable = new BitmapDrawable(bitmap);
            return drawable;
        } catch (Exception e) {
            return null;
        }
    }

    public static Bitmap getImageFromUrl(final String iconImg) {
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
