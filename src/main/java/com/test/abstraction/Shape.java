package com.test.abstraction;

public abstract class Shape {
    String color;

    public Shape(String color) {
        System.out.println("Shape constructor called");
        this.color = color;
    }

    abstract double area();

    abstract String info();

    public String displayColor() {
        return color;
    }
}
