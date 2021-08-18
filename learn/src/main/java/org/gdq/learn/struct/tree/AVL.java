package org.gdq.learn.struct.tree;

/**
 * AVL 树是一种平衡二叉树
 * 左右子树的高度差小于等于1
 * 其每一个子树均为平衡二叉树
 *
 * @author gdq
 * @since 2021/8/18
 */
public class AVL<T extends Comparable<T>> extends BT<T> {

    // 根节点
    private TreeNode<T> root;

    public AVL(T value) {
        root = new TreeNode<>(value);
    }

    public void remove(T value) {
        root = remove(value, root);
    }

    private TreeNode<T> remove(T value, TreeNode<T> treeNode) {
        if (treeNode == null) { return null; }
        // 替换的节点
        TreeNode<T> replaceNode = treeNode;
        TreeNode<T> leftChild = treeNode.getLeftChild();
        TreeNode<T> rightChild = treeNode.getRightChild();
        TreeNode<T> parent = treeNode.getParent();
        int compareValue = value.compareTo(treeNode.getValue());
        if (compareValue < 0) {
            treeNode.setLeftChild(remove(value, leftChild));
        } else if (compareValue > 0) {
            treeNode.setRightChild(remove(value, rightChild));
        } else {
            // 叶子节点
            if (leftChild == null && rightChild == null) {
                return null;
            }
            // 左节点为空
            if (leftChild == null) {
                replaceNode = rightChild;
                replaceNode.setParent(parent);
            } else if (rightChild == null) {// 右节点为空
                replaceNode = leftChild;
                replaceNode.setParent(parent);
            } else {// 左右节点不为空,找左子树最大值替换
                replaceNode.swapMaxLeftNode();
            }
        }
        replaceNode.initHeight();
        balanceNode(treeNode);
        return replaceNode;
    }

    /**
     * 插入节点
     *
     * @author gdq 2021/6/30
     */
    public void add(T value) {
        root = add(value, root);
    }

    /**
     * 插入节点 - 递归
     *
     * @return boolean 是否存在
     * @author gdq 2021/6/30
     */
    private TreeNode<T> add(T value, TreeNode<T> treeNode) {
        if (treeNode == null) {
            return new TreeNode<>(value);
        }
        int compareValue = value.compareTo(treeNode.getValue());
        if (compareValue < 0) {
            TreeNode<T> leftChild = add(value, treeNode.getLeftChild());
            treeNode.setLeftChild(leftChild);
            leftChild.setParent(treeNode);
        } else if (compareValue > 0) {
            TreeNode<T> rightChild = add(value, treeNode.getRightChild());
            treeNode.setRightChild(rightChild);
            rightChild.setParent(treeNode);
        }
        // 设置高度
        treeNode.initHeight();
        // 平衡节点
        return balanceNode(treeNode);
    }

    /**
     * 平衡节点 - 四种情况LL/LR/RR/RL
     *
     * @return boolean 是否存在
     * @author gdq 2021/6/30
     */
    private TreeNode<T> balanceNode(TreeNode<T> treeNode) {
        int balanceFactor = getBalanceFactor(treeNode);
        TreeNode<T> leftChild = treeNode.getLeftChild();
        int leftChildBF = getBalanceFactor(leftChild);
        TreeNode<T> rightChild = treeNode.getRightChild();
        int rightChildBF = getBalanceFactor(rightChild);
        if (Math.abs(balanceFactor) <= 1) { return treeNode; }
        // LL
        if (balanceFactor > 1 && leftChildBF > 0) {
            rotateRight(treeNode);
            return treeNode.getLeftChild();
        }
        // RR
        if (balanceFactor < -1 && rightChildBF < 0) {
            rotateLeft(treeNode);
            return treeNode.getRightChild();
        }
        // LR
        if (balanceFactor > 1 && leftChildBF < 0) {
            rotateLeft(leftChild);
            TreeNode<T> rotateNode = leftChild.getRightChild();
            treeNode.setLeftChild(rotateNode);
            rotateNode.setParent(treeNode);
            rotateRight(treeNode);
            return treeNode.getLeftChild();
        }
        // RL
        if (balanceFactor < -1 && rightChildBF > 0) {
            rotateRight(rightChild);
            TreeNode<T> rotateNode = rightChild.getLeftChild();
            treeNode.setRightChild(rotateNode);
            rotateNode.setParent(treeNode);
            rotateLeft(treeNode);
            return treeNode.getRightChild();
        }
        return treeNode;
    }

    /**
     * 获取平衡因子(左节点高度 - 右节点高度)
     *
     * @param treeNode 根节点
     * @return int 平衡因子
     * @author gdq 2021/6/30
     */
    private int getBalanceFactor(TreeNode<T> treeNode) {
        if (treeNode == null) { return 0; }
        TreeNode<T> leftChild = treeNode.getLeftChild();
        TreeNode<T> rightChild = treeNode.getRightChild();
        return (leftChild == null ? 0 : leftChild.getHeight()) - (rightChild == null ? 0 : rightChild.getHeight());
    }
}
 