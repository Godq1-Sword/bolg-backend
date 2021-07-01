package org.gdq.learn.struct.tree;

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
     * 新增节点 - 找到合适的位置插入 * * @param value 节点值 * @author gdq 2021/6/29
     */
    public void add(T value) {
        TreeNode<T> treeNode = new TreeNode<>(value); // root为空
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
        // root为空 / 删除root
        if (root == null) {
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
        boolean isRoot = deleteNode == root;
        // 存在删除节点,进行删除操作
        if (deleteNode != null) {
            boolean hasLeftChild = deleteNode.hasLeftChild();
            boolean hasRightChild = deleteNode.hasRightChild();
            TreeNode<T> parent = deleteNode.getParent();
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
                TreeNode<T> leftChild = deleteNode.getLeftChild();
                TreeNode<T> rightChild = deleteNode.getRightChild();
                deleteNode = deleteNode.getLeftChild();
                while (deleteNode.hasRightChild()) {
                    deleteNode = deleteNode.getRightChild();
                }
                deleteNode.setLeftChild(leftChild);
                deleteNode.setRightChild(rightChild);
                leftChild.setParent(deleteNode);
                rightChild.setParent(deleteNode);
                deleteNode.getParent().setRightChild(null);
                deleteNode.setParent(parent);
            }
            // 设置父子关系
            if (!isRoot) {
                if (isLeft) parent.setLeftChild(deleteNode);
                else parent.setRightChild(deleteNode);
            } else {
                root = deleteNode;
            }
        }
    }

    /**
     * 前置遍历 - 1.根节点 2.左节点 3.右节点 * * @param treeNode 节点 * @author gdq 2021/6/29
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
     * 中置遍历 - 1.左节点 2.根节点 3.右节点 * * @param treeNode 节点 * @author gdq 2021/6/29
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
     * 后置遍历 - 1.左节点 2.右节点 3.根节点 * * @param treeNode 节点 * @author gdq 2021/6/29
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