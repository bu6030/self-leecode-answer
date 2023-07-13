package com.xuesong.java9.private_interface_methods;

public class MyClass implements MyInterface {
    @Override
    public void publicMethod() {
        System.out.println("This is a public method.");
    }

    public static void main(String[] args) {
        MyClass myObj = new MyClass();
        myObj.publicMethod();   // 调用公共抽象方法
        myObj.defaultMethod();  // 调用默认方法
    }
}