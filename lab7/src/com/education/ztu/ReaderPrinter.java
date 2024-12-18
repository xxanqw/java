package com.education.ztu;

import java.util.Scanner;

public class ReaderPrinter {
    private static String message;
    private static final Object lock = new Object();

    static class Reader implements Runnable {
        @Override
        public void run() {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                synchronized (lock) {
                    System.out.print("Введіть рядок: ");
                    message = scanner.nextLine();
                    lock.notify(); // Повідомити Printer
                    try {
                        lock.wait(); // Засинаємо
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    static class Printer implements Runnable {
        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    try {
                        lock.wait(); // Очікуємо повідомлення від Reader
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Прочитано: " + message);
                    lock.notify(); // Повідомити Reader
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread readerThread = new Thread(new Reader());
        Thread printerThread = new Thread(new Printer());

        readerThread.start();
        printerThread.start();
    }
}