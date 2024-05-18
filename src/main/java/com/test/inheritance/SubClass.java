package com.test.inheritance;

public class SubClass  extends SuperClass{
    String substr = "SubClass String";
    String commonstr = "sub class common string";
    public SubClass(String str) { 
        super(str); // calling super class constructor with string argument
        System.out.println("SubClass Constructor");
        
    }
    public void subClassMethod() {
        System.out.println("SubClass Method");
    }
    public void printCommonString(){
        System.out.println("Common String: " + commonstr); //accessing subclass variable
        System.out.println("Common String: " + super.commonstr); //accessing super class variable
    }
    public void commonMethod(){
        System.out.println("Sub Common Method");
    }

    public void printCommonMethod(){
        commonMethod(); //calls the method from SubClass
        super.commonMethod(); //calls the method from SuperClass
    }
}
