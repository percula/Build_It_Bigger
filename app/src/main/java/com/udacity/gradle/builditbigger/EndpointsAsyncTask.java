package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.util.Pair;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.perculacreative.peter.builditbigger.backend.myApi.MyApi;
import com.perculacreative.peter.jokedisplay.JokeActivity;

import java.io.IOException;

/**
 * Created by peter on 11/9/16.
 */

class EndpointsAsyncTask extends AsyncTask<Pair<Context, String>, Void, String[]>{
    private static MyApi myApiService = null;
    private Context context;

    public static final String JOKE_KEY = "joke_intent_key";
    public static final String ANSWER_KEY = "answer_intent_key";

    @Override
    protected String[] doInBackground(Pair<Context, String>... params) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();
        }

        context = params[0].first;
        String countStr = params[0].second;
        String[] result = new String[2];

        try {
            result[0] = myApiService.setJokeCount(countStr).execute().getJoke();
            result[1] = myApiService.setJokeCount(countStr).execute().getAnswer();
            return result;
        } catch (IOException e) {
            result[0] = e.getMessage();
            return result;
        }
    }

    @Override
    protected void onPostExecute(String[] result) {



        Intent intent = new Intent(context, JokeActivity.class);
        intent.putExtra(JOKE_KEY, result[0]);
        intent.putExtra(ANSWER_KEY, result[1]);
        context.startActivity(intent);
    }
}
