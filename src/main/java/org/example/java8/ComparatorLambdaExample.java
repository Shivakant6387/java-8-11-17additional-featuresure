package org.example.java8;

import java.util.Comparator;

public class ComparatorLambdaExample {
    public static void main(String[] args) {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
        System.out.println("Result of the comparator is :" + comparator.compare(3, 2));
        Comparator<Integer> comparatorLambda = (Integer a, Integer b) -> a.compareTo(b);
        System.out.println("Result of the comparator using lambda is :" + comparatorLambda.compare(3, 2));

        Comparator<Integer> comparatorLambdas = ( a,  b) -> a.compareTo(b);
        System.out.println("Result of the comparator using lambda is :" + comparatorLambdas.compare(3, 2));
    }
}
