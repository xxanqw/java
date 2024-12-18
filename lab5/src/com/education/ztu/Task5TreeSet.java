package com.education.ztu;

import java.util.NavigableSet;
import java.util.TreeSet;

public class Task5TreeSet {
    public static void main(String[] args) {
        TreeSet<Product> products = new TreeSet<>();
        products.add(new Product("Laptop", 500, 1));
        products.add(new Product("Mouse", 20, 10));
        products.add(new Product("Keyboard", 30, 7));

        // Основні методи
        System.out.println("First: " + products.first());
        System.out.println("Last: " + products.last());
        System.out.println("HeadSet: " + products.headSet(new Product("Keyboard", 30, 7)));
        System.out.println("Higher than Mouse: " + products.higher(new Product("Mouse", 20, 10)));

        // Десцендинг
        NavigableSet<Product> descendingSet = products.descendingSet();
        System.out.println("Descending Set: " + descendingSet);

        products.pollFirst();
        products.pollLast();
        System.out.println("After polling: " + products);
    }
}