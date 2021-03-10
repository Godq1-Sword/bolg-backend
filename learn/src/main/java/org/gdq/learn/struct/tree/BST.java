package org.gdq.learn.struct.tree;

import java.util.Scanner;

/**
 * @author gdq
 * date 2020/9/10
 * description 二叉查找树BST(左小,右大)
 */
public class BST {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			TreeNode bst = new TreeNode(scanner.nextInt(), null);
			for (int i = 1; i < n; i++) {
				add(scanner.nextInt(), bst);
			}
			TreeNode.PreTraver(bst);
			System.out.println();
			int removeA = scanner.nextInt();
			remove(removeA, bst);
			TreeNode.PreTraver(bst);
		}
	}

	// 新增
	private static void add(int a, TreeNode treeNode) {
		// 小于节点
		if (a < treeNode.getValue()) {
			if (treeNode.getLeftChild() == null) {
				treeNode.setLeftChild(new TreeNode(a, treeNode));
			} else {
				add(a, treeNode.getLeftChild());
			}
		} else {
			if (treeNode.getRightChild() == null) {
				treeNode.setRightChild(new TreeNode(a, treeNode));
			} else {
				add(a, treeNode.getRightChild());
			}
		}
	}

	// 删除
	private static void remove(int a, TreeNode treeNode) {
		// 确认节点
		System.out.println(treeNode.getValue());
		if (a == treeNode.getValue()) {
			TreeNode root = treeNode.getRoot();
			// 存在左节点
			boolean eLC = treeNode.getLeftChild() == null;
			// 存在右节点
			boolean eRC = treeNode.getRightChild() == null;
			// 当前节点是左节点
			boolean eRL = root.getLeftChild() != null && a == root.getLeftChild().getValue();
			// 无子节点
			if (eLC && eRC) {
				// 断左
				if (eRL) {
					root.setLeftChild(null);
					// 断右
				} else {
					root.setRightChild(null);
				}
				treeNode.setRoot(null);
			}
			// Y左节点 / N右节点
			else if (!eLC && eRC) {
				TreeNode lC = treeNode.getLeftChild();
				treeNode.setRoot(null);
				treeNode.setLeftChild(null);
				if (eRL) {
					root.setLeftChild(lC);
				} else {
					root.setRightChild(lC);
				}
				// N左节点 / Y右节点
			} else if (eLC) {
				TreeNode rC = treeNode.getRightChild();
				treeNode.setRoot(null);
				treeNode.setRightChild(null);
				if (eRL) {
					root.setLeftChild(rC);
				} else {
					root.setRightChild(rC);
				}
				// Y左/右节点
			} else {
				// 交换并删除右子树最小节点(保持中序遍历不变)
				TreeNode minNode = searchMinNode(treeNode.getRightChild());
				treeNode.setValue(minNode.getValue());
				TreeNode minRootNode = minNode.getRoot();
				if (minRootNode.getLeftChild() != null && minNode.getValue() == minRootNode.getLeftChild().getValue()) {
					minRootNode.setLeftChild(null);
				} else {
					minRootNode.setRightChild(null);
				}
				minNode.setRoot(null);
			}
		} else if (treeNode.getLeftChild() != null && a < treeNode.getValue()) {
			remove(a, treeNode.getLeftChild());
		} else {
			remove(a, treeNode.getRightChild());
		}
	}

	private static TreeNode searchMinNode(TreeNode treeNode) {
		if (treeNode.getLeftChild() != null) {
			return searchMinNode(treeNode.getLeftChild());
		} else {
			return treeNode;
		}
	}
}
