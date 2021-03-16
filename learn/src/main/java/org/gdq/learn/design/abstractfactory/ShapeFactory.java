package org.gdq.learn.design.abstractfactory;

/**
 * 图形工厂
 *
 * @author gdq
 * date 2021/3/16
 */
public class ShapeFactory extends AbstractFactory {
    @Override
    public Color getColor(ColorType colorType) {
        return null;
    }

    @Override
    public Shape getShape(ShapeType shapeType) {
        switch (shapeType) {
            case rectangle -> { return new Rectangle();}
            case circle -> { return new Circle();}
            default -> { return null;}
        }
    }
}
