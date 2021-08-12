package org.gdq.learn.design.simplefactory;

/**
 * 图形工厂
 *
 * @author gdq
 * @since 2021/3/16
 */
public class ShapeFactory {

    /**
     * 创建图形
     *
     * @param shapeType 图形enum
     * @return Shape 图形
     * @author gdq
     * @since 2021/3/16
     */
    public Shape create(ShapeType shapeType) {
        switch (shapeType) {
            case rectangle -> {
                return new Rectangle();
            }
            case circle -> {
                return new Circle();
            }
            default -> {
                return null;
            }
        }
    }
}
