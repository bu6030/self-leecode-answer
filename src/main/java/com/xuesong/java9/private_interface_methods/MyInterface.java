package com.xuesong.java9.private_interface_methods;

public interface MyInterface {
    // 公共抽象方法
    void publicMethod();

    // 默认方法
    default void defaultMethod() {
        // 调用私有接口方法
        privateMethod();
        System.out.println("This is a default method.");
    }

    // 私有接口方法
    private void privateMethod() {
        System.out.println("This is a private method.");
    }
}
