package com.education.ztu;

public class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Я люблю програмувати!!!");
        }
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();

        // Виведення початкових атрибутів потоку
        System.out.println("Початкове ім’я потоку: " + myThread.getName());
        System.out.println("Початковий пріоритет: " + myThread.getPriority());
        System.out.println("Чи живий: " + myThread.isAlive());
        System.out.println("Чи демон: " + myThread.isDaemon());

        // Зміна параметрів потоку
        myThread.setName("CustomThreadName");
        myThread.setPriority(Thread.MAX_PRIORITY);
        System.out.println("Новий ім’я потоку: " + myThread.getName());
        System.out.println("Новий пріоритет: " + myThread.getPriority());

        // Запуск потоку
        myThread.start();

        try {
            myThread.join(); // Очікування завершення потоку
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Головний потік: " + Thread.currentThread().getName());
        System.out.println("Пріоритет головного потоку: " + Thread.currentThread().getPriority());
    }
}
