package org.gdq.learn.design.simplefactory;

/**
 * 工厂模式[Main]
 *
 * @author gdq
 * date 2021/3/16
 */
public class Main {

    public static void main(String[] args) {
        // 简单工厂模式 - 1.分类型
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape rectangle = shapeFactory.create(ShapeType.rectangle);
        Shape circle = shapeFactory.create(ShapeType.circle);
        rectangle.draw();
        circle.draw();
        // 简单工厂模式 - 2.静态方法
        Shape staticRectangle = ShapeFactory.createRectangle();
        Shape staticCirCle = ShapeFactory.createCircle();
        staticRectangle.draw();
        staticCirCle.draw();
        // 简单工厂模式 - 3.工厂方法
        MethodFactory rectangleFactory = new RectangleFactory();
        MethodFactory circleFactory = new CircleFactory();
        Shape methodRectangle = rectangleFactory.create();
        Shape methodCircle = circleFactory.create();
        methodRectangle.draw();
        methodCircle.draw();
    }
}
