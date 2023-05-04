package com.xuesong.designpattern.builder;

/**
 * 建造者模式
 * 使用多个简单的对象一步一步构建成一个复杂的对象，注意是有固定步骤的，
 * 不像工厂模式那种，没有步骤无论哪一部分都可以同时创建。
 * 具体有如下几个部分：
 * Product：最终要生成的对象，例如Soup实例。
 * Builder：建设者的抽象基类（有时会使用接口代替）。其定义了构建Product的抽象步骤，其实体类需要实现这些步骤。
 * 它会包含一个用来返回最终产品的方法Product getProduct()。
 * ConcreteBuilder：Builder的实现类。
 * Director：决定如何构建最终产品的步骤，其会包含一个负责组装的方法void Construct(Builder builder)，
 * 在这个方法中通过调用builder的方法，就可以设置builder，等设置完成后，
 * 就可以通过builder的getProduct()方法获得最终的产品。
 */
public class Test {
    public static void main(String[] args) {
        ConcreteBuilder carBuilder = new ConcreteBuilder();
        Director director = new Director(carBuilder);
        director.construct("小汽车",  "跑得快", "安全性高");
        Product product = carBuilder.getProcut();
        System.out.println(product);
    }
}
