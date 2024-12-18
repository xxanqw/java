package com.education.ztu;

import java.util.Scanner;

public class Task6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of Fibonacci elements (n): ");
        int n = scanner.nextInt();

        int[] fibonacciArray = generateFibonacci(n);
        int[] reversedFibonacciArray = reverseArray(fibonacciArray);

        System.out.println("Fibonacci array:");
        for (int num : fibonacciArray) {
            System.out.print(num + " ");
        }

        System.out.println("\nReversed Fibonacci array:");
        for (int num : reversedFibonacciArray) {
            System.out.print(num + " ");
        }
    }

    private static int[] generateFibonacci(int n) {
        int[] fibonacci = new int[n];
        if (n > 0) fibonacci[0] = 1;
        if (n > 1) fibonacci[1] = 1;

        for (int i = 2; i < n; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }
        return fibonacci;
    }

    private static int[] reverseArray(int[] array) {
        int[] reversed = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            reversed[i] = array[array.length - 1 - i];
        }
        return reversed;
    }
}
