package org.gdq.learn.design.visitor;

/**
 * 计算机部分
 *
 * @author gdq
 * @since 2021/9/2
 */
public interface ComputerPart {
    /**
     * 接受
     *
     * @param computerPartVisitor 计算机部分访问者
     * @author gdq
     * @since 2021/9/2
     */
    void accept(ComputerPartVisitor computerPartVisitor);
}
