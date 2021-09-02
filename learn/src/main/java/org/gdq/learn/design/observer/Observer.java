package org.gdq.learn.design.observer;

/**
 * 观察者
 *
 * @author gdq
 * @since 2021/9/2
 */
public abstract class Observer {

    // 主题
    protected Subject subject;

    /**
     * 更新
     *
     * @author gdq
     * @since 2021/9/2
     */
    public abstract void update();
}
