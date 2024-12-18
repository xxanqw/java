package com.education.ztu;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        try {
            for (int i = 0; i <= 10000; i++) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("Розрахунок завершено!!!");
                    return;
                }
                if (i % 10 == 0) {
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                }
            }
        } catch (Exception e) {
            System.out.println("Перервано: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyRunnable(), "Thread-1");
        Thread thread2 = new Thread(new MyRunnable(), "Thread-2");
        Thread thread3 = new Thread(new MyRunnable(), "Thread-3");

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            Thread.sleep(2000); // Пауза для головного потоку
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread1.interrupt();
        thread2.interrupt();
        thread3.interrupt();
    }
}
