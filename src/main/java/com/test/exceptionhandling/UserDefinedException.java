package com.test.exceptionhandling;

public class UserDefinedException extends Exception{
    public static void main(String[] args) {
        try {
            throw new MyException();
        } catch (MyException e) {
            e.printException();
        }
    }
}
