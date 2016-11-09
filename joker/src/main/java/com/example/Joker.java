package com.example;

public class Joker {

    //    Corny jokes from http://reallycorny.com/big-list
    private String[] jokes = {
            "What did the mathematical pirate say when his favorite bird flew away?",
            "What do you call a pig that knows karate?",
            "Have you heard the Cookie Joke?",
            "Why were you fined for reading Lord of the rings?",
            "Why is the sky so unhappy?",
            "What do you call it when a shoemaker drops his vegetables?",
            "What is the difference between a Hippo and a Zippo?",
            "What did one eye say to the other eye?"};
    private String[] answers = {
            "Polygon!",
            "A pork chop!",
            "You wouldn't like it. It is pretty crumby!",
            "It was written by J.R.R Toll-kien.",
            "It has the blues.",
            "Corn on the cobbler!",
            "A Hippo is really heavy, but a Zippo is a little lighter!",
            "Something smells between us!"};

    private int counter;
    private String answer = "Ask me a joke first!";

    public Joker() {
        counter = 0;
    }

    /**
     * Provides a joke
     *
     * @return a joke
     */
    public String getJoke() {
        String joke = jokes[counter];
        answer = answers[counter];

        // Increment the joke counter or reset back to beginning
        if (counter >= (jokes.length - 1)) {
            counter = 0;
        } else {
            counter++;
        }

        return joke;
    }

    /**
     * Provides an answer to the current joke
     *
     * @return the ansewr to the previously asked joke
     */
    public String getAnswer() {
        return answer;
    }
}
