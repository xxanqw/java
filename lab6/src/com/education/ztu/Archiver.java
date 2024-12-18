package com.education.ztu;

import java.io.*;
import java.util.zip.*;

public class Archiver {
    public static void main(String[] args) {
        String sourceDir = "directory_for_files";
        String zipFile = "directory_for_files/archive.zip";

        createZip(sourceDir, zipFile);
        readZip(zipFile);
    }

    public static void createZip(String sourceDir, String zipFile) {
        try (FileOutputStream fos = new FileOutputStream(zipFile);
             ZipOutputStream zos = new ZipOutputStream(fos)) {

            File dir = new File(sourceDir);

            for (File file : dir.listFiles()) {
                if (file.isFile()) {
                    try (FileInputStream fis = new FileInputStream(file)) {
                        ZipEntry entry = new ZipEntry(file.getName());
                        zos.putNextEntry(entry);

                        byte[] buffer = new byte[1024];
                        int bytesRead;
                        while ((bytesRead = fis.read(buffer)) != -1) {
                            zos.write(buffer, 0, bytesRead);
                        }
                        zos.closeEntry();
                    }
                }
            }

            System.out.println("Archive created successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readZip(String zipFile) {
        try (FileInputStream fis = new FileInputStream(zipFile);
             ZipInputStream zis = new ZipInputStream(fis)) {

            ZipEntry entry;
            System.out.println("Files in archive:");
            while ((entry = zis.getNextEntry()) != null) {
                System.out.println(entry.getName());
                zis.closeEntry();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}