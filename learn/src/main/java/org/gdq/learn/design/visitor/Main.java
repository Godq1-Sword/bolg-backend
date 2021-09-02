package org.gdq.learn.design.visitor;

/**
 * 访问者模式[Main]
 *
 * @author gdq
 * @since 2021/9/2
 */
public class Main {
    public static void main(String[] args) {
        ComputerPart mouse = new Mouse();
        mouse.accept(new ComputerPartDisplayVisitor());
    }
}
