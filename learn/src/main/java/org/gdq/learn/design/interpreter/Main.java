package org.gdq.learn.design.interpreter;

/**
 * 解释器模式[Main]
 *
 * @author gdq
 * @since 2021/8/26
 */
public class Main {
    public static void main(String[] args) {
        Expression john = new TerminalExpression("John");
        Expression robert = new TerminalExpression("Robert");
        Expression age = new TerminalExpression("18");
        final OrExpression orExpression = new OrExpression(robert, john);
        final AndExpression andExpression = new AndExpression(robert, age);
        System.out.println("Exist John? " + orExpression.interpret("John"));
        System.out.println("Robert is male and 17 old? " + andExpression.interpret("Robert 17"));
    }
}
