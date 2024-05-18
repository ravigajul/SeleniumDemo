package com.test.abstraction;

public class Circle extends Shape {
    double radius;

    public Circle(String color, double radius) {
        super(color);
        System.out.println("Circle constructor called");
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * radius * radius;
    }

    @Override
    String info() {
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

}
