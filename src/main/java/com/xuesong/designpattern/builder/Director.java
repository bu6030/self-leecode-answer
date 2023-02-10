package com.xuesong.designpattern.builder;

public class Director {
    Builder builder = null;

    public Director(Builder builer) {
        this.builder = builer;
    }

    public void construct(String name, String param1, String param2){
        builder.buildProductName(name);
        builder.buildProductParam1(param1);
        builder.buildProductParam2(param2);
    }
}
