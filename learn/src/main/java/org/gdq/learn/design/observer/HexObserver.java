package org.gdq.learn.design.observer;

/**
 * HexObserver
 *
 * @author gdq
 * @since 2021/9/2
 */
public class HexObserver extends Observer {

    public HexObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Hex String: " + Integer.toHexString(subject.getState()).toUpperCase());
    }
}