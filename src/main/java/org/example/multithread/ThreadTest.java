package org.example.multithread;

public class ThreadTest {
    public static void main(String[] args) {
        Runner runner=new Runner();
        runner.start();

        Runner runner2=new Runner();
        runner2.start();
    }
}
