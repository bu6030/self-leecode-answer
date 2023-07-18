package com.xuesong.java.java17.radom_number;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;

/**
 * JAVA 17 新增了随机数生成类
 * JAVA 17 之前可以使用Random来生成随机数，但是存在缺陷
 *
 */
public class RandomNumberTest {
    public static void main(String[] args) {
        // Random 缺陷，高并发情况下，可能使用同一个种子数字去生成下一个随机数
        // 可能会导致生成的数字相同
        for (int i = 0; i < 10; i++) {
            Random random1 = new Random(15);
            System.out.println(random1.nextInt(100));
        }
        // 因此使用了新的算法生成随机数字
        RandomGeneratorFactory<RandomGenerator> l128X256MixRandom =
                RandomGeneratorFactory.of("L128X256MixRandom");
        // 使用时间戳作为随机数种子
        RandomGenerator randomGenerator = l128X256MixRandom.create(System.currentTimeMillis());
        // 生成随机数，并统计随机生成的个数
        int random = -1;
        Map<Integer, Integer> numberCountMap = new HashMap<>();
        for (int i = 0; i < 100000; i++) {
            random = randomGenerator.nextInt(10);
            // 统计数字出现次数
            if (numberCountMap.containsKey(random)) {
                int count = numberCountMap.get(random);
                numberCountMap.put(random, count + 1);
            } else {
                numberCountMap.put(random, 1);
            }
        }
        // 输出每个数字出现次数
        for (int number = 0; number < 10; number++) {
            int count = numberCountMap.getOrDefault(number, 0);
            System.out.println("数字 " + number + " 出现了 " + count + " 次");
        }
    }
}
