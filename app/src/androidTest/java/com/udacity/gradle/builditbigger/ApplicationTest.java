package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.content.Context;
import android.support.v4.util.Pair;
import android.test.ApplicationTestCase;

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
            EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask();
            endpointsAsyncTask.execute(new Pair<Context, String>(getContext(), "0"));
            returnedAnswer = endpointsAsyncTask.get(30, TimeUnit.SECONDS);
        } catch (Exception e) {
            fail("Timed Out");
        }

        // Make sure the joke and answer that are returned equal the provided joke and answer strings
        assertTrue(correctAnswer[0].equals(returnedAnswer[0]));
        assertTrue(correctAnswer[1].equals(returnedAnswer[1]));
    }


}