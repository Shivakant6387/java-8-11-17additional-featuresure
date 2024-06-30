package org.example.java8;

import java.util.stream.IntStream;

public class ImperativeVsDeclarativeExample {
    public static void main(String[] args) {
        //imperative - how style of programming

        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            sum += i;
        }
        System.out.println("Sum using Imperative approach : " + sum);
        //declarative style of programming - what style of programming
        int sum2 = IntStream.rangeClosed(0, 100).parallel().sum();

        System.out.println("Sum using Declarative approach : " + sum2);
    }
}
