package com.test.exceptionhandling;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CompileTimeExceptionDemo {
    public static void main(String[] args)  {
        File file = new File("test.txt");
        FileReader fReader = null;
        try {
            fReader = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            
        } finally {
            System.out.println("finally block");  
            if (fReader != null) {
                try {
                    fReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }  
            }
        }
        
    }
}
