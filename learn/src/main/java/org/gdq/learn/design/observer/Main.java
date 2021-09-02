package org.gdq.learn.design.observer;

/**
 * 观察者模式[Main]
 *
 * @author gdq
 * @since 2021/9/2
 */
public class Main {
    public static void main(String[] args) {
        Subject subject = new Subject();
        new HexObserver(subject);
        new OctalObserver(subject);
        new BinaryObserver(subject);
        System.out.println("First state change: 15");
        subject.setState(15);
        System.out.println("Second state change: 10");
        subject.setState(10);
    }
}
