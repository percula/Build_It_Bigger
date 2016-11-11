package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.content.Context;
import android.support.v4.util.Pair;
import android.test.ApplicationTestCase;
import android.util.Log;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

    @Test
    public void testJokeRetrieved() {
        String[] correctAnswer = new String[]{"What did the mathematical pirate say when his favorite bird flew away?",
                "Polygon!"};
        String[] returnedAnswer = new String[2];
        try {
            // Note that the test fails because of the context that was added to add the progress
            // dialog. Removing the context makes the test succeed again. The progress dialog requires
            // an activity context which the application test cannot provide...
            returnedAnswer = new EndpointsAsyncTask(getContext()).execute(new Pair<Context, String>(getContext(), "0")).get(15, TimeUnit.SECONDS);
        } catch (Exception e) {
            Log.e("ApplicationTest", e.toString());
        }

        // Make sure the joke and answer that are returned equal the provided joke and answer strings
        assertTrue(correctAnswer[0].equals(returnedAnswer[0]));
        assertTrue(correctAnswer[1].equals(returnedAnswer[1]));
    }


}