package com.education.ztu;

public class Task3 {
    public static void main(String[] args) {
        test();
    }

    public static void combineArgs(String[] args) {
        String result = String.join(" ", args);
        System.out.println(result);
    }

    public static void test() {
        Task3.combineArgs(new String[]{"1", "3", "3", "7"});
    }
}
