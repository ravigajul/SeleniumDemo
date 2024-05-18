package com.test.encapsulation;

public class MyClass {
    public static void main(String[] args) {
        MyPrivateClass myPrivateClass = new MyPrivateClass();
        //System.out.println(myPrivateClass.str); //compilation error as str is private and not visible
        //myPrivateClass.myPrivateMethod(); //compilation error as myPrivateMethod is private and not visible
        myPrivateClass.setStr("New String");
        System.out.println(myPrivateClass.getStr());
    }
}
