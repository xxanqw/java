package com.education.ztu;

import java.io.*;

public class FileCopy {
    public static void main(String[] args) {
        String sourcePath = "directory_for_files/source.txt";
        String destinationPath = "directory_for_files/destination.txt";

        copyFile(sourcePath, destinationPath);
    }

    public static void copyFile(String sourcePath, String destinationPath) {
        try (FileInputStream inputStream = new FileInputStream(sourcePath);
             FileOutputStream outputStream = new FileOutputStream(destinationPath)) {

            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            System.out.println("File copied successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}