package com.education.ztu;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

@FunctionalInterface
interface Printable {
    void print();
}

class Product {
    String name;
    String brand;
    double price;
    int count;

    public Product(String name, String brand, double price, int count) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }


    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                ", count=" + count +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
        // Завдання 2
        Printable printable = () -> System.out.println("Printing using custom functional interface.");
        printable.print();

        // Завдання 3a
        Predicate<String> isNumeric = str -> {
            try {
                Double.parseDouble(str);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        };

        Predicate<String> isNotEmpty = str -> !str.isEmpty();

        String numStr = "123";
        String nonNumStr = "abc";

        System.out.println(numStr + " is numeric and not empty: " + isNumeric.and(isNotEmpty).test(numStr));
        System.out.println(nonNumStr + " is numeric and not empty: " + isNumeric.and(isNotEmpty).test(nonNumStr));


        // Завдання 3b
        Consumer<String> startLesson = str -> System.out.println("Пара почалася о 8:30");
        Consumer<String> endLesson = str -> System.out.println("Пара закінчилася о 9:50");

        Consumer<String> lesson = startLesson.andThen(endLesson);
        lesson.accept("Java");

        // Завдання 3c
        Supplier<String> upperCaseSentence = () -> "hello world".toUpperCase();
        System.out.println(upperCaseSentence.get());

        // Завдання 3d
        Function<String, Integer> productOfNumbers = str -> {
            try {
                return Arrays.stream(str.split(" "))
                        .mapToInt(Integer::parseInt)
                        .reduce(1, (a, b) -> a * b);
            } catch (NumberFormatException e) {
                System.err.println("Invalid input string: " + str);
                return 0; // Or throw an exception
            }

        };


        System.out.println("Product: " + productOfNumbers.apply("1 2 3 4 5"));




        // Завдання 4
        Product[] products = {
                new Product("Laptop", "Apple", 1200, 10),
                new Product("Phone", "Samsung", 800, 20),
                new Product("Tablet", "Apple", 500, 15),
                new Product("Monitor", "Dell", 300, 5),
                new Product("Keyboard", "Logitech", 75, 30)

        };



        // Get all brands
        Arrays.stream(products)
                .map(Product::getBrand)
                .distinct()
                .forEach(System.out::println);


        // Get 2 products with price < 1000
        Arrays.stream(products)
                .filter(p -> p.getPrice() < 1000)
                .limit(2)
                .forEach(System.out::println);

        //Get total count of all products

        int totalCount = Arrays.stream(products)
                .mapToInt(Product::getCount)
                .sum();
        System.out.println("Total count: " + totalCount);


        // Group products by brand
        Map<String, List<Product>> productsByBrand = Arrays.stream(products)
                .collect(Collectors.groupingBy(Product::getBrand));

        System.out.println(productsByBrand);

        // Sort products by price and return an array
        Product[] sortedProducts = Arrays.stream(products)
                .sorted(Comparator.comparingDouble(Product::getPrice))
                .toArray(Product[]::new);

        System.out.println(Arrays.toString(sortedProducts));


        // Завдання 6
        Integer[] numbers = {1, 5, 2, 8, 3, 9, 4, 7, 6};
        Optional<Integer> max = Arrays.stream(numbers).max(Integer::compare);

        System.out.println(max.orElseGet(() -> {
            System.out.println("Числа відсутні");
            return null;
        }));


        Integer[] emptyNumbers = {};
        max = Arrays.stream(emptyNumbers).max(Integer::compare);

        System.out.println(max.orElseGet(() -> {
            System.out.println("Числа відсутні");
            return null;
        }));




    }
}