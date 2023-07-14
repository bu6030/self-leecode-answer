package com.xuesong.java.java9.reactive_streams_api;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/**
 * JAVA9 新增Reactive Streams API
 */
public class DataProcessor implements Subscriber<Data> {

    private Subscription subscription;

    public static void main(String[] args) throws Exception {
        // 创建数据源，例如从数据库中获取数据
        DataPublisher dataPublisher = new DataPublisher();
        // 创建数据处理器
        DataProcessor dataProcessor = new DataProcessor();
        // 连接数据源和数据处理器
        dataPublisher.subscribe(dataProcessor);
        // 发布数据
        dataPublisher.publishData(new Data(1, "Zhangsan"));
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        this.subscription = subscription;
        this.subscription.request(1); // 请求一个数据项
    }

    @Override
    public void onNext(Data data) {
        // 处理接收到的数据
        System.out.println("Received data: " + data);
        // 请求下一个数据项
        subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        // 处理错误情况
        throwable.printStackTrace();
    }

    @Override
    public void onComplete() {
        // 数据处理完成
        System.out.println("Data processing completed.");
    }
}
