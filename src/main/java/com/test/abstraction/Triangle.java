package com.test.abstraction;

public class Triangle extends Shape{
    double base;
    double height;
    public Triangle(String color, double base, double height){
       super(color);
        System.out.println("Triangle constructor called");
        this.base = base;
        this.height = height;
    }
    @Override
    double area(){
        return 0.5*base*height;
    }
    @Override
    String info(){
        return "Triangle";
    }   
    public double getBase(){
        return base;
    }

    public double getHeight(){
        return height;
    }
    public void setBase(double base){
        this.base = base;
    }
    public void setHeight(double height){
        this.height = height;
    }

    public String toString(){
        return "Color: " + color + ", Base: " + base + ", Height: " + height;
    }
    public static void main(String[] args) {
        Triangle t = new Triangle("Blue", 5, 10);
        System.out.println(t.area());
        System.out.println(t.info());
        System.out.println(t.displayColor());
        System.out.println(t.getBase());
        System.out.println(t.getHeight());
        t.setBase(10);
        t.setHeight(20);
        System.out.println(t.getBase());
        System.out.println(t.getHeight());
        System.out.println(t.toString());
    }
    
}
