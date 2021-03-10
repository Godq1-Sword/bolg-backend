package org.gdq.learn.sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author gdq
 * date 2020/9/3
 * description 快速排序
 */
public class QuickSort {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = scanner.nextInt();
			}
			quickSort(a, 0, a.length - 1);
			System.out.println(Arrays.toString(a));
		}
	}

	private static void quickSort(int[] a, int left, int right) {
		if (left > right) return;
		int temp = a[left];
		int i = left, j = right;
		while (i != j) {
			while (a[j] >= temp && j > i) j--;
			while (a[i] <= temp && j > i) i++;
			if (i < j) {
				a[i] ^= a[j];
				a[j] ^= a[i];
				a[i] ^= a[j];
			}
		}
		a[left] = a[i];
		a[i] = temp;
		// 分治
		quickSort(a, left, i - 1);
		quickSort(a, i + 1, a.length - 1);
	}
}
