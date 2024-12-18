package com.education.ztu;

import java.io.File;
import java.io.RandomAccessFile;
import java.io.IOException;

public class RandomAccessExample {
    public static void main(String[] args) {
        String directoryPath = "directory_for_files"; // Шлях до папки
        String filePath = directoryPath + "/products.txt"; // Шлях до файлу

        try {
            // Перевіряємо, чи існує директорія; якщо її немає — створюємо
            File directory = new File(directoryPath);
            if (!directory.exists()) {
                if (directory.mkdirs()) {
                    System.out.println("Директорія створена: " + directoryPath);
                } else {
                    System.err.println("Не вдалося створити директорію: " + directoryPath);
                    return;
                }
            }

            // Перевіряємо, чи існує файл; якщо його немає — створюємо
            File file = new File(filePath);
            if (!file.exists()) {
                if (file.createNewFile()) {
                    System.out.println("Файл створено: " + filePath);
                } else {
                    System.err.println("Не вдалося створити файл: " + filePath);
                    return;
                }
            }

            // Робота з RandomAccessFile
            try (RandomAccessFile randomAccessFile = new RandomAccessFile(filePath, "rw")) {
                randomAccessFile.seek(0); // Переміщення на початок
                randomAccessFile.writeBytes("New Product: TV\n");

                randomAccessFile.seek(randomAccessFile.length()); // Переміщення в кінець
                randomAccessFile.writeBytes("New Product: Headphones\n");
            }

            System.out.println("Дані успішно записані у файл.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}