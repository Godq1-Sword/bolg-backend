package org.gdq.learn.design.prototype;

/**
 * 原型模式[Main]
 *
 * @author gdq
 * @since 2021/8/16
 */
public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Example example01 = new Example();
        Example example02 = example01.clone();
        System.out.println(example01 == example02);
    }
}
