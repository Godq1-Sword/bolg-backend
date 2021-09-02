package org.gdq.learn.design.mediator;

/**
 * 中介者模式[Main]
 *
 * @author gdq
 * @since 2021/9/2
 */
public class Main {
    public static void main(String[] args) {
        User robert = new User("Robert");
        User john = new User("John");
        robert.sendMessage("Hi! John!");
        john.sendMessage("Hello! Robert!");
    }
}
