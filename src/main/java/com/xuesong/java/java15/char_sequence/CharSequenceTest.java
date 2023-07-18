package com.xuesong.java.java15.char_sequence;

/**
 * JAVA15 CharSequence增加 isEmpty() 方法
 */
public class CharSequenceTest {
    public static void main(String[] args) {
        // CharSequence 的具体是实现类都增加了isEmpty()方法
        StringBuffer stringBuffer = new StringBuffer();
        System.out.println(stringBuffer.isEmpty());
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println(stringBuilder.isEmpty());
    }
}