package com.example.ymsdemo.test.runtest;


import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
public class ThirdBenchmark {
    @State(Scope.Group)
    public static class BenchmarkState{
        volatile double x = Math.PI;
    }

    @Benchmark
    @Group("custom")
    @GroupThreads(10)
    public void read(BenchmarkState state){
        state.x++;
        try {
            Thread.sleep(5);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("ThirdBenchamrk.read:"+ state.x);
    }

    @Benchmark
    @Group("custom")
    public void book(BenchmarkState state){
        state.x++;
        try {
            Thread.sleep(5);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("ThirdBenchmark.book:" + state.x);

    }

    public static void main(String[] args) throws Exception {
        Options opt = new OptionsBuilder()
                .include(ThirdBenchmark.class.getSimpleName())
                .forks(0)
                .warmupBatchSize(0)
                .measurementIterations(2).measurementTime(TimeValue.valueOf("10ms")).threads(5)
                .build();

        new Runner(opt).run();
    }




}
