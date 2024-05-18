package com.test.inheritance;

public class MainClass {
    public static void main(String[] args) {
        SubClass subClass = new SubClass("Testing"); 
        subClass.superClassMethod();
        subClass.subClassMethod();
        System.out.println(subClass.superstr);
        System.out.println(subClass.substr);
        subClass.printCommonString(); //calls the method from SubClass
        
    }
}
