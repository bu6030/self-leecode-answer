package com.xuesong.java.java11.httpclient;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HTTPClientTest {
    public static void main(String[] args) {
        // 创建一个 HttpClient 实例
        HttpClient httpClient = HttpClient.newHttpClient();
        // 创建一个 GET 请求
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://www.baidu.com"))
                .build();
        // 发送请求并获取响应
        try {
            System.out.println("==========同步请求==========");
            // 同步请求
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            // 检查响应状态码
            int statusCode = response.statusCode();
            System.out.println("Status Code: " + statusCode);
            // 获取响应的内容
            String responseBody = response.body();
            System.out.println("Response Body: " + responseBody);
            System.out.println("==========异步请求==========");
            // 异步请求
            httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                    .thenApply(HttpResponse::body)
                    .thenAccept(System.out::println);
            // 因为是异步，需要等一下主线程再停止
            Thread.sleep(1000L);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
