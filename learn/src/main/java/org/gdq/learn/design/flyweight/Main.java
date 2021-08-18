package org.gdq.learn.design.flyweight;

/**
 * 享元模式[Main]
 *
 * @author gdq
 * @since 2021/8/18
 */
public class Main {
    public static void main(String[] args) {
        StringRandom stringRandom = new StringRandom();
        System.out.println(stringRandom.getRandom("flyweight"));
        System.out.println(stringRandom.getRandom("flyweight"));
    }
}
