package org.gdq.learn.design.facade;

/**
 * 外观模式[Main]
 *
 * @author gdq
 * @since 2021/8/18
 */
public class Main {
    public static void main(String[] args) throws Exception {
        double sum = new NumberFacade().add(1.0, 2.0);
        System.out.println(sum);
    }
}
