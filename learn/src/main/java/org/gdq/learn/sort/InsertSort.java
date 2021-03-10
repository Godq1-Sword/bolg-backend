package org.gdq.learn.sort;

import java.util.Scanner;

/**
 * @author gdq
 * date 2020/9/2
 * description 直接插入排序  O(n^2)
 */
public class InsertSort {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = scanner.nextInt();
			}
			insertSort(a);
			halfInsertSort(a);
			for (int j : a) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}

	private static void insertSort(int[] a) {
		// 待扫描数组
		for (int i = 1; i < a.length; i++) {
			// 元素小于前置位
			if (a[i] < a[i - 1]) {
				int temp = a[i], j = i - 1;
				// 遍历前置位 - 整体向后移动
				for (; j >= 0 && temp < a[j]; j--) {
					a[j + 1] = a[j];
				}
				a[j + 1] = temp;
			}
		}
	}

	private static void halfInsertSort(int[] a) {
		// 待扫描数组
		for (int i = 1; i < a.length; i++) {
			// 元素小于前置位
			if (a[i] < a[i - 1]) {
				int temp = a[i];
				// 二分找到合适位置  - 整体向后移动
				int left = 0, right = i - 1, mid = 0;
				if (temp < a[0]) {
					right = 0;
				} else {
					while (right - left > 1) {
						mid = (left + right) / 2;
						if (temp > a[mid]) {
							left = mid;
						} else if (temp <= a[mid]) {
							right = mid;
						}
					}
				}
				if (i - left >= 0) System.arraycopy(a, left, a, left + 1, i - left);
				a[right] = temp;
			}
		}
	}
}