package org.gdq.learn.struct.tree;

import lombok.val;

/**
 * @author gdq
 * date 2020/9/10
 * 二叉查找树BST(左小,右大)
 */
public class BST<T extends Comparable<T>> {

    private TreeNode<T> root;

    public BST(T rootValue) {
        this.root = new TreeNode<>(rootValue);
    }

    /**
     * 新增节点 - 找到合适的位置插入
     *
     * @param value 节点值
     * @author gdq 2021/6/29
     */
    public void add(T value) {
        TreeNode<T> treeNode = new TreeNode<>(value);
        // root为空
        if (root == null) {
            root = treeNode;
            return;
        }
        TreeNode<T> currentNode = root;
        while (true) {
            T currentValue = currentNode.getValue();
            int compareValue = value.compareTo(currentValue);
            // 等于根节点 - 跳出
            if (compareValue == 0) break;
            // 判断节点位置
            boolean isLeft = compareValue < 0;
            TreeNode<T> childNode = isLeft ? currentNode.getLeftChild() : currentNode.getRightChild();
            // 循环遍历
            if (childNode != null) {
                currentNode = childNode;
                continue;
            }
            // 左/右节点为空,直接插入
            if (isLeft) {
                currentNode.setLeftChild(treeNode);
            } else {
                currentNode.setRightChild(treeNode);
            }
            treeNode.setParent(currentNode);
            break;
        }
    }

    /**
     * 删除节点 - 找到相应位置删除维护关系
     *
     * @param value 节点值
     * @author gdq 2021/6/29
     */
    public void remove(T value) {
        if (root == null || root.getValue().compareTo(value) == 0) {
            root = null;
            return;
        }
        // 找到删除节点,记录相关信息
        TreeNode<T> currentNode = root;
        TreeNode<T> deleteNode = null;
        boolean isLeft = false;
        while (true) {
            T currentValue = currentNode.getValue();
            if (value.compareTo(currentValue) == 0) {
                deleteNode = currentNode;
                break;
            }
            isLeft = value.compareTo(currentValue) < 0;
            currentNode = isLeft ? currentNode.getLeftChild() : currentNode.getRightChild();
            if (currentNode == null) break;
        }
        // 存在删除节点,进行删除操作
        if (deleteNode != null) {
            boolean hasLeftChild = deleteNode.getLeftChild() != null;
            boolean hasRightChild = deleteNode.getRightChild() != null;
            // 1.叶子节点
            if (!hasLeftChild && !hasRightChild) {
                if (isLeft) deleteNode.getParent().setLeftChild(null);
                else deleteNode.getParent().setRightChild(null);
            }
        }
    }
}
