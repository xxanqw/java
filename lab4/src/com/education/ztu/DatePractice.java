package com.education.ztu;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class DatePractice {

    public static void main(String[] args) {
        LocalDateTime labStart = LocalDateTime.of(2023, Month.OCTOBER, 30, 10, 0);

        System.out.println("День тижня: " + labStart.getDayOfWeek());
        System.out.println("День у році: " + labStart.getDayOfYear());
        System.out.println("Місяць: " + labStart.getMonth());
        System.out.println("Рік: " + labStart.getYear());
        System.out.println("Години: " + labStart.getHour());
        System.out.println("Хвилини: " + labStart.getMinute());

        System.out.println("Чи рік високосний: " + labStart.toLocalDate().isLeapYear());

        LocalDateTime currentDate = LocalDateTime.now();
        System.out.println("Поточна дата: " + currentDate);

        System.out.println("Чи після початку: " + currentDate.isAfter(labStart));
        System.out.println("Чи перед початком: " + currentDate.isBefore(labStart));

        LocalDateTime modifiedDate = labStart.plusDays(5).minusHours(3);
        System.out.println("Змінена дата: " + modifiedDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")));
    }
}