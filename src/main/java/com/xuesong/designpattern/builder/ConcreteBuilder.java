package com.xuesong.designpattern.builder;

public class ConcreteBuilder implements Builder {

    public Product product = new Product();

    @Override
    public Product getProcut() {
        return product;
    }

    @Override
    public void buildProductName(String name) {
        product.setName(name);
    }

    @Override
    public void buildProductParam1(String param1) {
        product.setParam1(param1);
    }

    @Override
    public void buildProductParam2(String param2) {
        product.setParam2(param2);
    }


}
