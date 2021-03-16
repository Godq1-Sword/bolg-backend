package org.gdq.learn.design.abstractfactory;

/**
 * 圆形
 *
 * @author gdq
 * date 2021/3/16
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Circle draw success");
    }
}
