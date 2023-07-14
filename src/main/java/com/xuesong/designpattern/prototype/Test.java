package com.xuesong.designpattern.prototype;

/**
 * 原型模式
 * 实际上就是实现 Cloneable 接口，重写 clone() 方法，
 * 用于创建重复的对象，同时又能保证性能。
 * 当直接创建对象的代价比较大时，则采用这种模式。
 * 例如一个购物订单中存在1000个同样的物品，如果在表中需要存储1000条数据，
 * 因此可以通过原型模式实现，在java中，通过 clone() 方法生成1000个该物品即可。
 */
public class Test {

    public static void main(String[] args) throws Exception{
        Long start = System.currentTimeMillis();
        Long end = null;
        Long time = null;
        Demo demo = null;

        start = System.currentTimeMillis();
        demo = new Demo("aa","bb", new DemoEntity("aa","bb"), new DemoEntity("aa","bb"), new DemoEntity("aa","bb")
                , new DemoEntity("aa","bb"), new DemoEntity("aa","bb"), new DemoEntity("aa","bb")
                , new DemoEntity("aa","bb"), new DemoEntity("aa","bb")
                , new DemoEntity("aa","bb"), new DemoEntity("aa","bb"));
        for (int i = 0; i < 10000000; i++) {
            Demo newDemo = demo.clone();
        }
        end = System.currentTimeMillis();
        time = (end - start );
        System.out.println("clone create times is " + time);

        for (int i = 0; i < 10000000; i++) {
            demo = new Demo("aa","bb", new DemoEntity("aa","bb"), new DemoEntity("aa","bb"), new DemoEntity("aa","bb")
                    , new DemoEntity("aa","bb"), new DemoEntity("aa","bb"), new DemoEntity("aa","bb")
                    , new DemoEntity("aa","bb"), new DemoEntity("aa","bb")
                    , new DemoEntity("aa","bb"), new DemoEntity("aa","bb"));
        }
        end = System.currentTimeMillis();
        time = (end - start );
        System.out.println("new create times is " + time);
    }
}
