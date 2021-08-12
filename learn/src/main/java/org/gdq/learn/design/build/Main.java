package org.gdq.learn.design.build;

/**
 * 建造者模式[Main]
 *
 * @author gdq
 * @since 2021/8/12
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(Example.builder().item1("item1").item2(2).item3(3.0).item4(true).build());
    }
}
