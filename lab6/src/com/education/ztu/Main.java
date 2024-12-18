package com.education.ztu;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        String baseDir = "directory_for_files";
        File baseDirectory = new File(baseDir);

        // 1. Створення базової папки
        if (!baseDirectory.exists()) {
            if (baseDirectory.mkdir()) {
                System.out.println("Base directory created: " + baseDirectory.getAbsolutePath());
            } else {
                System.out.println("Failed to create base directory.");
                return; // Якщо папку не створено, завершуємо тест
            }
        }

        // 2. Перевірка логіну та паролю
        System.out.println("\n=== Завдання 2: Перевірка логіну та паролю ===");
        boolean isValidCredentials = CredentialsChecker.checkCredentials(
                "validUser_123", "StrongPassword_456", "StrongPassword_456"
        );
        System.out.println("Credentials are valid: " + isValidCredentials);

        // 3. Робота із записом і читанням файлу
        System.out.println("\n=== Завдання 3: Запис і читання звіту ===");
        String purchaseReportPath = baseDir + "/purchase_report.txt";
        String reportContent = "Item: Laptop, Price: $1200\nItem: Mouse, Price: $25\nTotal: $1225";
        PurchaseReport.writeReport(purchaseReportPath, reportContent);
        System.out.println("Читання звіту:");
        PurchaseReport.readReport(purchaseReportPath);

        // 4. Копіювання файлу
        System.out.println("\n=== Завдання 4: Копіювання файлу ===");
        String sourceFilePath = purchaseReportPath;
        String copiedFilePath = baseDir + "/copied_report.txt";
        FileCopy.copyFile(sourceFilePath, copiedFilePath);

        // 5. Робота із RandomAccessFile
        System.out.println("\n=== Завдання 5: Робота з RandomAccessFile ===");
        String randomAccessFilePath = baseDir + "/products.txt";
        PurchaseReport.writeReport(randomAccessFilePath, "Item 1: Phone\nItem 2: Tablet\n");
        RandomAccessExample.main(new String[]{});

        // 6. Робота з File
        System.out.println("\n=== Завдання 6: Робота з класом File ===");
        FileExample.main(new String[]{});

        // 7. Створення архіву
        System.out.println("\n=== Завдання 7: Створення архіву ===");
        String archivePath = baseDir + "/archive.zip";
        Archiver.createZip(baseDir, archivePath);
        System.out.println("Файли в архіві:");
        Archiver.readZip(archivePath);
    }
}