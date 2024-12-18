package com.education.ztu;

import java.io.*;

public class PurchaseReport {
    public static void main(String[] args) {
        String filePath = "directory_for_files/purchase_report.txt";
        String shoppingReport = "Item: Laptop, Price: $1200\nItem: Mouse, Price: $25\nTotal: $1225";

        // Запис у файл
        writeReport(filePath, shoppingReport);

        // Зчитування звіту з файлу
        System.out.println("Report from file:");
        readReport(filePath);
    }

    public static void writeReport(String filePath, String content) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(filePath);
            writer.write(content);
            System.out.println("Report successfully saved.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void readReport(String filePath) {
        FileReader reader = null;
        BufferedReader bufferedReader = null;
        try {
            reader = new FileReader(filePath);
            bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
