package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.content.Context;
import android.support.v4.util.Pair;
import android.test.ApplicationTestCase;
import android.util.Log;

import java.util.concurrent.TimeUnit;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

    @org.junit.Test
    public void testJokeRetrieved() {
        Log.v("testJokeRetrieved", "Start");
        String[] correctAnswer = new String[]{"What did the mathematical pirate say when his favorite bird flew away?",
                "Polygon!"};
        String[] returnedAnswer = new String[2];
        try {
            returnedAnswer = new EndpointsAsyncTask().execute(new Pair<Context, String>(getContext(), "0")).get(15, TimeUnit.SECONDS);
        } catch (Exception e) {
            Log.e("ApplicationTest", e.toString());
        }

        assertEquals(correctAnswer,returnedAnswer);
        Log.v("testJokeRetrieved", "Finish");
    }


}