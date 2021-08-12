package org.gdq.learn.struct.tree;

import com.sun.source.tree.Tree;

/**
 * @author gdq
 * date 2020/9/10
 * 二叉查找树BST(左小,右大)
 */
public class BST<T extends Comparable<T>> extends BT<T> {

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
    public TreeNode<T> add(T value) {
        TreeNode<T> treeNode = new TreeNode<>(value);
        // root为空
        if (root == null) {
            root = treeNode;
            return treeNode;
        }
        TreeNode<T> currentNode = root;
        while (true) {
            T currentValue = currentNode.getValue();
            int compareValue = value.compareTo(currentValue);
            // 等于根节点 - 跳出
            if (compareValue == 0) { break; }
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
        return treeNode;
    }

    /**
     * 删除节点 - 找到相应位置删除维护关系
     *
     * @param value 节点值
     * @author gdq 2021/6/29
     */
    public void remove(T value) {
        // root为空
        if (root == null) {
            return;
        }
        // 查找删除节点
        TreeNode<T> deleteNode = findDeleteNode(value);
        if (deleteNode == null) { return; }
        if (deleteNode == root) {
            root = null;
            return;
        }
        removeNode(deleteNode);
    }

    protected TreeNode<T> findDeleteNode(T value) {
        // 找到删除节点,记录相关信息
        TreeNode<T> currentNode = root;
        TreeNode<T> deleteNode = null;
        while (true) {
            T currentValue = currentNode.getValue();
            if (value.compareTo(currentValue) == 0) {
                deleteNode = currentNode;
                break;
            }
            currentNode = value.compareTo(currentValue) < 0 ? currentNode.getLeftChild() : currentNode.getRightChild();
            if (currentNode == null) { break; }
        }
        return deleteNode;
    }

    /**
     * 删除节点,返回删除后该位置的节点
     *
     * @param deleteNode 要删除的节点
     * @return TreeNode 删除后该位置节点
     */
    protected TreeNode<T> removeNode(TreeNode<T> deleteNode) {
        // 存在删除节点,进行删除操作
        boolean hasLeftChild = deleteNode.hasLeftChild();
        boolean hasRightChild = deleteNode.hasRightChild();
        TreeNode<T> parent = deleteNode.getParent();
        boolean isLeft = parent.getLeftChild() == deleteNode;
        // 1.叶子节点 - 置空
        if (!hasLeftChild && !hasRightChild) {
            deleteNode = null;
        } else if (!hasLeftChild) {// 2.无左节点
            deleteNode = deleteNode.getRightChild();
            deleteNode.setParent(parent);
        } else if (!hasRightChild) {// 3.无右节点
            deleteNode = deleteNode.getLeftChild();
            deleteNode.setParent(parent);
        } else {// 4.左右节点都存在 - 查找左子树最大值替换
            deleteNode.swapMaxLeftNode();
        }
        // 设置父子关系
        if (isLeft) { parent.setLeftChild(deleteNode); } else { parent.setRightChild(deleteNode); }
        return deleteNode;
    }
}