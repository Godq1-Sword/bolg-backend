package org.gdq.learn.design.interpreter;

/**
 * 中介解释器
 *
 * @author gdq
 * @since 2021/8/26
 */
public class TerminalExpression implements Expression {

    private final String data;

    public TerminalExpression(String data) {
        this.data = data;
    }

    @Override
    public boolean interpret(String context) {
        return context.contains(data);
    }
}
