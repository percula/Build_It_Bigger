package com.perculacreative.peter.builditbigger.backend;

import com.example.Joker;

/** The object model for the data we are sending through endpoints */
public class MyJokeData {

    private Integer count;
    private String mJoke;
    private String mAnswer;

    public String getJoke() {
        return mJoke;
    }

    public String getAnswer() {
        return mAnswer;
    }

    public void setData(String data) {
        count = Integer.parseInt(data);
        Joker joker = new Joker();
        mJoke = joker.getJoke(count);
        mAnswer = joker.getAnswer();

    }
}