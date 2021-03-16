package org.gdq.learn.design.abstractfactory;

/**
 * 长方形
 *
 * @author gdq
 * date 2021/3/16
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Rectangle draw success");
    }
}
