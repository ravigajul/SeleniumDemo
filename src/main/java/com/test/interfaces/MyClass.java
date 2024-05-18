package com.test.interfaces;

public class MyClass{
    public static void main(String[] args) {
        Circle c = new Circle("Red", 5);
        System.out.println(c.area());
        System.out.println(c.info());
        System.out.println(c.displayColor());
        System.out.println(c.getRadius());
        c.setRadius(10);
        System.out.println(c.getRadius());
        System.out.println(c.toString());
    }
       
}
