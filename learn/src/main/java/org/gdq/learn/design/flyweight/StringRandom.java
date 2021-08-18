package org.gdq.learn.design.flyweight;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * @author gdq
 * @since 2021/8/18
 */
public class StringRandom {
    // 缓存map
    private Map<String, Integer> cacheMap = new HashMap<>();

    /**
     * 获取随机数
     *
     * @param s 字符串
     * @return int 随机数
     * @author gdq
     * @since 2021/8/18
     */
    public int getRandom(String s) {
        if (cacheMap.containsKey(s)) { return cacheMap.get(s);} else {
            int value = new Random().nextInt();
            cacheMap.put(s, value);
            return value;
        }
    }
}
