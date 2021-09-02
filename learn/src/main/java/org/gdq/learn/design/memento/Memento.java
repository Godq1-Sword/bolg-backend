package org.gdq.learn.design.memento;

/**
 * 备忘录角色
 *
 * @author gdq
 * @since 2021/9/2
 */
public class Memento {

    // 状态
    private final String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

}
