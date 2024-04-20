package org.example.java11;


import java.util.Arrays;
import java.util.List;

public class VarLambdaExample {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        // Using traditional approach without var
        System.out.println("Using traditional approach:");
        numbers.forEach(System.out::println);
        // Using var with lambda expression
        System.out.println("\nUsing var with lambda expression:");
        numbers.forEach(System.out::println);
    }

}
