package com.example.csiemessagingappv1;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class LoadInternetImage extends AsyncTask<String, Integer, String> {

    private Bitmap bitmap;


    @Override
    protected String doInBackground(String... strings) {
        try {
            URL imageURL = new URL(strings[0]);
            bitmap = BitmapFactory.decodeStream(imageURL.openConnection().getInputStream());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        StartActivity.mainLogo.setImageBitmap(bitmap);
        StartActivity.mainLogo.setImageBitmap(bitmap);
    }
}
