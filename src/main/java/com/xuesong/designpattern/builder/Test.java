package com.xuesong.designpattern.builder;

public class Test {
    public static void main(String[] args) {
        ConcreteBuilder carBuilder = new ConcreteBuilder();
        Director director = new Director(carBuilder);
        director.construct("小汽车",  "跑得快", "安全性高");
        Product product = carBuilder.getProcut();
        System.out.println(product);
    }
}
