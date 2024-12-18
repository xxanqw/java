package com.education.ztu;

public class ArithmeticRunnableWithBlock implements Runnable {
    private static int result = 1;

    @Override
    public void run() {
        synchronized (ArithmeticRunnableWithBlock.class) {
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
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new ArithmeticRunnableWithBlock());
        Thread thread2 = new Thread(new ArithmeticRunnableWithBlock());
        Thread thread3 = new Thread(new ArithmeticRunnableWithBlock());

        thread1.start();
        thread2.start();
        thread3.start();
    }
}