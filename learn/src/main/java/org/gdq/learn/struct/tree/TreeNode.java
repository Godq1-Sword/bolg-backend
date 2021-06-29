package org.gdq.learn.struct.tree;

import lombok.*;

/**
 * @author gdq
 * date 2020/9/10
 * 树节点
 */
@Getter
@Setter
public class TreeNode<T extends Comparable<T>> {
    // 节点大小
    private T value;
    // 左节点
    private TreeNode<T> leftChild;
    // 右节点
    private TreeNode<T> rightChild;
    // 父节点
    private TreeNode<T> parent;

    /**
     * 构造方法
     *
     * @param value 节点值
     * @author gdq
     */
    public TreeNode(T value) {
        this.value = value;
    }

    /**
     * 前置遍历 - 1.根节点 2.左节点 3.右节点
     *
     * @param treeNode 节点
     * @author gdq 2021/6/29
     */
    public void PreTraver(TreeNode<T> treeNode) {
        System.out.println(treeNode.value);
        if (treeNode.leftChild != null) {
            PreTraver(treeNode.leftChild);
        }
        if (treeNode.rightChild != null) {
            PreTraver(treeNode.rightChild);
        }
    }

    /**
     * 中置遍历 - 1.左节点 2.根节点 3.右节点
     *
     * @param treeNode 节点
     * @author gdq 2021/6/29
     */
    public void MidTraver(TreeNode<T> treeNode) {
        if (treeNode.leftChild != null) {
            MidTraver(treeNode.leftChild);
        }
        System.out.println(treeNode.value);
        if (treeNode.rightChild != null) {
            MidTraver(treeNode.rightChild);
        }
    }

    /**
     * 后置遍历 - 1.左节点 2.右节点 3.根节点
     *
     * @param treeNode 节点
     * @author gdq 2021/6/29
     */
    public void BehTraver(TreeNode<T> treeNode) {
        if (treeNode.leftChild != null) {
            BehTraver(treeNode.leftChild);
        }
        System.out.println(treeNode.value);
        if (treeNode.rightChild != null) {
            BehTraver(treeNode.rightChild);
        }
    }
}
