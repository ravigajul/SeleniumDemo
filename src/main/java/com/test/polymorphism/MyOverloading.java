package com.test.polymorphism;

public class MyOverloading {
    public void myMethod(int a){
        System.out.println("int method");
    }
    
    //method overloading as number of arguments is different
    public void myMethod(int a, int b){
        System.out.println("int,int method");
    }

    //method overloading as type of arguments is different
    public void myMethod(double d){
        System.out.println("double method");
    }

    //method overloading as sequence of arguments is different
    public void myMethod(int a, double d){
        System.out.println("int,double method");
    }
}
