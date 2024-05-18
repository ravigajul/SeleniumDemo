package com.test.encapsulation;

public class MyPrivateClass {
    private String str="my private string";
   
    private void myPrivateMethod(){
        System.out.println("My Private Method");
    }
    //getter and setter methods   
    public String getStr() {
        myPrivateMethod();
        return str;
    }   
    public void setStr(String str) {
        this.str = str;
    }
}
