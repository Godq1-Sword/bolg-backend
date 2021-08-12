package org.gdq.learn.design.abstractfactory;

/**
 * 蓝色
 *
 * @author gdq
 * @since 2021/3/16
 */
public class Blue implements Color {
    @Override
    public void fill() {
        System.out.println("Blue fill success");
    }
}
