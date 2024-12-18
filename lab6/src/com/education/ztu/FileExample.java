package com.education.ztu;

import java.io.File;
import java.io.IOException;

public class FileExample {
    public static void main(String[] args) {
        String parentFolder = "directory_for_files";
        File innerDirectory = new File(parentFolder, "inner_directory");

        // Створення папки
        if (!innerDirectory.exists() && innerDirectory.mkdir()) {
            System.out.println("Folder created: " + innerDirectory.getAbsolutePath());
        }

        // Вивід даних про батьківську папку
        System.out.println("Parent directory: " + innerDirectory.getParent());

        // Створення файлів
        File file1 = new File(innerDirectory, "file1.txt");
        File file2 = new File(innerDirectory, "file2.txt");

        try {
            if (file1.createNewFile()) {
                System.out.println("File created: " + file1.getAbsolutePath());
            }
            if (file2.createNewFile()) {
                System.out.println("File created: " + file2.getAbsolutePath());
            }
        } catch (IOException e) {
            System.err.println("Error while creating files: " + e.getMessage());
            e.printStackTrace();
        }

        if (file2.exists() && file2.delete()) { // Видалення одного файлу
            System.out.println("File deleted: " + file2.getAbsolutePath());
        }

        // Перейменування папки
        File renamedDirectory = new File(parentFolder, "renamed_inner_directory");
        if (innerDirectory.exists() && innerDirectory.renameTo(renamedDirectory)) {
            System.out.println("Folder renamed: " + renamedDirectory.getAbsolutePath());
        }

        // Список файлів та папок
        File dir = new File(parentFolder);
        File[] filesList = dir.listFiles();
        if (filesList != null) {
            for (File file : filesList) {
                System.out.println(file.getName() + " - " + (file.isFile() ? "File" : "Directory") + " - " + file.length() + " bytes");
            }
        } else {
            System.err.println("Failed to list files in directory: " + parentFolder);
        }
    }
}