# Java Sentiment Analysis

This is a very basic library that allows you to perform sentiment analysis on strings using Java.

> Q: What's the best way you can do sentiment analysis in Java?

> A: You do it in Go, of course!

I wanted a library that does this for Java and I didn't find a good (and fast enough) one I can use.
I then came across [this](https://github.com/cdipaolo/sentiment) repo which does sentiment analysis in Go.
So I figured I can expose a function that uses that package and then build that file so a format which is compatible
with Java.

And that is exactly what I did! Go has a great building functionality so I built the file using the `c-shared` flag and that gave me a `.so` file which I was able to use with the [JNA](https://github.com/java-native-access/jna) library in Java to call the function.

The function takes a string and returns 0 if the sentiment is negative and 1 if positive.
This repo contains all the files I used in the above process, including the `.so` file which you can use on your own if you so desire.

#### Roadmap

I'm not sure how many people are going to use this so I'm not going to maintain it very much since I'm working on other things. Tests and a real configuration are definitely on the to-do though.