package com.education.ztu;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first positive integer: ");
        int a = scanner.nextInt();
        System.out.println("Enter second positive integer: ");
        int b = scanner.nextInt();
        System.out.println("The GCD is: " + gcd(a, b));
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
