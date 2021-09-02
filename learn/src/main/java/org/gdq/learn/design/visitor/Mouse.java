package org.gdq.learn.design.visitor;

/**
 * Mouse
 *
 * @author gdq
 * @since 2021/9/2
 */
public class Mouse implements ComputerPart {
    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}