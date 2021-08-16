package org.gdq.learn.design.prototype;

/**
 * 原型模式例子
 *
 * @author gdq
 * @since 2021/8/16
 */
public class Example implements Cloneable {

    @Override
    public Example clone() throws CloneNotSupportedException {
        return (Example) super.clone();
    }
}
