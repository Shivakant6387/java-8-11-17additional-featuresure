package org.example.multithread;

public class ThreadDemo {
    public static void main(String[] args) {
//        Thread thread = new Thread(new Runnables());
//        thread.start();
//        Thread thread2 = new Thread(new Runnables());
//        thread2.start();
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Hello" + i);
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                        e.getLocalizedMessage();
                    }
                }
            }
        });
        thread1.start();
    }
}
