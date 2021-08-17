package org.gdq.learn.design.decorator;

/**
 * 具体装饰类
 *
 * @author gdq
 * @since 2021/8/17
 */
public class ConcreteDecorator extends Decorator {

    @Override
    public void print() {
        System.out.println("ConcreteDecorator print...");
        super.print();
    }
}
