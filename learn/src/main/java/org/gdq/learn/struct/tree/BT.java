package org.gdq.learn.struct.tree;

/**
 * @author wb-gdq845533
 * @version : BT.java, v 0.1 2021年07月12日 14:28 wb-gdq845533 Exp $
 */
public class BT<T extends Comparable<T>> {

    // 根节点
    private TreeNode<T> root;

    /**
     * 节点右旋
     * A,B = A -> left
     * A B节点互换位置,同时 A -> right = B -> right
     *
     * @param treeNode 节点
     * @author gdq 2021/6/30
     */
    protected void rotateRight(TreeNode<T> treeNode) {
        TreeNode<T> leftChild = treeNode.getLeftChild();
        // leftChild右节点迁移 = treeNode->left
        TreeNode<T> lRT = leftChild.getRightChild();
        if (lRT != null) { lRT.setParent(treeNode); }
        treeNode.setLeftChild(lRT);
        // root<=>leftChild节点互换
        leftChild.setParent(treeNode.getParent());
        treeNode.setParent(leftChild);
        leftChild.setRightChild(treeNode);
        // 设置高度
        leftChild.initHeight();
        treeNode.initHeight();
    }

    /**
     * 节点左旋
     * A,B = A -> right
     * A B节点互换位置,同时 A -> left = B -> left
     *
     * @param treeNode 节点
     * @author gdq 2021/6/30
     */
    protected void rotateLeft(TreeNode<T> treeNode) {
        TreeNode<T> rightChild = treeNode.getRightChild();
        // rightChild左节点迁移 = treeNode->left
        TreeNode<T> rLT = rightChild.getLeftChild();
        if (rLT != null) { rLT.setParent(treeNode); }
        treeNode.setRightChild(rLT);
        // root<=>rightChild节点互换
        rightChild.setParent(treeNode.getParent());
        treeNode.setParent(rightChild);
        rightChild.setLeftChild(treeNode);
        // 设置高度
        rightChild.initHeight();
        treeNode.initHeight();
    }

    /**
     * 前置遍历 - 1.根节点 2.左节点 3.右节点
     *
     * @param treeNode 节点
     * @author gdq 2021/6/29
     */
    public void PreTraver(TreeNode<T> treeNode) {
        System.out.println(treeNode.getValue());
        if (treeNode.hasLeftChild()) {
            PreTraver(treeNode.getLeftChild());
        }
        if (treeNode.hasRightChild()) {
            PreTraver(treeNode.getRightChild());
        }
    }

    /**
     * 中置遍历 - 1.左节点 2.根节点 3.右节点
     *
     * @param treeNode 节点
     * @author gdq 2021/6/29
     */
    public void MidTraver(TreeNode<T> treeNode) {
        if (treeNode.hasLeftChild()) {
            MidTraver(treeNode.getLeftChild());
        }
        System.out.println(treeNode.getValue());
        if (treeNode.hasRightChild()) {
            MidTraver(treeNode.getRightChild());
        }
    }

    /**
     * 后置遍历 - 1.左节点 2.右节点 3.根节点
     *
     * @param treeNode 节点
     * @author gdq 2021/6/29
     */
    public void BehTraver(TreeNode<T> treeNode) {
        if (treeNode.hasLeftChild()) {
            BehTraver(treeNode.getLeftChild());
        }
        if (treeNode.hasRightChild()) {
            BehTraver(treeNode.getRightChild());
        }
        System.out.println(treeNode.getValue());
    }
}