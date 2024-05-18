package com.test.fileoperations;

import java.io.File;
import java.io.FileInputStream;

public class FileInputStreamDemo {
    public static void main(String[] args) {
        File file = new File("test.txt");
        System.out.println("File Path : " + file.getAbsolutePath());
        System.out.println("FileName: " + file.getName());
        System.out.println("Write Access : " + file.canWrite());
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            int character;
            while ((character = fileInputStream.read()) != -1) {
                System.out.print((char) character);
            }
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
