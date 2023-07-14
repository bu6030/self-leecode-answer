package com.xuesong.java.java9.try_with_resources;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Java 9 允许在 try-with-resources 语句中使用资源的定义和初始化
 */
public class TryWithResourcesExample {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("/Users/XuesongBu/Documents/git_code/self-leecode-answer/src/main/resources/application.yaml"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

