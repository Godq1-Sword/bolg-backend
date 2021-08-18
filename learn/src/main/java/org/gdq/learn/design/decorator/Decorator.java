package org.gdq.learn.design.decorator;

/**
 * 装饰类
 *
 * @author gdq
 * @since 2021/8/17
 */
public class Decorator implements Component {

    // 内置类接口,方便链式调用
    private final Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void print() {
        System.out.println("Decorator print...");
        component.print();
    }
}
