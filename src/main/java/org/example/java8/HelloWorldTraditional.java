package org.example.java8;

public class HelloWorldTraditional implements HelloWorldInterface{
    public static void main(String[] args) {
        HelloWorldTraditional helloWorldTraditional=new HelloWorldTraditional();
        System.out.println(helloWorldTraditional.sayHelloWorld());
    }

    @Override
    public String sayHelloWorld() {
        return "Hello World";
    }
}
