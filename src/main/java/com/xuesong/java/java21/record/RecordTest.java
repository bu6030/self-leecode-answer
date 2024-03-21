package com.xuesong.java.java21.record;

/**
 * JAVA21 新增的使用了记录模式匹配的代码
 * instanceof 增强
 * switch 增强
 */
public class RecordTest {

    // JAVA20 以及以前的方法，需要强转才行
//    static void print(Object data) {
//        if (data instanceof MyRecord) {
//            MyRecord myRecord = (MyRecord) data;
//            System.out.println("name:"+myRecord.name()+"，type:"+myRecord.type());
//        }
//    }
    // JAVA21 新增的使用了记录模式匹配的代码
    static void print(Object data) {
        // ， instanceof 方法优化，无需强转，下面两种 instanceof 都可以
        if(data instanceof MyRecord1(String name,Integer type)) {
            System.out.println("name:"+name+"，type:"+type);
        }
        if (data instanceof MyRecord2 myRecord) {
            System.out.println("name:" + myRecord.name() + ", type:" + myRecord.type());
        }
        // 新增的 switch 匹配增强，两种匹配方式
        switch (data) {
            case MyRecord1 myRecord1 -> System.out.println("MyRecord1 name " + myRecord1.name()
                    + ", type = " + myRecord1.type());
            case MyRecord2 myRecord2 -> System.out.println("MyRecord2 name = " + myRecord2.name()
                    + ", type = " + myRecord2.type());
            default -> throw new IllegalStateException("Unexpected value: " + data);
        }
        switch (data) {
            case MyRecord1(String name, Integer type) -> System.out.println("MyRecord1 name = " + name
                    + ", type = " + type);
            case MyRecord2(String name, Integer type) -> System.out.println("MyRecord2 name = " + name
                    + ", type = " + type);
            default -> throw new IllegalStateException("Unexpected value: " + data);
        }
    }

    public static void main(String[] args) {
        MyRecord1 myRecord1 = new MyRecord1("ZhangSan",1);
        RecordTest.print(myRecord1);
        MyRecord2 myRecord2 = new MyRecord2("Lisi",2);
        RecordTest.print(myRecord2);
    }
}