package com.xuesong.java.java21.virtual_thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * JAVA21 虚拟线程
 */
public class VirtualThreadTest {
    static int index = 0;
    public static void main(String[] args) {
        // 创建线程
        Runnable runnable = () -> {
            index ++;
            System.out.println("Hello, Xuesong " + Thread.currentThread().getName() + "; index = " + index);
        };
        System.out.println("======virtualThread======");
        // 使用静态构建器方法创建执行
        Thread virtualThread = Thread.startVirtualThread(runnable);
        System.out.println("======Thread.ofVirtual()======");
        Thread.ofVirtual()
                .name("Xuesong virtual thread")
                .start(runnable);
        System.out.println("======Executors.newVirtualThreadPerTaskExecutor()======");
        // 通过Executors的newVirtualThreadPerTaskExecutor方法创建执行虚拟线程
        try (ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < 5; i++) {
                executorService.submit(runnable);
            }
        }
        System.out.println("======virtualThreadFactory======");
        // 通过ThreadFactory创建执行
        ThreadFactory virtualThreadFactory = Thread.ofVirtual()
                .name("Xuesong virtual thread factory", 0)
                .factory();
        Thread factoryThread = virtualThreadFactory.newThread(runnable);
        factoryThread.start();
        factoryThread = virtualThreadFactory.newThread(runnable);
        factoryThread.start();
    }
}
