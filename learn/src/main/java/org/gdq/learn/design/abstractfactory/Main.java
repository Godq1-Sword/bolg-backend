package org.gdq.learn.design.abstractfactory;

/**
 * 抽象工厂[Main]
 *
 * @author gdq
 * @since 2021/3/16
 */
public class Main {

    public static void main(String[] args) {
        AbstractFactory colorFactory = FactoryProducer.getFactory(FactoryType.colorFactory);
        assert colorFactory != null;
        Color blue = colorFactory.getColor(ColorType.blue);
        Color red = colorFactory.getColor(ColorType.red);
        blue.fill();
        red.fill();
        AbstractFactory shapeFactory = FactoryProducer.getFactory(FactoryType.shapeFactory);
        assert shapeFactory != null;
        Shape rectangle = shapeFactory.getShape(ShapeType.rectangle);
        Shape circle = shapeFactory.getShape(ShapeType.circle);
        rectangle.draw();
        circle.draw();
    }
}
