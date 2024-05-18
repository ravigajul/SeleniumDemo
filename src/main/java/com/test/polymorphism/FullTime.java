package com.test.polymorphism;

public class FullTime extends Employee{
    @Override
    public int salary(){
       return base+20000;
    }
    void myMethod(){
        System.out.println("FullTime Method");
    }
    
    static String designation(){
        return "FullTime";
    }
}
