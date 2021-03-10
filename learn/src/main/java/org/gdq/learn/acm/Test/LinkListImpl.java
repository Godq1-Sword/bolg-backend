package org.gdq.learn.acm.Test;

import java.util.List;

/**
 * @author gdq
 * date
 * description
 */
public class LinkListImpl implements LinkList {
	private Node[] nodes;
	private int length;

	@Override
	public boolean isExists(Integer value) {
		// 空数组
		if (nodes == null) {
			return false;
		}
		// 遍历
		for (Node node : nodes) {
			if (value.equals(node.getValue()))
				return true;
		}
		return false;
	}

	@Override
	public void add(Node node) {
		// 初始化
		if (nodes == null || nodes.length <= 0) {
			nodes = new Node[16];
			length = 0;
		}
		// 扩容
		if (length > nodes.length - 1) {
			Node[] tempNodes = new Node[nodes.length * 2];
			System.arraycopy(nodes, 0, tempNodes, 0, nodes.length);
			tempNodes[length++] = node;
			this.nodes = tempNodes;
		} else {
			// 添加
			nodes[length++] = node;
		}
	}
}
