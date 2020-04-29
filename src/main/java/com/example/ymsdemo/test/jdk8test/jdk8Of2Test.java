package com.example.ymsdemo.test.jdk8test;

import java.time.Duration;
import java.time.Instant;

public class jdk8Of2Test {
    public static void main(String[] args) {
        Instant start = Instant.now();

        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start,end);
        long millis = timeElapsed.toNanos();
        System.out.println(millis);



    }
}
