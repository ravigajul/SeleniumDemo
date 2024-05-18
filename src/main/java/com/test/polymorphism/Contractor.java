package com.test.polymorphism;

public class Contractor extends Employee {  
    @Override
    public int salary(){
        return base + 10000;
    }

    static String designation(){
        return "Contractor";
    }
    
}
