package com.test.fileoperations;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {
    public static void main(String[] args) {
        File file = new File("test.txt");
        if (file.exists()) {
            try (FileReader reader = new FileReader(file)) {
                int character;
                while((character = reader.read()) != -1){
                    System.out.print((char) character);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("File does not exist");
        }
    }
}