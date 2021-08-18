package org.gdq.learn.struct.tree;

/**
 * 红黑树
 * 1.每个节点或者是黑色,或者是红色
 * 2.根节点是黑色
 * 3.每个叶子节点是黑色[注意:这里叶子节点,是指为空的叶子节点]
 * 4.如果一个节点是红色的,则它的子节点必须是黑色的
 * 5.从一个节点到该节点的子孙节点的所有路径上包含相同数目的黑节点
 *
 * @author gdq
 * @since 2021/7/19
 */
public class RBT<T extends Comparable<T>> extends BST<T> {

    // 根节点
    private TreeNode<T> root;

    public RBT(T rootValue) {
        super(rootValue);
    }

    /**
     * 添加节点并返回
     *
     * @param rootValue 添加值
     * @return TreeNode 返回添加节点
     * @author gdq
     * @since 2021/7/19
     */
    public TreeNode<T> add(T rootValue) {
        TreeNode<T> treeNode = super.add(rootValue);
        treeNode.setRed(true);
        addFixup(treeNode);
        return treeNode;
    }

    /**
     * 添加节点后修正红黑树,并返回修正节点
     *
     * @param treeNode 修正节点
     * @author gdq
     * @since 2021/7/19
     */
    private void addFixup(TreeNode<T> treeNode) {
        // 1.根节点是黑色
        if (treeNode == root) {
            treeNode.setRed(false);
            return;
        }
        // 2.被插入的节点的父节点是黑色
        TreeNode<T> parent = treeNode.getParent();
        if (!parent.isRed()) { return; }
        // 3.被插入的节点的父节点是红色
        // 3-1.当前节点的祖父节点的另一个子节点(叔叔节点)也是红色
        TreeNode<T> grandFather = parent.getParent();
        boolean nodeIsLeft = parent.getLeftChild() == treeNode;
        TreeNode<T> uncle = parent == grandFather.getLeftChild() ? grandFather.getRightChild() : grandFather.getLeftChild();
        if (uncle != null && uncle.isRed()) {
            // 进行红黑转换 - 插入红 -> 父亲叔叔黑 -> 祖父红(循环祖父)
            parent.setRed(false);
            uncle.setRed(false);
            grandFather.setRed(true);
            addFixup(grandFather);
        }
        // 3-2.叔叔节点是黑色
        if (uncle == null || !uncle.isRed()) {
            if (nodeIsLeft) {
                // 3-2-1.插入节点是左节点,子节点和父亲节点都是黑色,先处理父亲节点F(黑)=>子树路径黑+1 -> 祖父节点变红色,父亲节点右旋上升
                grandFather.setRed(true);
                parent.setRed(false);
                rotateRight(grandFather);
            } else {
                // 3-2-2.插入节点是右节点,左旋上升红色节点,再处理左子节点(原父亲节点)
                rotateLeft(parent);
                addFixup(parent);
            }
        }
    }

    /**
     * 删除节点
     *
     * @param value 节点值
     * @author gdq
     * @since 2021/7/19
     */
    public void remove(T value) {
        TreeNode<T> deleteNode = findDeleteNode(value);
        // 删除节点
        TreeNode<T> currentNode = removeNode(deleteNode);
        // 红黑平衡修正
        if (!deleteNode.isRed()) {
            removeFixup(currentNode);
        }
    }

    /**
     * 删除节点后修正红黑树,并返回修正节点
     *
     * @param treeNode 修正节点
     * @author gdq
     * @since 2021/7/19
     */
    private void removeFixup(TreeNode<T> treeNode) {
        boolean thisIsRed = treeNode.isRed();
        // 当前节点是红色 => 变成黑色
        if (thisIsRed) {
            treeNode.setRed(false);
        } else {
            // 黑色根节点跳过
            if (treeNode != root) {
                TreeNode<T> parent = treeNode.getParent();
                TreeNode<T> brother = treeNode == parent.getLeftChild() ? parent.getRightChild() : parent.getLeftChild();
                boolean brotherIsRed = false;
                TreeNode<T> brotherLeftNode = null;
                TreeNode<T> brotherRightNode = null;
                boolean brotherLeftIsRed = false;
                boolean brotherRightIsRed = false;
                if (brother != null) {
                    brotherIsRed = brother.isRed();
                    brotherLeftNode = brother.getLeftChild();
                    brotherLeftIsRed = brotherLeftNode.isRed();
                    brotherRightNode = brother.getRightChild();
                    brotherRightIsRed = brotherRightNode.isRed();
                }
                // 1.兄弟节点为红色
                if (brotherIsRed) {
                    parent.setRed(true);
                    brother.setRed(false);
                    rotateLeft(parent);
                    removeFixup(brother);
                }
                // 2.兄弟节点是黑色,且兄弟节点的左右节点都是黑色
                if (!brotherIsRed && !brotherLeftIsRed && !brotherRightIsRed) {
                    if (brother != null) { brother.setRed(true); }
                    removeFixup(parent);
                }
                // 3.兄弟节点是黑色,且兄弟节点的左节点Red,右节点Black
                if (!brotherIsRed && brotherLeftIsRed && !brotherRightIsRed) {
                    brotherLeftNode.setRed(false);
                    brother.setRed(true);
                    rotateRight(brother);
                    removeFixup(brotherLeftNode);
                }
                // 4.兄弟节点是黑色,且兄弟节点的左节点Black,右节点Red
                if (!brotherIsRed && !brotherLeftIsRed && brotherRightIsRed) {
                    brother.setRed(parent.isRed());
                    parent.setRed(false);
                    brotherRightNode.setRed(false);
                    rotateLeft(parent);
                    root = treeNode;
                }
            }
        }
    }
}