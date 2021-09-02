package org.gdq.learn.design.visitor;

/**
 * 访问者接口
 *
 * @author gdq
 * @since 2021/9/2
 */
public interface ComputerPartVisitor {
    /**
     * 访问mouse
     *
     * @param mouse 鼠标
     * @author gdq
     * @since 2021/9/2
     */
    void visit(Mouse mouse);

    /**
     * 访问keyboard
     *
     * @param keyboard 键盘
     * @author gdq
     * @since 2021/9/2
     */
    void visit(Keyboard keyboard);
}
