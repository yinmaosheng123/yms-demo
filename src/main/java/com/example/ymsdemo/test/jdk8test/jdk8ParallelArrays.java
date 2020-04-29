package com.example.ymsdemo.test.jdk8test;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * java8 加入了用于支持并行数组处理
 * parallelSort() 该方法可以显著加快多核机器上的数组排序
 */
public class jdk8ParallelArrays {
    public static void main(String[] args) {
        long[] arrayOfLong = new long[20000];
        Arrays.parallelSetAll(arrayOfLong,
                index -> ThreadLocalRandom.current().nextInt(1000000));
        Arrays.stream( arrayOfLong ).limit(10).forEach(
                i -> System.out.println(i + " ")
        );
        System.out.println();
        Arrays.parallelSort(arrayOfLong);
        Arrays.stream(arrayOfLong).limit(10).forEach(
                i -> System.out.println(i+" ")
        );
        System.out.println();
    }

}
