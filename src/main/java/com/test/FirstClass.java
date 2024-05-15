package com.test;

import com.test.constants.EnumConstants;

public class FirstClass 
{
    //instance variable
    int x;
    double y = 10.5;

    //static variable
    static int z;
    String name = "John";
    boolean isTrue = true;

    public FirstClass() {
        System.out.println("Constructor");
        x=5;
    }
    //constructor overloading
    public FirstClass(int x) {
        //referring to the instance variable x
        this.x = x;
    }
    
    public static void main( String[] args )
    {
        String str = "Hello World!";
        System.out.println( "Hello World!" );
        FirstClass obj = new FirstClass();

        //calling non-static method
        obj.initialize();
        FirstClass obj1 = new FirstClass(20);
        System.out.println("The value of x is : " + obj1.x);

        //calling static method
        initialize1(10);
        
        //enum constants
        System.out.println(EnumConstants.SUNDAY);

        //String methods
        str.concat("Java");
        str.toLowerCase();
        str.substring(6);
        str.substring(3, 6);
        System.out.println(str);
        boolean flag = str.equalsIgnoreCase("hello world!");
        System.out.println(flag);
    }
    public void initialize() {
        System.out.println("Initialize");
        x=10;
        System.out.println("The value of x is : " + x);
    }
    public static void initialize1(int z) {
        System.out.println("The value of z is : " + z);
    }
}
