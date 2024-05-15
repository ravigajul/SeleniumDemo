package com.test.accessmodifiers.dev;

public class Dev {
    public String name = "Dev";
    private String email = "ravi.gajul@test.com";
    protected String phone = "1234567890";
    String address = "Hyderabad";

    public void print() {
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
        System.out.println("Address: " + address);
    }

    public static void main(String[] args) {
        Dev dev = new Dev();
        dev.print();
        System.out.println(dev.address); // default is accessible within the same package and same class    
    }
}
