package com.example.csiemessagingappv1;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class fetchJsonData extends AsyncTask<Void, Void, Void> {

    String jsonData="";
    String jsonParsedData="";
    String singleParsed="";

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL jsonFileURL = new URL("https://pdm.ase.ro/examen/jucatori.json.txt");

            HttpURLConnection httpURLConnection = (HttpURLConnection) jsonFileURL.openConnection();

            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while(line !=null)
            {
                line = bufferedReader.readLine();
                jsonData = jsonData + line;
            }

            JSONArray jsonArray = new JSONArray(jsonData);
            for ( int i=0; i<jsonArray.length(); i++)
            {
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                singleParsed = "Country: " + jsonObject.get("Country") + "\n" +
                        "Town: " + jsonObject.get("Town") + "\n" +
                        "Schedule: " + jsonObject.get("Schedule") + "\n" +
                        "Address: " + jsonObject.get("Address") + "\n";

                jsonParsedData = jsonParsedData + singleParsed + "\n";
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {

        HelpActivity.data.setText(this.jsonParsedData);
        super.onPostExecute(aVoid);
    }
}
