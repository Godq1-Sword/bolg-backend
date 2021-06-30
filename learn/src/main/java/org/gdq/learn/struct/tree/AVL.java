package org.gdq.learn.struct.tree;

/**
 * AVL 树是一种平衡二叉树
 * 左右子树的高度差小于等于1
 * 其每一个子树均为平衡二叉树
 *
 * @author wb-gdq845533
 * @version : AVL.java, v 0.1 2021年06月30日 17:01 wb-gdq845533 Exp $
 */
public class AVL<T extends Comparable<T>> {

    // 根节点
    private TreeNode<T> root;

    public void add(T value) {
    }

    private TreeNode<T> add(T value, TreeNode<T> treeNode) {
        if (treeNode == null) {
            return new TreeNode<>(value);
        }
        int compareValue = value.compareTo(treeNode.getValue());
        if (compareValue < 0) treeNode.setLeftChild(add(value, treeNode.getLeftChild()));
        else if (compareValue > 0) treeNode.setRightChild(add(value, treeNode.getRightChild()));
        return treeNode;
    }

    private void balanceNode(TreeNode<T> treeNode) {
        int balanceFactor = getBalanceFactor(treeNode);
        TreeNode<T> leftChild = treeNode.getLeftChild();
        int leftChildBF = getBalanceFactor(leftChild);
        TreeNode<T> rightChild = treeNode.getRightChild();
        int rightChildBF = getBalanceFactor(rightChild);
        if (Math.abs(balanceFactor) <= 1) return;
        // LL
        if (balanceFactor > 1 && leftChildBF > 0) {
            rotateRight(treeNode);
        }
        // RR
        if (balanceFactor < -1 && rightChildBF < 0) {
            rotateRight(treeNode);
        }
        // LR
        if (balanceFactor > 1 && rightChildBF < 0) {
            treeNode.setRightChild(rotateLeft(leftChild));
        }
        // RL
        if (balanceFactor < -1 && leftChildBF > 0) {

        }
    }


    /**
     * 获取平衡因子(左节点高度 - 右节点高度)
     *
     * @param treeNode 根节点
     * @return int 平衡因子
     * @author gdq 2021/6/30
     */
    private int getBalanceFactor(TreeNode<T> treeNode) {
        if (treeNode == null) return 0;
        TreeNode<T> leftChild = treeNode.getLeftChild();
        TreeNode<T> rightChild = treeNode.getRightChild();
        return (leftChild == null ? 0 : leftChild.getHeight()) - (rightChild == null ? 0 : rightChild.getHeight());
    }

    /**
     * 节点右旋
     * A,B = A -> left
     * A B节点互换位置,同时 A -> right = B -> right
     *
     * @param treeNode 节点
     * @author gdq 2021/6/30
     */
    private void rotateRight(TreeNode<T> treeNode) {
        TreeNode<T> leftChild = treeNode.getLeftChild();
        TreeNode<T> lRT = leftChild.getRightChild();
        if (lRT != null) lRT.setParent(treeNode);
        treeNode.setRightChild(lRT);
        treeNode.setParent(leftChild);
        leftChild.setRightChild(treeNode);
        leftChild.setParent(treeNode.getParent());
        // 设置高度
        leftChild.setHeight(leftChild.getHeight());
        treeNode.setHeight(treeNode.getHeight());
    }

    /**
     * 节点左旋
     * A,B = A -> right
     * A B节点互换位置,同时 A -> left = B -> left
     *
     * @param treeNode 节点
     * @author gdq 2021/6/30
     */
    private TreeNode<T> rotateLeft(TreeNode<T> treeNode) {
        TreeNode<T> rightChild = treeNode.getRightChild();
        TreeNode<T> rLT = rightChild.getLeftChild();
        if (rLT != null) rLT.setParent(treeNode);
        treeNode.setLeftChild(rLT);
        treeNode.setParent(rightChild);
        rightChild.setLeftChild(treeNode);
        rightChild.setParent(treeNode.getParent());
        // 设置高度
        rightChild.setHeight(rightChild.getHeight());
        treeNode.setHeight(treeNode.getHeight());
        return rightChild;
    }
}
 