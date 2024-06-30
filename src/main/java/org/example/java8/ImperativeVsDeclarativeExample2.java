package org.example.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ImperativeVsDeclarativeExample2 {
    public static void main(String[] args) {
        List<Integer> integerList= Arrays.asList(1,2,3,3,3,4,4,4,5,5,5,6,7,8,9,9,9,10);
        //Imperative
        List<Integer> list=new ArrayList<>();
        for (Integer integer:integerList){
            if (!list.contains(integer)){
                list.add(integer);
            }
        }
        System.out.println("uniqueList :"+list);

        //declarative

        List<Integer>integerList1=integerList.stream().distinct().collect(Collectors.toList());
        System.out.println("uniqueList :"+integerList1);
    }
}
