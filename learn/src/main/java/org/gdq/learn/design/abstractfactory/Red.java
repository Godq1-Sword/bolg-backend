package org.gdq.learn.design.abstractfactory;

/**
 * 红色
 *
 * @author gdq
 * date 2021/3/16
 */
public class Red implements Color {
    @Override
    public void fill() {
        System.out.println("Red fill success");
    }
}
