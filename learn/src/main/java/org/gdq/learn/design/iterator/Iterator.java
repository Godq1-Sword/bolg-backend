package org.gdq.learn.design.iterator;

/**
 * 迭代器接口
 *
 * @author gdq
 * @since 2021/8/30
 */
public interface Iterator {

    /**
     * 是否存在下一个遍历对象
     *
     * @return boolean 是/否
     * @author gdq
     * @since 2021/8/30
     */
    boolean hasNext();

    /**
     * 获取下一个遍历对象
     *
     * @return Object 对象
     * @author gdq
     * @since 2021/8/30
     */
    Object next();
}
