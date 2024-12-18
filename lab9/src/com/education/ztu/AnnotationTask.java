package com.education.ztu;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Method;

// Створення анотації
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@interface CustomAnnotation {
    String value() default "За замовчуванням";
    int priority() default 1;
}

// Використання анотації
@CustomAnnotation(value = "Клас з анотацією", priority = 10)
class AnnotatedClass {
    @CustomAnnotation(value = "Метод з анотацією", priority = 5)
    public void annotatedMethod() {
        System.out.println("Метод з анотацією викликано.");
    }
}

// Виведення даних анотації
public class AnnotationTask {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = AnnotatedClass.class;

        // Отримання анотації на класі
        CustomAnnotation classAnnotation = clazz.getAnnotation(CustomAnnotation.class);
        System.out.println("Анотація на класі:");
        System.out.println("Значення: " + classAnnotation.value() + ", Пріоритет: " + classAnnotation.priority());

        // Отримання анотації на методі
        Method method = clazz.getMethod("annotatedMethod");
        CustomAnnotation methodAnnotation = method.getAnnotation(CustomAnnotation.class);
        System.out.println("\nАнотація на методі:");
        System.out.println("Значення: " + methodAnnotation.value() + ", Пріоритет: " + methodAnnotation.priority());
    }
}