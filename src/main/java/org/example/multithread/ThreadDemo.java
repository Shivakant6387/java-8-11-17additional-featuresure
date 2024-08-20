package org.example.multithread;

public class ThreadDemo {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnables());
        thread.start();
        Thread thread2 = new Thread(new Runnables());
        thread2.start();
    }
}
