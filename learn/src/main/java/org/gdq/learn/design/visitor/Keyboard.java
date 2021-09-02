package org.gdq.learn.design.visitor;

/**
 * Keyboard
 *
 * @author gdq
 * @since 2021/9/2
 */
public class Keyboard implements ComputerPart {

    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}
