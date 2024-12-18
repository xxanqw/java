package com.education.ztu;

public class ArithmeticRunnable implements Runnable {
    private static int result = 1;

    @Override
    public synchronized void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.print(result + " ");
            result++;
            try {
                Thread.sleep(200); // Затримка 0.2 секунди
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new ArithmeticRunnable());
        Thread thread2 = new Thread(new ArithmeticRunnable());
        Thread thread3 = new Thread(new ArithmeticRunnable());

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
