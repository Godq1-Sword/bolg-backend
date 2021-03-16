package org.gdq.learn.design.abstractfactory;

/**
 * 颜色工厂
 *
 * @author gdq
 * date 2021/3/16
 */
public class ColorFactory extends AbstractFactory {
    @Override
    public Color getColor(ColorType colorType) {
        switch (colorType) {
            case red -> { return new Red(); }
            case blue -> { return new Blue(); }
            default -> { return null; }
        }
    }

    @Override
    public Shape getShape(ShapeType shapeType) {
        return null;
    }
}
