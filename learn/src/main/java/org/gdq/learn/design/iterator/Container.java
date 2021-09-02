package org.gdq.learn.design.iterator;

/**
 * 容器
 *
 * @author gdq
 * @since 2021/8/30
 */
public interface Container {

    /**
     * 获取迭代器
     *
     * @return Iterator 迭代器
     * @author gdq
     * @since 2021/8/30
     */
    Iterator getIterator();
}
