package com.xuesong.java.java18.javadoc;

import java.util.Optional;

/**
 * Java 18 javadoc 文档注释增强
 * 通过@snippet可以讲代码格式更好的写到注释里
 * 生成文档中的代码格式输出也比较好看
 */
public class JavaDocTest {
    /**
     *
     * @param args
     * The following code shows how to use {@code Optional.isPresent}:
     * {@snippet :
     * Optional<String> value = Optional.empty();
     * if (value.isPresent()) {
     *     System.out.println("value: " + value.get());
     * }
     * }
     */
    public static void main(String[] args) {
        Optional<String> value = Optional.empty();
        if (value.isPresent()) {
          System.out.println("value: " + value.get());
      }
    }
}
