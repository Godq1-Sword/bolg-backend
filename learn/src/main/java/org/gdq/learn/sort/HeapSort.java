package org.gdq.learn.sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author gdq
 * date 2020/9/8
 * description 堆排序
 */
public class HeapSort {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = scanner.nextInt();
			}
			heapSort(a);
			System.out.println(Arrays.toString(a));
		}
	}

	private static void buildHeap(int[] a, int root, int len) {
		int lChild = root * 2 + 1;
		int rChild = lChild + 1;
		int bigIndex = root;
		// 左节点
		if (lChild < len && a[lChild] > a[bigIndex]) {
			bigIndex = lChild;
		}
		// 右节点
		if (rChild < len && a[rChild] > a[bigIndex]) {
			bigIndex = rChild;
		}
		// swap
		if (bigIndex != root) {
			a[root] ^= a[bigIndex];
			a[bigIndex] ^= a[root];
			a[root] ^= a[bigIndex];
			buildHeap(a, bigIndex, len);
		}
	}

	private static void heapSort(int[] a) {
		// 递归构建 - 最后一个非叶子节点开始
		for (int i = a.length / 2; i >= 0; i--) {
			buildHeap(a, i, a.length);
		}
		// 每次剔除大顶堆顶部 a[0]
		int len = a.length;
		for (int i = a.length - 1; i > 0; i--) {
			a[0] ^= a[i];
			a[i] ^= a[0];
			a[0] ^= a[i];
			buildHeap(a, 0, --len);
		}
	}
}
