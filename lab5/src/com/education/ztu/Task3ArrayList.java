package com.education.ztu;

import java.util.*;

public class Task3ArrayList {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();

        // Додавання продуктів
        products.add(new Product("Apple", 1.5, 10));
        products.add(new Product("Banana", 0.8, 20));
        products.add(new Product("Orange", 1.2, 15));

        // Метод addAll
        List<Product> moreProducts = List.of(
                new Product("Grapes", 2.0, 5),
                new Product("Pineapple", 3.0, 2)
        );
        products.addAll(moreProducts);

        // Отримання продукту за індексом
        System.out.println("Product at index 1: " + products.get(1));

        // Індексація
        System.out.println("Index of Banana: " + products.indexOf(new Product("Banana", 0.8, 20)));
        System.out.println("Last index of Orange: " + products.lastIndexOf(new Product("Orange", 1.2, 15)));

        // Ітерація
        Iterator<Product> iterator = products.iterator();
        System.out.println("Products using iterator:");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // Оновлення елемента
        products.set(0, new Product("Avocado", 1.7, 8));

        // Сортування
        products.sort(Comparator.naturalOrder());
        System.out.println("Sorted products: " + products);

        // Отримання підсписку
        List<Product> sublist = products.subList(1, 3);
        System.out.println("SubList: " + sublist);

        // Інші методи
        products.remove(0);
        System.out.println("After remove: " + products);

        System.out.println("Contains Grapes: " + products.contains(new Product("Grapes", 2.0, 5)));
        System.out.println("Is empty: " + products.isEmpty());

        products.clear();
        System.out.println("After clear: " + products);
    }
}