package com.education.ztu;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class LocalizationPractice {

    public static void main(String[] args) {
        printCheck(new Locale("uk", "UA"));
        printCheck(Locale.UK);
        printCheck(Locale.FRANCE);
    }

    public static void printCheck(Locale locale) {
        ResourceBundle bundle = ResourceBundle.getBundle("data", locale);
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(locale);

        System.out.println(bundle.getString("receipt_date"));
        System.out.println("===========================================");
        System.out.println(bundle.getString("header"));
        System.out.format("%-3s %-10s %-13s %-10s\n", "1.", bundle.getString("jeans"), bundle.getString("category_female"), currencyFormat.format(1500.78));
        System.out.format("%-3s %-10s %-13s %-10s\n", "2.", bundle.getString("skirt"), bundle.getString("category_female"), currencyFormat.format(1000.56));
        System.out.format("%-3s %-10s %-13s %-10s\n", "3.", bundle.getString("tie"), bundle.getString("category_male"), currencyFormat.format(500.78));
        System.out.println("===========================================");
        System.out.println(bundle.getString("total") + ": " + currencyFormat.format(3002.34));
    }
}