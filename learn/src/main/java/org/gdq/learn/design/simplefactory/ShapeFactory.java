package org.gdq.learn.design.simplefactory;

/**
 * 图形工厂
 *
 * @author gdq
 * date 2021/3/16
 */
public class ShapeFactory {

    /**
     * 创建图形
     *
     * @param shapeType 图形enum
     * @return Shape 图形
     * @author gdq 2021/3/16
     */
    public Shape create(ShapeType shapeType) {
        switch (shapeType) {
            case rectangle -> { return new Rectangle();}
            case circle -> { return new Circle();}
            default -> { return null;}
        }
    }

    /**
     * 创建长方形
     *
     * @return Shape 长方形
     * @author gdq 2021/3/16
     */
    public static Shape createRectangle() {
        return new Rectangle();
    }

    /**
     * 创建圆形
     *
     * @return Shape 圆形
     * @author gdq 2021/3/16
     */
    public static Shape createCircle() {
        return new Circle();
    }
}
