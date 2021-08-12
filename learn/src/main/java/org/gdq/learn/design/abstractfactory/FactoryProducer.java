package org.gdq.learn.design.abstractfactory;

/**
 * 工厂生成器
 *
 * @author gdq
 * @since 2021/3/16
 */
public class FactoryProducer {

    /**
     * 生成工厂
     *
     * @param factoryType 工厂类型
     * @return AbstractFactory 工厂
     * @author gdq
     * @since 2021/3/16
     */
    public static AbstractFactory getFactory(FactoryType factoryType) {
        switch (factoryType) {
            case shapeFactory -> { return new ShapeFactory(); }
            case colorFactory -> { return new ColorFactory(); }
            default -> { return null; }
        }
    }
}
