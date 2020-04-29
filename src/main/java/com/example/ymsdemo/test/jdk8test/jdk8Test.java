package com.example.ymsdemo.test.jdk8test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class jdk8Test {
    public static void main(String[] args) {
        String a = "abc";
        String b = "11";
        System.out.println(Integer.compare(b.length(), a.length()));
        ConcurrentGreeter concurrentGreeter = new ConcurrentGreeter();
        concurrentGreeter.greet();
        repeatMessage("12123",3);

        Stream<String> song = Stream.of("gently","down","the","stream");

        System.out.println(song.collect(Collectors.toList()));

        Stream<String> yin = Stream.of("gently","down","the","stream");
        System.out.println(yin.map(String::toUpperCase).collect(Collectors.toList()));

        List list = Stream.of("one","two","three","four").filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value:" + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value:" + e))
                .collect(Collectors.toList());
        System.out.println(list.toString());

        String concat = Stream.of("A","B","C","D").reduce("",String::concat);
        System.out.println(concat);

        Stream.iterate(0, n -> n+3).limit(5).forEach(x -> System.out.print(x + "_"));

        inverse(new Double(0));



    }

    static class Greeter {
        public void greet() {
            System.out.println("111111");
        }
    }

    static class ConcurrentGreeter extends Greeter {

        @Override
        public void greet() {
            Thread t = new Thread(super::greet);
            t.start();
        }
    }

    public static void repeatMessage(String text, int count) {
        Runnable r = () -> {
            for (int i = 0; i < count; i++) {
                System.out.println(text);
                Thread.yield();
            }
        };
        new Thread(r).start();

    }

    public static Optional<Double> inverse(Double x){
        return x == 0 ? Optional.empty() : Optional.of(1/x);
    }

    private class Person{
        public int no;
        private String name;

        public Person(int no, String name) {
            this.no = no;
            this.name = name;
        }
        public String getName(){
            System.out.println(name);
            return name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    '}';
        }
    }


    public void testLimitAndSkip(){
        List<Person> persons = new ArrayList();
        for(int i = 1;i<=10000;i++){
            Person person = new Person(i,"name"+i);
            persons.add(person);
        }
        List<String> personList2 = persons.stream().map(Person::getName).limit(10).skip(3)
                .collect(Collectors.toList());
        System.out.println(personList2);
    }




}
