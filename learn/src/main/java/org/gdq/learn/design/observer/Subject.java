package org.gdq.learn.design.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 主题
 *
 * @author gdq
 * @since 2021/9/2
 */
public class Subject {

    // 观察者
    private final List<Observer> observers = new ArrayList<>();

    // 状态
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    /**
     * 增加观察者
     *
     * @param observer 观察者
     * @author gdq
     * @since 2021/9/2
     */
    public void attach(Observer observer) {
        observers.add(observer);
    }

    /**
     * 通知所有观察者
     *
     * @author gdq
     * @since 2021/9/2
     */
    public void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
