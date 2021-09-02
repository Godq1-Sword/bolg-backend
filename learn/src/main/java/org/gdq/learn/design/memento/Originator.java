package org.gdq.learn.design.memento;

import lombok.Data;

/**
 * 发起人角色
 *
 * @author gdq
 * @since 2021/9/2
 */
@Data
public class Originator {

    private String state;

    /**
     * 创建备忘录角色
     *
     * @return Memento 备忘录角色
     * @author gdq
     * @since 2021/9/2
     */
    public Memento createMemento() {
        return (new Memento(state));
    }

    /**
     * 设置备忘录角色
     *
     * @param memento 备忘录角色
     * @author gdq
     * @since 2021/9/2
     */
    public void setMemento(Memento memento) {
        state = memento.getState();
    }

    /**
     * 展示
     *
     * @author gdq
     * @since 2021/9/2
     */
    public void show() {
        System.out.println("state = " + state);
    }
}
