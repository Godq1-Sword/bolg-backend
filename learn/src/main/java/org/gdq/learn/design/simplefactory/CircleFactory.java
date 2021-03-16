package org.gdq.learn.design.simplefactory;

/**
 * 圆形工厂
 *
 * @author gdq
 * date 2021/3/16
 */
public class CircleFactory implements MethodFactory {

    @Override
    public Shape create() {
        return new Circle();
    }
}
