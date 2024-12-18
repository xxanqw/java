package com.education.ztu;

public class StringBuilderPractice {

    public static void main(String[] args) {
        int a = 4;
        int b = 36;

        // 1. Скласти рядки операцій
        StringBuilder sb = new StringBuilder();
        sb.append(a).append(" + ").append(b).append(" = ").append(a + b).append("\n");
        sb.append(a).append(" - ").append(b).append(" = ").append(a - b).append("\n");
        sb.append(a).append(" * ").append(b).append(" = ").append(a * b).append("\n");

        System.out.println("Результати операцій:\n" + sb);

        StringBuilder operation = new StringBuilder("4 + 36 = 40");
        operation.deleteCharAt(8); // Видалити '='
        operation.insert(8, "рівно"); // Вставити "рівно"
        System.out.println(operation);

        operation = new StringBuilder("4 + 36 = 40");
        operation.replace(8, 9, "рівно");
        System.out.println(operation);

        System.out.println("Реверс: " + operation.reverse());

        System.out.println("Довжина: " + sb.length());
        System.out.println("Ємність: " + sb.capacity());
    }
}