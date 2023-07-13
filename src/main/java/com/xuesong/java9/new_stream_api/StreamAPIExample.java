package com.xuesong.java9.new_stream_api;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 *
 * 1. takeWhile是遇到第一个不符合的元素时停止，即使后边仍然有满足的元素，并返回前面的
 * 2. dropWhile是遇到第一个不符合的元素时停止，丢弃前面所有满足的元素，返回后边的元素
 * 3. ofNullable() 方法允许我们创建一个包含单个元素的 Stream，如果传入的元素是非空的
 * 则创建一个包含该元素的 Stream；如果传入的元素是空值（null）
 * 则创建一个空的 Stream。这对于处理可能为空的元素很有用，可以避免空指针异常。
 * 4. iterator() 方法的重载， list.spliterator()以及StreamSupport.stream结合使用返回 stream
 * 5. Optional 和 Stream 的结合，实际上可以类似于 List.stream()方法，同样使用optional.stream()
 *
 */
public class StreamAPIExample {

    public static void main(String[] args) {
        System.out.println("====takeWhile======");
        // takeWhile是遇到第一个不符合的元素时停止，即使后边仍然有满足的元素，并返回前面的
        Stream<Integer> stream1 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 4);
        Stream<Integer> filteredStream1 = stream1.takeWhile(n -> n < 5);
        filteredStream1.forEach(System.out::println);

        System.out.println("=====dropWhile=====");
        // dropWhile是遇到第一个不符合的元素时停止，丢弃前面所有满足的元素，返回后边的元素
        Stream<Integer> stream2 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 4);
        Stream<Integer> filteredStream2 = stream2.dropWhile(n -> n < 5);
        filteredStream2.forEach(System.out::println);

        System.out.println("=====ofNullable=====");
        Stream<String> stream3 = Stream.ofNullable("Hello");
        stream3.forEach(System.out::println);

        Stream<String> stream4 = Stream.ofNullable(null);
        stream4.forEach(System.out::println);

        System.out.println("=====iterator() 方法的重载=====");
        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("C++");
        list.add("Python");

        Stream<String> stream = StreamSupport.stream(list.spliterator(), false);
        stream.forEach(System.out::println);

        System.out.println("===== Optional 和 Stream 之间的结合进=====");
        Optional<String> optional = Optional.of("Hello");
        optional.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }
}
