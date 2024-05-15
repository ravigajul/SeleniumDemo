package com.test.accessmodifiers.qa;

import com.test.accessmodifiers.dev.Dev;

public class QA {

    public String name = "QA";
    private String email = "ravi.gajul@qa.com";
    protected  String phone = "1234567890";
    String address = "Hyderabad";   
    public static void main(String[] args) {
        Dev dev = new Dev();
        QA qa = new QA();
        System.out.println("Email: " + qa.email); // private is accessible within the same class
        System.out.println("Name: " + dev.name); // public
        //System.out.println("Phone: " + dev.phone); // protected is not accessible outside the package
        // System.out.println("Email: " + dev.email); // private is not accessible outside the class
        // System.out.println("Address: " + dev.address); // default is not accessible outside the package
    }
}
