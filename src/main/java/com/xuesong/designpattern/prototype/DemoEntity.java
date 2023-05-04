package com.xuesong.designpattern.prototype;

public class DemoEntity implements Cloneable {
    private String aa;
    private String bb;

    public DemoEntity(String aa, String bb) {
        this.aa = aa;
        this.bb = bb;
    }
    @Override
    public DemoEntity clone() {
        DemoEntity clone = null;
        try {
            clone = (DemoEntity) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}
