package org.example.java8.functionalInterfaces;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {
    static Consumer<Student>studentConsumer=(student)-> System.out.print(student.getName());
    static Consumer<Student>studentConsumer2=(student)-> System.out.println(student.getActivities());
    static Consumer<Student>studentConsumer3=(student)-> System.out.println(student);
    static void printName(){

        List<Student>studentList=StudentDataBase.getAllStudents();
        studentList.forEach(studentConsumer);
    }
    public static void printNameAndActivities(){

        List<Student>studentList=StudentDataBase.getAllStudents();
        studentList.forEach(studentConsumer.andThen(studentConsumer2));//consumer chaining
    }
    public static void printNameAndActivitiesUsingCondition(){
        Consumer<Student>studentConsumer=(student)-> System.out.print(student.getName());
        Consumer<Student>studentConsumer2=(student)-> System.out.println(student.getActivities());
        List<Student>studentList=StudentDataBase.getAllStudents();
        studentList.forEach(studentConsumer.andThen(studentConsumer2));//consumer chaining
    }
    public static void main(String[] args) {
        Consumer<String>consumer=(s)-> System.out.println(s.toUpperCase());
        consumer.accept("java8");
        printName();
        printNameAndActivities();
    }
}
