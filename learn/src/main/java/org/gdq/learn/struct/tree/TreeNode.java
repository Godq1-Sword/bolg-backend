package org.gdq.learn.struct.tree;

import lombok.Data;

/**
 * @author gdq
 * date 2020/9/10
 * description 树结构体
 */
public class TreeNode {
	// 节点大小
	private int value;
	// 左节点
	private TreeNode leftChild;
	// 右节点
	private TreeNode rightChild;
	// 父节点
	private TreeNode root;

	public TreeNode(int value, TreeNode root) {
		this.value = value;
		this.root = root;
	}

	public TreeNode() {
	}

	public static void PreTraver(TreeNode treeNode) {
		System.out.print(treeNode.value + " ");
		if (treeNode.leftChild != null) {
			PreTraver(treeNode.leftChild);
		}
		if (treeNode.rightChild != null) {
			PreTraver(treeNode.rightChild);
		}
	}

	public static void MidTraver(TreeNode treeNode) {
		if (treeNode.leftChild != null) {
			PreTraver(treeNode.leftChild);
		}
		System.out.println(treeNode.value);
		if (treeNode.rightChild != null) {
			PreTraver(treeNode.rightChild);
		}
	}

	public static void BehTraver(TreeNode treeNode) {
		if (treeNode.leftChild != null) {
			PreTraver(treeNode.leftChild);
		}
		System.out.println(treeNode.value);
		if (treeNode.rightChild != null) {
			PreTraver(treeNode.rightChild);
		}
	}

	public void setLeftChild(TreeNode leftChild) {
		this.leftChild = leftChild;
	}

	public void setRightChild(TreeNode rightChild) {
		this.rightChild = rightChild;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public TreeNode getLeftChild() {
		return leftChild;
	}

	public TreeNode getRightChild() {
		return rightChild;
	}

	public TreeNode getRoot() {
		return root;
	}
}
