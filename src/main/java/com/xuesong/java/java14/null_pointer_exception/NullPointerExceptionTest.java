package com.xuesong.java.java14.null_pointer_exception;

/**
 * JAVA 14 NullPointerException优化，打印更具体异常信息
 *
 */
public class NullPointerExceptionTest {
    public static void main(String[] args) {
        TestDemo testDemo = new TestDemo(null, 0);
        testDemo.getA().toString();
//        老版本会打印如下：
//        Exception in thread "main" java.lang.NullPointerException
//        at com.xuesong.java.java14.null_pointer_exception.NullPointerExceptionTest.main(NullPointerExceptionTest.java:6)
//        新版本会打印如下，打印内容十分具体，可以看到哪个值是 null：
//        Exception in thread "main" java.lang.NullPointerException: Cannot invoke "String.toString()" because the return value of "com.xuesong.java.java14.null_pointer_exception.NullPointerExceptionTest$TestDemo.getA()" is null
//        at com.xuesong.java.java14.null_pointer_exception.NullPointerExceptionTest.main(NullPointerExceptionTest.java:10)
    }
    static class TestDemo {
        private String a;
        private int b;
        public TestDemo(String a, int b) {
            this.a = a;
            this.b = b;
        }
        public String getA() {
            return a;
        }
        public int getB() {
            return b;
        }
    }
}
