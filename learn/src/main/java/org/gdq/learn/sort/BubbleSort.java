package org.gdq.learn.sort;

import java.util.Scanner;

/**
 * @author gdq
 * date 2020/9/2
 * description 冒泡排序 O(n^2)
 */
public class BubbleSort {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = scanner.nextInt();
			}
			bubbleSort(a);
			for (int j : a) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}

	private static void bubbleSort(int[] a) {
		boolean flag = true;
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = 0; j < a.length - i - 1; j++) {
				if (a[j] > a[j + 1]) {
					a[j] ^= a[j + 1];
					a[j + 1] ^= a[j];
					a[j] ^= a[j + 1];
					flag = false;
				}
			}
			if (flag) break;
		}
	}
}
