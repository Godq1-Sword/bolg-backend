package org.gdq.learn.design.simplefactory;

/**
 * 工厂模式[Main]
 *
 * @author gdq
 * @since 2021/3/16
 */
public class Main {

    // Demo主方法
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        shapeFactory.create(ShapeType.rectangle).draw();
        shapeFactory.create(ShapeType.circle).draw();
    }
}
