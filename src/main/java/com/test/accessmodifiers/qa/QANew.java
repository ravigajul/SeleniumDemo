package com.test.accessmodifiers.qa;

import com.test.accessmodifiers.dev.Dev;

public class QANew extends Dev {
    public static void main(String[] args) {
        QANew qanew = new QANew();
        
        System.out.println("Name: " + qanew.name); // public is accessible
        System.out.println("Phone: " + qanew.phone); // protected is accessible since it is inherited
        // System.out.println("Email: " + qanew.email); // private is not accessible outside the class
        // System.out.println("Address: " + qanew.address); // default is not accessible outside the package
    

        QA qa = new QA();
        System.out.println("Name: " + qa.name); // public is accessible
         System.out.println("Phone: " + qa.phone); // protected is accessible since it within the same package
        // System.out.println("Email: " + qa.email); // private is not accessible outside the class
         System.out.println("Address: " + qa.address); // default is accessible since it within the same package    
    }
}
