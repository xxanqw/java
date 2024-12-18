package com.education.ztu;

import java.util.*;

public class Task6Collections {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>(Arrays.asList(
                new Product("Phone", 300, 5),
                new Product("Tablet", 200, 3),
                new Product("Monitor", 150, 2)
        ));

        // Сортування
        Collections.sort(products);
        System.out.println("Sorted: " + products);

        // Binary Search
        int index = Collections.binarySearch(products, new Product("Tablet", 200, 3));
        System.out.println("Index of Tablet: " + index);

        // Reverse
        Collections.reverse(products);
        System.out.println("Reversed: " + products);

        // Shuffle
        Collections.shuffle(products);
        System.out.println("Shuffled: " + products);

        // Fill
        Collections.fill(products, new Product("Default", 0, 0));
        System.out.println("Filled: " + products);

        // Max and Min
        System.out.println("Max: " + Collections.max(products));
        System.out.println("Min: " + Collections.min(products));

        // Rotate
        Collections.rotate(products, 1);
        System.out.println("Rotated: " + products);

        // Frequency
        System.out.println("Frequency of Default: " + Collections.frequency(products, new Product("Default", 0, 0)));
    }
}