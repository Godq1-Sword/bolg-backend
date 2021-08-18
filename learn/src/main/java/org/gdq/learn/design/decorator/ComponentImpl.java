package org.gdq.learn.design.decorator;

/**
 * @author gdq
 * @since 2021/8/18
 */
public class ComponentImpl implements Component {
    @Override
    public void print() {
        System.out.println("ComponentImpl print...");
    }
}
