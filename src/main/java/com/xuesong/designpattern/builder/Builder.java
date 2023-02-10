package com.xuesong.designpattern.builder;

public interface Builder {
    Product getProcut();
    void buildProductName(String name);
    void buildProductParam1(String param1);
    void buildProductParam2(String param2);
}
