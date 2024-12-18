package com.education.ztu;

import java.util.ArrayDeque;
import java.util.Deque;

public class Task4ArrayDeque {
    public static void main(String[] args) {
        Deque<Product> queue = new ArrayDeque<>();

        // Додавання елементів
        queue.push(new Product("Milk", 1.0, 10));
        queue.offerLast(new Product("Cheese", 3.0, 5));
        queue.offerLast(new Product("Bread", 0.8, 20));

        // Отримання елементів
        System.out.println("First: " + queue.getFirst());
        System.out.println("Last: " + queue.peekLast());

        // Видалення елементів
        System.out.println("Popped: " + queue.pop());
        System.out.println("Removed last: " + queue.removeLast());

        // Розмір
        System.out.println("Size: " + queue.size());
    }
}