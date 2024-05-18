package com.test.polymorphism;

public class MyClass {
    public static void main(String[] args) {
        Employee emp = new Employee();
        System.out.println("Employee salary: " + emp.salary());
        
        FullTime ft = new FullTime();
        System.out.println("FullTime salary: " + ft.salary());
        ft.myMethod();

        Contractor ct = new Contractor();
        System.out.println("Contractor salary: " + ct.salary());
        System.out.println("-----------------------------------------------");

        //employee reference with fulltime object
        Employee e = new FullTime();
        System.out.println("FullTime Salary: " + e.salary());
        //System.out.println(e.myMethod()); //compilation error as myMethod is not in Employee class
        
        Employee c = new Contractor();
        System.out.println("Contractor Salary: " + c.salary());

        System.out.println(Employee.designation());
        System.out.println(FullTime.designation());
        System.out.println(Contractor.designation());

        //overloading is compile time polymorphism
        MyOverloading myOverloading = new MyOverloading();
        myOverloading.myMethod(10);
        myOverloading.myMethod(10, 20);
        myOverloading.myMethod(10.20);

    }
   
}
