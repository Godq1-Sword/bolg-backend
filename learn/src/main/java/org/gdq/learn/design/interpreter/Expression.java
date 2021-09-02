package org.gdq.learn.design.interpreter;

/**
 * 表达式接口
 *
 * @author gdq
 * @since 2021/8/26
 */
public interface Expression {
    /**
     * 说明
     *
     * @param context 文本
     * @return boolean true/false
     * @author gdq
     * @since 2021/8/26
     */
    boolean interpret(String context);
}
