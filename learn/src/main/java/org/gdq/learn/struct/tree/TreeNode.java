package org.gdq.learn.struct.tree;

import lombok.*;

/**
 * @author gdq
 * date 2020/9/10
 * 二叉树节点
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
    // 高度
    private int height;

    /**
     * 构造方法
     *
     * @param value 节点值
     * @author gdq 2021/6/30
     */
    public TreeNode(T value) {
        this.value = value;
        this.height = 1;
    }

    /**
     * 是否存在左节点
     *
     * @return boolean 是否存在
     * @author gdq 2021/6/30
     */
    public boolean hasLeftChild() {
        return leftChild != null;
    }

    /**
     * 是否存在右节点
     *
     * @return boolean 是否存在
     * @author gdq 2021/6/30
     */
    public boolean hasRightChild() {
        return rightChild != null;
    }

    /**
     * 获取当前节点高度
     *
     * @author gdq 2021/6/30
     */
    public void initHeight() {
        this.height = getHeight(this);
    }

    /**
     * 获取节点高度
     *
     * @param treeNode 节点
     * @return int 高度
     * @author gdq 2021/6/30
     */
    private int getHeight(TreeNode<T> treeNode) {
        if (treeNode == null) return 0;
        return Math.max(getHeight(treeNode.getLeftChild()), getHeight(treeNode.getRightChild())) + 1;
    }

    /**
     * 替换节点为  - 左子树最大值
     * @author gdq 2021/7/5
     */
    public void swapMaxLeftNode() {
        TreeNode<T> root = this;
        TreeNode<T> leftChild = root.getLeftChild();
        TreeNode<T> rightChild = root.getRightChild();
        root = leftChild;
        while (root.hasRightChild()) {
            root = root.getRightChild();
        }
        root.setLeftChild(leftChild);
        root.setRightChild(rightChild);
        leftChild.setParent(root);
        rightChild.setParent(root);
        root.getParent().setRightChild(null);
        root.setParent(parent);
    }

}