package com.education.ztu;

import java.util.Formatter;

public class ReceiptFormatter {

    public static void main(String[] args) {
        Formatter formatter = new Formatter();
        formatter.format("Дата та час покупки: %-24s\n", "28.03.2019 13:25:12");
        formatter.format("===========================================\n");
        formatter.format("%-3s %-10s %-13s %-10s\n", "№", "Товар", "Категорія", "Ціна");
        formatter.format("===========================================\n");
        formatter.format("%-3d %-10s %-13s %-10.2f₴\n", 1, "Джинси", "Жіночий одяг", 1500.78);
        formatter.format("%-3d %-10s %-13s %-10.2f₴\n", 2, "Спідниця", "Жіночий одяг", 1000.56);
        formatter.format("%-3d %-10s %-13s %-10.2f₴\n", 3, "Краватка", "Чоловічий одяг", 500.78);

        for (int i = 4; i <= 10; i++) {
            formatter.format("%-3d %-10s %-13s %-10.2f₴\n", i, "Товар" + i, "Інше", 100.00);
        }

        formatter.format("===========================================\n");
        formatter.format("%-3s %-10s %-13s %-10.2f₴\n", "", "", "Разом:", 3002.34);
        System.out.println(formatter);
    }
}