package com.education.ztu;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTask {
    public static void main(String[] args) {
        // Дані співробітників
        String employeesData = """
                1. Іваненко Іван, 30 років, розробник, досвід: 5 років, Київ, email: ivan.ivanenko@gmail.com, телефон: +380987654321, дата народження: 20.05.1993
                2. Петренко Петро, 41 рік, менеджер, досвід: 15 років, Львів, email: petro_petrenko@yahoo.com, телефон: +380973213456, дата народження: 12.04.1982
                3. Сидоренко Сергій, 25 років, тестувальник, досвід: 1 рік, Одеса, email: sidorenko@test.com, телефон: +380671231234, дата народження: 05.09.1998
                4. Марченко Марина, 28 років, бухгалтер, досвід: 3 роки, Харків, email: marchenko@finance.ua, телефон: +380501234567, дата народження: 15.11.1995
                5. Дмитренко Оксана, 35 років, маркетолог, досвід: 10 років, Дніпро, email: oksana.dmitrenko@gmail.com, телефон: +380933456789, дата народження: 25.03.1988
                """;

        // Знайти всі номери телефонів
        System.out.println("Номери телефонів:");
        Pattern phonePattern = Pattern.compile("\\+380\\d{9}");
        Matcher phoneMatcher = phonePattern.matcher(employeesData);
        while (phoneMatcher.find()) {
            System.out.println(phoneMatcher.group());
        }

        // Знайти всі email
        System.out.println("\nЕлектронні адреси:");
        Pattern emailPattern = Pattern.compile("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
        Matcher emailMatcher = emailPattern.matcher(employeesData);
        while (emailMatcher.find()) {
            System.out.println(emailMatcher.group());
        }

        // Змінити дати народження (формат: dd.MM.yyyy на yyyy-MM-dd)
        System.out.println("\nЗмінені дати народження:");
        String updatedData = employeesData.replaceAll("(\\d{2})\\.(\\d{2})\\.(\\d{4})", "$3-$2-$1");
        System.out.println(updatedData);

        // Змінити посади
        System.out.println("\nОновлені посади:");
        String updatedPositions = updatedData.replaceAll("розробник", "старший розробник")
                .replaceAll("менеджер", "директор");
        System.out.println(updatedPositions);
    }
}