package org.gdq.learn.struct.tree;

/**
 * @author gdq
 * date 2020/9/15
 * description 二叉查找平衡树
 */
public class AVL extends TreeNode {

	// 调正平衡LL
	private void adjLL(TreeNode node) {

	}

	// 左侧高度
	private int getLeftHeight(TreeNode node) {
		int height = 0;
		while (node.getLeftChild() != null) {
			height++;
			node = node.getLeftChild();
		}
		return height;
	}

	// 右侧高度
	private int getRightHeight(TreeNode node) {
		int height = 0;
		while (node.getRightChild() != null) {
			height++;
			node = node.getRightChild();
		}
		return height;
	}

	// 节点是否平衡
	private boolean checkBlanceStatus(TreeNode node) {
		return Math.abs(getBlanceFactor(node)) <= 1;
	}

	// 节点平衡因子
	private int getBlanceFactor(TreeNode node) {
		return getLeftHeight(node) - getRightHeight(node);
	}
}
