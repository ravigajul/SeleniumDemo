package com.test.inheritance;


public class SuperClass {
    String superstr = "SuperClass String";
    String commonstr = "super class common string";
    public SuperClass() {
        System.out.println("SuperClass Constructor");
    }
    public SuperClass(String str) {
        System.out.println("SuperClass Constructor with String arg " + str );
    }
    public void superClassMethod() {
        System.out.println("SuperClass Method");
    } 
    public void printCommonString(){
        System.out.println("Common String: " + commonstr);
    }  
    public void commonMethod(){
        System.out.println("Super Common Method");
    }

}
