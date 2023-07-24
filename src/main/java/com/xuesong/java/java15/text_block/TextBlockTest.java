package com.xuesong.java.java15.text_block;

/**
 * JAVA15 新增文本块
 * 终于支持了一种多行字符串文字，写起来更方便了，不用那么多引号加号了
 */
public class TextBlockTest {
    public static void main(String[] args) {
        // 原来的写法
        String html = "<html>\n" +
                "<body>\n" +
                " <h1>Java 15以前写法，不方便</h1>\n" +
                " <p>xuesong</p>\n" +
                "</body>\n" +
                "</html>";
        System.out.println(html);
        // 新写法
        html = """
            <html>
            <body>
             <h1>Java 15 新特性：文本块</h1>
             <p>xuesong</p>
            </body>
            </html>
            """;
        System.out.println(html);
    }
}
