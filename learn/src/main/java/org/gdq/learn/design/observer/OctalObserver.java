package org.gdq.learn.design.observer;

/**
 * OctalObserver
 *
 * @author gdq
 * @since 2021/9/2
 */
public class OctalObserver extends Observer {

    public OctalObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Octal String: " + Integer.toOctalString(subject.getState()));
    }
}
