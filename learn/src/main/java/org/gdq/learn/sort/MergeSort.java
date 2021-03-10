package org.gdq.learn.sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author gdq
 * date 2020/9/3
 * description 归并排序
 */
public class MergeSort {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = scanner.nextInt();
			}
			mergeSort(a, 0, a.length - 1);
			System.out.println(Arrays.toString(a));
		}
	}

	private static void mergeSort(int[] a, int left, int right) {
		if (right > left) {
			int mid = (right + left) / 2;
			mergeSort(a, left, mid);
			mergeSort(a, mid + 1, right);
			merge(a, left, right, mid);
		}
	}

	/**
	 * description 合并 left ~ mid+1 | mid ~ right
	 * @author gdq date 2020/9/3
	 * @param a 数组
	 * @param left 起始
	 * @param right 终点
	 * @param mid 中值
	 */
	private static void merge(int[] a, int left, int right, int mid) {
		int l1 = mid - left + 1;
		int l2 = right - mid;
		int[] m1 = new int[l1];
		int[] m2 = new int[l2];
		if (l1 >= 0) System.arraycopy(a, left, m1, 0, l1);
		for (int i = 0; i < l2; i++) {
			m2[i] = a[mid + 1 + i];
		}
		for (int i = 0, j = 0; i + j < l1 + l2; ) {
			if (i >= m1.length) {
				a[left++] = m2[j++];
			} else if (j >= m2.length) {
				a[left++] = m1[i++];
			} else if (m1[i] <= m2[j]) {
				a[left++] = m1[i++];
			} else {
				a[left++] = m2[j++];
			}
		}
	}
}
