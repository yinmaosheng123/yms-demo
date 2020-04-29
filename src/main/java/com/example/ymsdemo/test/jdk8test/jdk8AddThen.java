package com.example.ymsdemo.test.jdk8test;


import java.util.Arrays;
import java.util.function.IntConsumer;

public class jdk8AddThen {
    static int[] arr = {1,3,4,5,6,7,8,9};

    public static void main(String[] args) {
        IntConsumer outprintln = System.out::println;
        IntConsumer errprintln = System.out::println;
        Arrays.stream(arr).forEach(outprintln.andThen(errprintln));
    }

}
