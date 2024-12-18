package com.education.ztu;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        addTwoNumbers();
    }

    private static void addTwoNumbers() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        int num1 = scanner.nextInt();
        System.out.print("Enter the second number: ");
        int num2 = scanner.nextInt();
        System.out.println("The sum is: " + (num1 + num2));
        scanner.close();
    }
}
