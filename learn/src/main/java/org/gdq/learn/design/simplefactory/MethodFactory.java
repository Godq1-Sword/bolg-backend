package org.gdq.learn.design.simplefactory;

/**
 * 方法工厂
 *
 * @author gdq
 * date 2021/3/16
 */
public interface MethodFactory {
    /**
     * 创建图形
     *
     * @return Shape 图形
     * @author gdq
     */
    Shape create();
}
