package com.education.ztu;

public class StringPractice {

    public static void main(String[] args) {
        String input = "I learn Java!!!";

        System.out.println("Останній символ: " + input.charAt(input.length() - 1));

        System.out.println("Чи закінчується на '!!!': " + input.endsWith("!!!"));

        System.out.println("Чи починається на 'I learn ': " + input.startsWith("I learn "));

        System.out.println("Чи містить 'Java': " + input.contains("Java"));

        System.out.println("Позиція 'Java': " + input.indexOf("Java"));

        System.out.println("Замінити 'а' на 'о': " + input.replace('a', 'o'));

        System.out.println("Верхній регістр: " + input.toUpperCase());

        System.out.println("Нижній регістр: " + input.toLowerCase());

        System.out.println("Вирізати 'Java': " + input.substring(8, 12));
    }
}
