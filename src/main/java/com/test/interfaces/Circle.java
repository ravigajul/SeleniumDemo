package com.test.interfaces;

public class Circle implements Shape {
    double radius;
    String color;

    public Circle(String color, double radius) {
        System.out.println("Circle constructor called");
        this.radius = radius;
        this.color = color;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public String info() {
        return "Circle";
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String toString() {
        return "Color: " + color + ", Radius: " + radius;
    }

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

    @Override
    public String displayColor() {
        return "Color: " + this.color;
    }

}
