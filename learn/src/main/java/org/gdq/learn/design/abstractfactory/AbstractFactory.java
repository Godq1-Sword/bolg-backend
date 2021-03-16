package org.gdq.learn.design.abstractfactory;

/**
 * 抽象工厂
 *
 * @author gdq
 * date 2021/3/16
 */
public abstract class AbstractFactory {
    /**
     * 获取颜色
     *
     * @param colorType 颜色种类
     * @return Color 颜色
     * @author gdq 2021/3/16
     */
    public abstract Color getColor(ColorType colorType);

    /**
     * 获取图形
     *
     * @param shapeType 图形类型
     * @return Shape 图形
     * @author gdq 2021/3/16
     */
    public abstract Shape getShape(ShapeType shapeType);
}
