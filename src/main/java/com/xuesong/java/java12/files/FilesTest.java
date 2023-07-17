package com.xuesong.java.java12.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * JAVA12 Files方法增强
 */
public class FilesTest {
    public static void main(String[] args) {
        // 新增的 mismatch 方法比较文件内容
        Path file1 = Path.of("/Users/XuesongBu/Desktop/test.py");
        Path file2 = Path.of("/Users/XuesongBu/Desktop/test1.py");
        try {
            boolean contentEquals = Files.mismatch(file1, file2) == -1;
            if (contentEquals) {
                System.out.println("文件内容相等");
            } else {
                System.out.println("文件内容不相等");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
