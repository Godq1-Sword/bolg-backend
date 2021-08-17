package org.gdq.learn.design.composite;

import lombok.*;

/**
 * 例子实例
 *
 * @author gdq
 * @since 2021/8/17
 */
@Setter
public class Node {
    // 父节点
    private Node parent;

    @Override
    public String toString() {
        return "this:" + this.hashCode() + ",parent:" + parent.hashCode();
    }
}
