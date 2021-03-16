package org.gdq.learn.design.simplefactory;

/**
 * 长方形工厂
 *
 * @author gdq
 * date 2021/3/16
 */
public class RectangleFactory implements MethodFactory {
    @Override
    public Shape create() {
        return new Rectangle();
    }
}
