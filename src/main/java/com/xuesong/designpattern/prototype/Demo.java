package com.xuesong.designpattern.prototype;

public class Demo implements Cloneable {
    private String aa;
    private String bb;
    private DemoEntity entity1;
    private DemoEntity entity2;
    private DemoEntity entity3;
    private DemoEntity entity4;
    private DemoEntity entity5;
    private DemoEntity entity6;
    private DemoEntity entity7;
    private DemoEntity entity8;
    private DemoEntity entity9;
    private DemoEntity entity10;

    public Demo(String aa, String bb, DemoEntity entity1, DemoEntity entity2, DemoEntity entity3, DemoEntity entity4, DemoEntity entity5, DemoEntity entity6, DemoEntity entity7, DemoEntity entity8, DemoEntity entity9, DemoEntity entity10) {
        this.aa = aa;
        this.bb = bb;
        this.entity1 = entity1;
        this.entity2 = entity2;
        this.entity3 = entity3;
        this.entity4 = entity4;
        this.entity5 = entity5;
        this.entity6 = entity6;
        this.entity7 = entity7;
        this.entity8 = entity8;
        this.entity9 = entity9;
        this.entity10 = entity10;
    }

    public DemoEntity getEntity1() {
        return entity1;
    }

    public void setEntity1(DemoEntity entity1) {
        this.entity1 = entity1;
    }

    public DemoEntity getEntity2() {
        return entity2;
    }

    public void setEntity2(DemoEntity entity2) {
        this.entity2 = entity2;
    }

    public DemoEntity getEntity3() {
        return entity3;
    }

    public void setEntity3(DemoEntity entity3) {
        this.entity3 = entity3;
    }

    public DemoEntity getEntity4() {
        return entity4;
    }

    public void setEntity4(DemoEntity entity4) {
        this.entity4 = entity4;
    }

    public DemoEntity getEntity5() {
        return entity5;
    }

    public void setEntity5(DemoEntity entity5) {
        this.entity5 = entity5;
    }

    public DemoEntity getEntity6() {
        return entity6;
    }

    public void setEntity6(DemoEntity entity6) {
        this.entity6 = entity6;
    }

    public DemoEntity getEntity7() {
        return entity7;
    }

    public void setEntity7(DemoEntity entity7) {
        this.entity7 = entity7;
    }

    public DemoEntity getEntity8() {
        return entity8;
    }

    public void setEntity8(DemoEntity entity8) {
        this.entity8 = entity8;
    }

    public DemoEntity getEntity9() {
        return entity9;
    }

    public void setEntity9(DemoEntity entity9) {
        this.entity9 = entity9;
    }

    public DemoEntity getEntity10() {
        return entity10;
    }

    public void setEntity10(DemoEntity entity10) {
        this.entity10 = entity10;
    }

    public String getAa() {
        return aa;
    }

    public void setAa(String aa) {
        this.aa = aa;
    }

    public String getBb() {
        return bb;
    }

    public void setBb(String bb) {
        this.bb = bb;
    }

    @Override
    public Demo clone() {
        Demo clone = null;
        try {
            clone = (Demo) super.clone();
            clone.setEntity1(clone.getEntity1().clone());
            clone.setEntity2(clone.getEntity2().clone());
            clone.setEntity3(clone.getEntity3().clone());
            clone.setEntity4(clone.getEntity4().clone());
            clone.setEntity5(clone.getEntity5().clone());
            clone.setEntity6(clone.getEntity6().clone());
            clone.setEntity7(clone.getEntity7().clone());
            clone.setEntity8(clone.getEntity8().clone());
            clone.setEntity9(clone.getEntity9().clone());
            clone.setEntity10(clone.getEntity10().clone());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}
