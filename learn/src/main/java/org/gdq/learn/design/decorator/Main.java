package org.gdq.learn.design.decorator;

/**
 * 装饰器模式[Main]
 *
 * @author gdq
 * @since 2021/8/18
 */
public class Main {
    public static void main(String[] args) {
        Component component = new ConcreteDecorator(new ComponentImpl());
        component.print();
    }
}
