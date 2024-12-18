package com.education.ztu;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Constructor;

public class ReflectionTask {
    public static void main(String[] args) throws Exception {
        // Отримання об'єкта Class трьома способами
        CustomClass obj1 = new CustomClass();
        Class<?> clazz1 = obj1.getClass(); // Спосіб 1
        Class<?> clazz2 = CustomClass.class; // Спосіб 2
        Class<?> clazz3 = Class.forName("com.education.ztu.CustomClass"); // Спосіб 3

        // Отримання полів
        System.out.println("Поля класу:");
        Field[] fields = clazz1.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName() + " (" + field.getType() + ")");
        }

        // Отримання методів
        System.out.println("\nМетоди класу:");
        Method[] methods = clazz1.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName() + " (Повертає: " + method.getReturnType() + ")");
        }

        // Отримання конструкторів
        System.out.println("\nКонструктори класу:");
        Constructor<?>[] constructors = clazz1.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor.getName());
        }

        // Створення об'єкта та виклик методу
        Object objInstance = clazz1.getConstructor(String.class).newInstance("Це поле");
        System.out.println("\nМетод результат:");
        Method publicMethod = clazz1.getMethod("publicMethod");
        publicMethod.invoke(objInstance);

        // Працюємо з приватним полем
        Field privateField = clazz1.getDeclaredField("privateField");
        privateField.setAccessible(true);
        privateField.set(objInstance, "Змінене значення");
        System.out.println("\nПриватне поле:");
        System.out.println(privateField.get(objInstance));
    }
}

class CustomClass {
    public String publicField;
    private String privateField;

    public CustomClass() {
        this.publicField = "Публічне поле";
        this.privateField = "Приватне поле";
    }

    public CustomClass(String value) {
        this.privateField = value;
    }

    public void publicMethod() {
        System.out.println("Це публічний метод.");
    }

    private void privateMethod() {
        System.out.println("Це приватний метод.");
    }
}