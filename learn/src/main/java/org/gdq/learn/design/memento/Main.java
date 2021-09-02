package org.gdq.learn.design.memento;

/**
 * 备忘录模式[Main]
 *
 * @author gdq
 * @since 2021/9/2
 */
public class Main {
    public static void main(String[] args) {
        Originator originator = new Originator();
        // Originator初始状态
        originator.setState("On");
        originator.show();
        Caretaker caretaker = new Caretaker();
        caretaker.setMemento(originator.createMemento());
        // Originator状态变为Off
        originator.setState("Off");
        originator.show();
        // 回复初始状态
        originator.setMemento(caretaker.getMemento());
        originator.show();
    }
}
