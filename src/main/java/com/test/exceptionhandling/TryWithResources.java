package com.test.exceptionhandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResources {
    //using try-with-resources less code and more readable
    public static void main(String[] args)  {
        File file = new File("test.txt");
        try(FileReader fReader = new FileReader(file)){
            System.out.println("try block");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
